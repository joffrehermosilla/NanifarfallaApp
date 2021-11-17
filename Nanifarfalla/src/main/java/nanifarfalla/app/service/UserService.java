package nanifarfalla.app.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import nanifarfalla.app.email.EmailSender;
import nanifarfalla.app.email.EmailService;
import nanifarfalla.app.model.Area;
import nanifarfalla.app.model.Cliente;
import nanifarfalla.app.model.Contrato;
import nanifarfalla.app.model.Distrito;
import nanifarfalla.app.model.EstadoCliente;
import nanifarfalla.app.model.EstadoContrato;
import nanifarfalla.app.model.PasswordRessetToken;
import nanifarfalla.app.model.RegimenCliente;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.model.Vendedor;
import nanifarfalla.app.model.VerificationToken;
import nanifarfalla.app.registration.OnRegistrationCompleteEvent;
import nanifarfalla.app.web.dto.UserDto;
import nanifarfalla.app.web.error.UserAlreadyExistException;
import nanifarfalla.app.repository.NewLocationTokenRepository;
import nanifarfalla.app.repository.PasswordResetTokenRepository;
import nanifarfalla.app.repository.RoleRepository;
import nanifarfalla.app.repository.UserLocationRepository;
import nanifarfalla.app.repository.UserRepository;

import nanifarfalla.app.repository.VerificationTokenRepository;
import nanifarfalla.app.security.MyUserDetailsService;
import nanifarfalla.app.service.Impl.ClienteServiceJPA;
import nanifarfalla.app.service.Impl.ContratoServiceJPA;
import nanifarfalla.app.service.Impl.MenuServiceJPA;
import nanifarfalla.app.service.Impl.VendedorServiceJPA;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.sql.Timestamp;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.SimpleMailMessage;

import nanifarfalla.app.model.EstadoUsuario;
import nanifarfalla.app.model.MenuRoles;
import nanifarfalla.app.model.MenuV1;
import nanifarfalla.app.model.NewLocationToken;
import nanifarfalla.app.model.TipoUsuario;
import nanifarfalla.app.model.UserLocation;
import nanifarfalla.app.util.Utileria;

import com.maxmind.geoip2.DatabaseReader;

@Service
@PropertySource(value = { "classpath:application.properties" })
public class UserService implements IUserService, EmailSender, ApplicationListener<OnRegistrationCompleteEvent> {
	private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private VerificationTokenRepository tokenRepository;

	@Autowired
	private PasswordResetTokenRepository passwordTokenRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ClienteServiceJPA clienteservice;

	@Autowired
	private ContratoServiceJPA contratoservice;

	@Autowired
	private VendedorServiceJPA vendedorService;

	@Autowired
	private MenuServiceJPA menuService;

	private EmailSender emailSender;

	private SessionRegistry sessionRegistry;

	private MessageSource messages;

	@Autowired
	private JavaMailSender mailSender;

	//@Autowired
	private MyUserDetailsService myUserDetailService;

	@Autowired
	private Environment env;

	@Autowired
	private UserLocationRepository userLocationRepository;

	@Autowired
	private NewLocationTokenRepository newLocationTokenRepository;

	@Value("${spring.mail.host}")
	private String mailServerHost;

	@Value("${spring.mail.port}")
	private Integer mailServerPort;

	@Value("${spring.mail.username}")
	private String mailServerUsername;

	@Value("${spring.mail.password}")
	private String mailServerPassword;

	@Value("${spring.mail.properties.mail.smtp.auth}")
	private String mailServerAuth;

	@Value("${spring.mail.properties.mail.smtp.starttls.enable}")
	private String mailServerStartTls;

	@Value("${spring.mail.templates.path}")
	private String mailTemplatesPath;

	public static final String TOKEN_INVALID = "invalidToken";
	public static final String TOKEN_EXPIRED = "expired";
	public static final String TOKEN_VALID = "valid";

	public static String QR_PREFIX = "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&chl=";
	public static String APP_NAME = "SpringRegistration";

	// API

	@Override
	public Usuario registerNewUserAccount(final UserDto accountDto) {
		if (emailExists(accountDto.getEmail())) {
			throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
		}
		final Usuario user = new Usuario();

		user.setNombre_usuario(accountDto.getNombre_usuario());

		user.setApellido_usuario(accountDto.getApellido_usuario());

		user.setPassword_usuario(passwordEncoder.encode(accountDto.getPassword_usuario()));
		System.out.println("contraseña encriptada" + user.getPassword_usuario());

		user.setEmail(accountDto.getEmail());

		user.setUsing2FA(accountDto.isUsing2FA());

		user.setmDistrito(accountDto.getDistrito());

		user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_BUYER")));
		System.out.println("Role/es asociados" + user.getRoles());

		return userRepository.save(user);
	}

	@Override
	public Usuario registerNewUserAccount(UserDto accountDto, int role, int distrito, MultipartFile multiPart,
			HttpServletRequest request) throws UserAlreadyExistException {
		if (emailExists(accountDto.getEmail())) {
			throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
		}

		final Usuario user = new Usuario();
		final Usuario userx = new Usuario();
		final Distrito distritox = new Distrito();
		final EstadoUsuario estadousuario = new EstadoUsuario();
		final TipoUsuario tipousuario = new TipoUsuario();

		// Objetos cuando el usuario tiene rol de seller
		final Cliente cliente = new Cliente();
		final RegimenCliente regimencliente = new RegimenCliente();
		final EstadoCliente estadocliente = new EstadoCliente();
		final Contrato kontratox = new Contrato();
		final EstadoContrato estadocontrato = new EstadoContrato();
		final Area area = new Area();
		final Vendedor vendedor = new Vendedor();
		final MenuV1 menuv1 = new MenuV1();
		final MenuV1 menuv1x = new MenuV1();
		final MenuRoles menuroles = new MenuRoles();

		user.setNombre_usuario(accountDto.getNombre_usuario());

		user.setApellido_usuario(accountDto.getApellido_usuario());

		user.setPassword_usuario(passwordEncoder.encode(accountDto.getPassword_usuario()));
		System.out.println("contraseña encriptada: " + user.getPassword_usuario());

		accountDto.setEnabled(false);

		user.setEnabled(accountDto.isEnabled());

		System.out.println("Enabled : " + user.isEnable());

		user.setEmail(accountDto.getEmail());

		user.setUsing2FA(accountDto.isUsing2FA());

		distritox.setCodigo_distrito(distrito);

		accountDto.setDistrito(distritox);

		user.setmDistrito(accountDto.getDistrito());

		estadousuario.setCodigo_estadousuario(1);

		accountDto.setEstadousuario(estadousuario);

		user.setmEstadoUsuario(accountDto.getEstadousuario());

		tipousuario.setCodigo_tipousuario(1);
		accountDto.setTipousuario(tipousuario);
		user.setmTipoUsuario(accountDto.getTipousuario());

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		user.setVersion(timestamp);

		System.out
				.println("Codigo recibido del param = " + distrito + "El distrito elegido es = " + user.getmDistrito());

		if (role == 1) {
			user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_BUYER")));

		} else if (role == 2) {
			user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_SELLER")));

		} else if (role == 3) {
			user.setRoles(
					Arrays.asList(roleRepository.findByName("ROLE_BUYER"), roleRepository.findByName("ROLE_SELLER")));

			estadocliente.setCodigo_estadocliente(1);
			accountDto.setEstadocliente(estadocliente);
			cliente.setmEstadoCliente(accountDto.getEstadocliente());

			regimencliente.setCodigo_regimencliente(1);
			accountDto.setRegimencliente(regimencliente);
			cliente.setmRegimen_cliente(accountDto.getRegimencliente());

			int totalusuario = userRepository.lastcode();

			System.out.println("codigo usuario: " + totalusuario);
			userx.setCodigo_usuario(totalusuario);
			accountDto.setUsuario(userx);
			cliente.setmUsuario(accountDto.getUsuario());

			cliente.setMensaje_cliente(user.getNombre_usuario() + " " + user.getApellido_usuario());

			cliente.setVersion(timestamp);

			System.out.println("Cliente creado " + cliente);
			clienteservice.inserta(cliente);

			estadocontrato.setCodigo_estadoContrato(2);
			accountDto.setEstadocontrato(estadocontrato);
			kontratox.setmEstadoContrato(accountDto.getEstadocontrato());

			int totalcliente = clienteservice.lastcode();
			System.out.println("codigo_cliente " + totalcliente);

			cliente.setCodigo_cliente(totalcliente);
			kontratox.setmCliente(cliente);

			kontratox.setVersion(timestamp);
			kontratox.setDescripcion(cliente.getMensaje_cliente());
			kontratox.setmUsuario(accountDto.getUsuario());

			System.out.println("Contrato creado " + kontratox);
			contratoservice.guardar(kontratox);

			// contratorepository.save(kontratox);

			vendedor.setmUsuario(accountDto.getUsuario());

			area.setCodigo_area(1);
			accountDto.setArea(area);
			vendedor.setmArea(accountDto.getArea());
			System.out.println("Vendedor creado " + kontratox);
			// vendedorrepository.save(vendedor);
			vendedor.setVersion(timestamp);
			vendedorService.guardar(vendedor);

		}

		System.out.println("Role/es asociados" + user.getRoles());

		int cantidadmenu = menuService.buscarTodas().size();
		int codigomenu = cantidadmenu + 1;
		System.out.println("codigo menu generado: " + codigomenu);
		menuv1.setId(codigomenu);
		accountDto.setMenuv1(menuv1);
		menuv1.setmMenuV1(accountDto.getMenuv1());
		menuv1x.setId(2);
		menuv1.setmMenuV1(menuv1x);
		menuv1.setLft(2);
		menuv1.setRgt(codigomenu + menuv1.getLft());
		int usuariocreado = 1 + userRepository.findAll().size();
		menuv1.setNombre("Usuarios registrados: " + usuariocreado);

		menuv1.setVersion(timestamp);
		int ultimomenu = menuService.lascode() + 1;
		System.out.println("ultimomenu: " + ultimomenu);
		/*
		 * if(codigomenu ==ultimomenu) { menuService.updatemenu(menuv1.getNombre(),
		 * codigomenu); }else { menuService.guardar(menuv1); }
		 */
		menuService.guardar(menuv1);
		int totalusuario = userRepository.lastcode() + 1;
		int totalcliente = clienteservice.lastcode() + 1;
		int totalcantrato = contratoservice.lastcode() + 1;

		if (!multiPart.isEmpty()) {
			String ruta = "/resources/images/usuarios/" + userx.getCodigo_usuario() + "/" + cliente.getCodigo_cliente()
					+ "/" + kontratox.getCodigo_contrato() + "/";
			String rutax = "/resources/images/usuarios/" + totalusuario + "/" + totalcliente + "/" + totalcantrato
					+ "/";

			System.out.println("ruta: " + ruta);

			System.out.println("rutax: " + rutax);
			String nombreImagen = Utileria.guardarImagenPlus(multiPart, request, rutax);
			user.setRuta_foto(nombreImagen);
			accountDto.setRuta_foto(user.getRuta_foto());

		}

		myUserDetailService.signUpUser(new Usuario(accountDto.getNombre_usuario(), accountDto.getApellido_usuario(),
				accountDto.getPassword_usuario(), accountDto.getEmail(), accountDto.isEnabled(), user.getRoles()));

		System.out.println("Desde UserService request.getLocal():" + request.getLocale());
		System.out.println("Desde UserService getAppUrl(request):" + getAppUrl(request));

		// OnRegistrationCompleteEvent event = new OnRegistrationCompleteEvent(user,
		// request.getLocale(), getAppUrl(request));

		/*
		 * final String confirmationUrl = getAppUrl(request) + "/usuarios/save?token=" ;
		 * System.out.println("cofirmationUrl " + confirmationUrl);
		 * emailSender.send(user.getEmail(), buildEmail(user.getNombre_usuario(),
		 * confirmationUrl));
		 */

		return userRepository.save(user);
	}

	@Override
	public String registerNewUserAccountString(UserDto accountDto, int role, int distrito, MultipartFile multiPart,
			HttpServletRequest request) throws UserAlreadyExistException {
		if (emailExists(accountDto.getEmail())) {
			throw new UserAlreadyExistException("There is an account with that email adress: " + accountDto.getEmail());
		}

		final Usuario user = new Usuario();
		final Usuario userx = new Usuario();
		final Distrito distritox = new Distrito();
		final EstadoUsuario estadousuario = new EstadoUsuario();
		final TipoUsuario tipousuario = new TipoUsuario();

		// Objetos cuando el usuario tiene rol de seller
		final Cliente cliente = new Cliente();
		final RegimenCliente regimencliente = new RegimenCliente();
		final EstadoCliente estadocliente = new EstadoCliente();
		final Contrato kontratox = new Contrato();
		final EstadoContrato estadocontrato = new EstadoContrato();
		final Area area = new Area();
		final Vendedor vendedor = new Vendedor();
		final MenuV1 menuv1 = new MenuV1();
		final MenuV1 menuv1x = new MenuV1();
		final MenuRoles menuroles = new MenuRoles();

		user.setNombre_usuario(accountDto.getNombre_usuario());

		user.setApellido_usuario(accountDto.getApellido_usuario());

		user.setPassword_usuario(passwordEncoder.encode(accountDto.getPassword_usuario()));
		System.out.println("contraseña encriptada" + user.getPassword_usuario());

		accountDto.setEnabled(false);

		user.setEnabled(accountDto.isEnabled());

		System.out.println("Enabled: " + user.isEnable());

		user.setEmail(accountDto.getEmail());

		user.setUsing2FA(accountDto.isUsing2FA());

		distritox.setCodigo_distrito(distrito);

		accountDto.setDistrito(distritox);

		user.setmDistrito(accountDto.getDistrito());

		estadousuario.setCodigo_estadousuario(1);

		accountDto.setEstadousuario(estadousuario);

		user.setmEstadoUsuario(accountDto.getEstadousuario());

		tipousuario.setCodigo_tipousuario(1);
		accountDto.setTipousuario(tipousuario);
		user.setmTipoUsuario(accountDto.getTipousuario());

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		user.setVersion(timestamp);

		System.out
				.println("Codigo recibido del param = " + distrito + "El distrito elegido es = " + user.getmDistrito());

		if (role == 1) {
			user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_BUYER")));

		} else if (role == 2) {
			user.setRoles(Arrays.asList(roleRepository.findByName("ROLE_SELLER")));

		} else if (role == 3) {
			user.setRoles(
					Arrays.asList(roleRepository.findByName("ROLE_BUYER"), roleRepository.findByName("ROLE_SELLER")));

			estadocliente.setCodigo_estadocliente(1);
			accountDto.setEstadocliente(estadocliente);
			cliente.setmEstadoCliente(accountDto.getEstadocliente());

			regimencliente.setCodigo_regimencliente(1);
			accountDto.setRegimencliente(regimencliente);
			cliente.setmRegimen_cliente(accountDto.getRegimencliente());

			int totalusuario = userRepository.lastcode();

			System.out.println("codigo usuario: " + totalusuario);
			userx.setCodigo_usuario(totalusuario);
			accountDto.setUsuario(userx);
			cliente.setmUsuario(accountDto.getUsuario());

			cliente.setMensaje_cliente(user.getNombre_usuario() + " " + user.getApellido_usuario());

			cliente.setVersion(timestamp);

			System.out.println("Cliente creado " + cliente);
			clienteservice.inserta(cliente);

			estadocontrato.setCodigo_estadoContrato(2);
			accountDto.setEstadocontrato(estadocontrato);
			kontratox.setmEstadoContrato(accountDto.getEstadocontrato());

			int totalcliente = clienteservice.lastcode();
			System.out.println("codigo_cliente " + totalcliente);

			cliente.setCodigo_cliente(totalcliente);
			kontratox.setmCliente(cliente);

			kontratox.setVersion(timestamp);
			kontratox.setDescripcion(cliente.getMensaje_cliente());
			kontratox.setmUsuario(accountDto.getUsuario());

			System.out.println("Contrato creado " + kontratox);
			contratoservice.guardar(kontratox);

			// contratorepository.save(kontratox);

			vendedor.setmUsuario(accountDto.getUsuario());

			area.setCodigo_area(1);
			accountDto.setArea(area);
			vendedor.setmArea(accountDto.getArea());
			System.out.println("Vendedor creado " + kontratox);
			// vendedorrepository.save(vendedor);
			vendedor.setVersion(timestamp);
			vendedorService.guardar(vendedor);

		}

		System.out.println("Role/es asociados" + user.getRoles());

		int cantidadmenu = menuService.buscarTodas().size();
		int codigomenu = cantidadmenu + 1;
		System.out.println("codigo menu generado: " + codigomenu);
		menuv1.setId(codigomenu);
		accountDto.setMenuv1(menuv1);
		menuv1.setmMenuV1(accountDto.getMenuv1());
		menuv1x.setId(2);
		menuv1.setmMenuV1(menuv1x);
		menuv1.setLft(2);
		menuv1.setRgt(codigomenu + menuv1.getLft());
		int usuariocreado = 1 + userRepository.findAll().size();
		menuv1.setNombre("Usuarios registrados: " + usuariocreado);

		menuv1.setVersion(timestamp);
		int ultimomenu = menuService.lascode() + 1;
		System.out.println("ultimomenu: " + ultimomenu);
		/*
		 * if(codigomenu ==ultimomenu) { menuService.updatemenu(menuv1.getNombre(),
		 * codigomenu); }else { menuService.guardar(menuv1); }
		 */
		menuService.guardar(menuv1);
		int totalusuario = userRepository.lastcode() + 1;
		int totalcliente = clienteservice.lastcode() + 1;
		int totalcantrato = contratoservice.lastcode() + 1;

		if (!multiPart.isEmpty()) {
			String ruta = "/resources/images/usuarios/" + userx.getCodigo_usuario() + "/" + cliente.getCodigo_cliente()
					+ "/" + kontratox.getCodigo_contrato() + "/";
			String rutax = "/resources/images/usuarios/" + totalusuario + "/" + totalcliente + "/" + totalcantrato
					+ "/";

			System.out.println("ruta: " + ruta);

			System.out.println("rutax: " + rutax);
			String nombreImagen = Utileria.guardarImagenPlus(multiPart, request, rutax);
			user.setRuta_foto(nombreImagen);
			accountDto.setRuta_foto(user.getRuta_foto());

		}

		myUserDetailService.signUpUser(new Usuario(accountDto.getNombre_usuario(), accountDto.getApellido_usuario(),
				accountDto.getPassword_usuario(), accountDto.getEmail(), accountDto.isEnabled(), user.getRoles()));

		// OnRegistrationCompleteEvent event = new OnRegistrationCompleteEvent(user,
		// request.getLocale(), getAppUrl(request));

		// final String confirmationUrl = getAppUrl(request) + "/usuarios/save?token=" ;

		final String token = UUID.randomUUID().toString();
		createVerificationTokenForUser(user, token);

		System.out.println("probando si el listener escucha token generado desde el UserService: " + token);

		System.out.println("event.getLocal():" + request.getLocale());
		System.out.println("getAppUrl(request):" + getAppUrl(request));
		final String confirmationUrl = getAppUrl(request) + "/usuarios/registrationConfirm?token=" + token;
		// emailSender.send(accountDto.getEmail(),
		// buildEmail(accountDto.getNombre_usuario(), getAppUrl(request)));
		System.out.println("cofirmationUrl " + confirmationUrl);

		emailSender.send(user.getEmail(), buildEmail(user.getNombre_usuario(), confirmationUrl));

		return token;
	}

	@Override
	public Usuario getUser(final String verificationToken) {
		final VerificationToken token = tokenRepository.findByToken(verificationToken);
		if (token != null) {
			return token.getUser();
		}
		return null;
	}

	@Override
	public VerificationToken getVerificationToken(final String VerificationToken) {
		return tokenRepository.findByToken(VerificationToken);
	}

	@Override
	public void saveRegisteredUser(final Usuario user) {
		userRepository.save(user);
	}

	@Override
	public void deleteUser(final Usuario user) {
		final VerificationToken verificationToken = tokenRepository.findByUser(user);

		if (verificationToken != null) {
			tokenRepository.delete(verificationToken);
		}

		final PasswordRessetToken passwordToken = passwordTokenRepository.findByUser(user);

		if (passwordToken != null) {
			passwordTokenRepository.delete(passwordToken);
		}

		userRepository.delete(user);
	}

	@Override
	public void createVerificationTokenForUser(final Usuario user, final String token) {
		final VerificationToken myToken = new VerificationToken(token, user);
		myToken.setmUsuario(user);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		myToken.setVersion(timestamp);
		System.out.println("Creacion del toke desde el void crateVerificationTokenForUser en UserService:" + myToken);
		tokenRepository.save(myToken);
	}

	@Override
	public VerificationToken generateNewVerificationToken(final String existingVerificationToken) {
		VerificationToken vToken = tokenRepository.findByToken(existingVerificationToken);
		vToken.updateToken(UUID.randomUUID().toString());
		vToken = tokenRepository.save(vToken);
		return vToken;
	}

	@Override
	public void createPasswordResetTokenForUser(final Usuario user, final String token) {
		final PasswordRessetToken myToken = new PasswordRessetToken(token, user);
		passwordTokenRepository.save(myToken);
	}

	@Override
	public Usuario findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public PasswordRessetToken getPasswordResetToken(final String token) {
		return passwordTokenRepository.findByToken(token);
	}

	@Override
	public Usuario getUserByPasswordResetToken(final String token) {
		return passwordTokenRepository.findByToken(token).getUser();
	}

	@Override
	public Optional<Usuario> getUserByID(final int id) {
		return userRepository.findById(id);
	}

	@Override
	public void changeUserPassword(final Usuario user, final String password) {
		user.setPassword_usuario(passwordEncoder.encode(password));
		userRepository.save(user);
	}

	@Override
	public boolean checkIfValidOldPassword(final Usuario user, final String oldPassword) {
		return passwordEncoder.matches(oldPassword, user.getPassword_usuario());
	}

	@Override
	public String validateVerificationToken(String token) {
		final VerificationToken verificationToken = tokenRepository.findByToken(token);
		if (verificationToken == null) {
			return TOKEN_INVALID;
		}

		final Usuario user = verificationToken.getUser();
		final Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			tokenRepository.delete(verificationToken);
			return TOKEN_EXPIRED;
		}

		user.setEnabled(true);
		// tokenRepository.delete(verificationToken);
		userRepository.save(user);
		return TOKEN_VALID;
	}

	@Override
	public String generateQRUrl(Usuario user) throws UnsupportedEncodingException {
		return QR_PREFIX + URLEncoder.encode(String.format("otpauth://totp/%s:%s?secret=%s&issuer=%s", APP_NAME,
				user.getEmail(), user.getSecret(), APP_NAME), "UTF-8");
	}

	@Override
	public Usuario updateUser2FA(boolean use2FA) {
		final Authentication curAuth = SecurityContextHolder.getContext().getAuthentication();
		Usuario currentUser = (Usuario) curAuth.getPrincipal();
		currentUser.setUsing2FA(use2FA);
		currentUser = userRepository.save(currentUser);
		final Authentication auth = new UsernamePasswordAuthenticationToken(currentUser,
				currentUser.getPassword_usuario(), curAuth.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		return currentUser;
	}

	@Override
	public boolean emailExists(final String email) {
		return userRepository.findByEmail(email) != null;
	}

	@Override
	public List<String> getUsersFromSessionRegistry() {
		return sessionRegistry.getAllPrincipals().stream()
				.filter((u) -> !sessionRegistry.getAllSessions(u, false).isEmpty()).map(o -> {
					if (o instanceof Usuario) {
						return ((Usuario) o).getEmail();
					} else {
						return o.toString();
					}
				}).collect(Collectors.toList());

	}

	@Override
	public List<Usuario> buscarTodas() {

		return userRepository.findAll();
	}

	@Override
	public void guardar(Usuario usuario) {
		userRepository.save(usuario);

	}

	@Override
	public List<Usuario> findByCorreo(String email) {

		return userRepository.findByCorreo(email);
	}

	@Override
	public List<Usuario> BuscarEmailParam(String email) {
		// TODO Auto-generated method stub
		return userRepository.BuscarEmailParam(email);
	}

	private String buildEmail(String name, String link) {
		return "<div style=\"font-family:Helvetica,Arial,sans-serif;font-size:16px;margin:0;color:#0b0c0c\">\n" + "\n"
				+ "<span style=\"display:none;font-size:1px;color:#fff;max-height:0\"></span>\n" + "\n"
				+ "  <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;min-width:100%;width:100%!important\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n"
				+ "    <tbody><tr>\n" + "      <td width=\"100%\" height=\"53\" bgcolor=\"#0b0c0c\">\n" + "        \n"
				+ "        <table role=\"presentation\" width=\"100%\" style=\"border-collapse:collapse;max-width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"center\">\n"
				+ "          <tbody><tr>\n" + "            <td width=\"70\" bgcolor=\"#0b0c0c\" valign=\"middle\">\n"
				+ "                <table role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n"
				+ "                  <tbody><tr>\n" + "                    <td style=\"padding-left:10px\">\n"
				+ "                  \n" + "                    </td>\n"
				+ "                    <td style=\"font-size:28px;line-height:1.315789474;Margin-top:4px;padding-left:10px\">\n"
				+ "                      <span style=\"font-family:Helvetica,Arial,sans-serif;font-weight:700;color:#ffffff;text-decoration:none;vertical-align:top;display:inline-block\">Confirm your email</span>\n"
				+ "                    </td>\n" + "                  </tr>\n" + "                </tbody></table>\n"
				+ "              </a>\n" + "            </td>\n" + "          </tr>\n" + "        </tbody></table>\n"
				+ "        \n" + "      </td>\n" + "    </tr>\n" + "  </tbody></table>\n"
				+ "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n"
				+ "    <tbody><tr>\n" + "      <td width=\"10\" height=\"10\" valign=\"middle\"></td>\n"
				+ "      <td>\n" + "        \n"
				+ "                <table role=\"presentation\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse\">\n"
				+ "                  <tbody><tr>\n"
				+ "                    <td bgcolor=\"#1D70B8\" width=\"100%\" height=\"10\"></td>\n"
				+ "                  </tr>\n" + "                </tbody></table>\n" + "        \n" + "      </td>\n"
				+ "      <td width=\"10\" valign=\"middle\" height=\"10\"></td>\n" + "    </tr>\n"
				+ "  </tbody></table>\n" + "\n" + "\n" + "\n"
				+ "  <table role=\"presentation\" class=\"m_-6186904992287805515content\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"border-collapse:collapse;max-width:580px;width:100%!important\" width=\"100%\">\n"
				+ "    <tbody><tr>\n" + "      <td height=\"30\"><br></td>\n" + "    </tr>\n" + "    <tr>\n"
				+ "      <td width=\"10\" valign=\"middle\"><br></td>\n"
				+ "      <td style=\"font-family:Helvetica,Arial,sans-serif;font-size:19px;line-height:1.315789474;max-width:560px\">\n"
				+ "        \n"
				+ "            <p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\">Hi " + name
				+ ",</p><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> Thank you for registering. Please click on the below link to activate your account: </p><blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\"><p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> <a href=\""
				+ link + "\">Activate Now</a> </p></blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>"
				+ "        \n" + "      </td>\n" + "      <td width=\"10\" valign=\"middle\"><br></td>\n"
				+ "    </tr>\n" + "    <tr>\n" + "      <td height=\"30\"><br></td>\n" + "    </tr>\n"
				+ "  </tbody></table><div class=\"yj6qo\"></div><div class=\"adL\">\n" + "\n" + "</div></div>";
	}

	@Override
	public void onApplicationEvent(final OnRegistrationCompleteEvent event) {
		this.confirmRegistrationx(event);
		System.out.println("On Application Event");
	}

	private void confirmRegistrationx(final OnRegistrationCompleteEvent event) {
		final Usuario user = event.getUser();
		final String token = UUID.randomUUID().toString();
		System.out.println("Usuario generado por event.getUser del confirmRegistrtation: " + user + " " + event);
		System.out.println("probando si el listener escucha token generado: " + token);

		System.out.println("event.getLocal():" + event.getLocale());
		System.out.println("getAppUrl(request):" + event.getAppUrl());
		createVerificationTokenForUser(user, token);
		final String confirmationUrl = event.getAppUrl() + "/usuarios/registrationConfirm?token=" + token;

		System.out.println("Desde el void En UserService cofirmationUrl " + confirmationUrl);

		System.out.println("probando si el listener escucha token generado de UsuarioService: " + token);

		send(user.getEmail(), buildEmail(user.getNombre_usuario(), confirmationUrl));

	}

	private void confirmRegistration(final OnRegistrationCompleteEvent event) {

		final Usuario usert = event.getUser();
		final String token = UUID.randomUUID().toString();
		createVerificationTokenForUser(usert, token);
		System.out.println("Usuario generado por event.getUser del confirmRegistrtation: " + usert + " " + event);
		System.out.println("probando si el listener escucha token generado: " + token);

		System.out.println("event.getLocal():" + event.getLocale());
		System.out.println("getAppUrl(request):" + event.getAppUrl());
		final String confirmationUrl = event.getAppUrl() + "/usuarios/registrationConfirm?token=" + token;

		System.out.println("Desde el void En UserService cofirmationUrl " + confirmationUrl);
		SimpleMailMessage email = new SimpleMailMessage();

		final String recipientAddress = usert.getEmail();
		final String subject = "Nanifarfalla Registration Confirmation";

		final String message = messages.getMessage("message.regSucc", null, event.getLocale());
		email.setTo(recipientAddress);
		email.setSubject(subject);
		email.setText(message + " \r\n" + confirmationUrl);
		email.setFrom(env.getProperty("support.email"));

		emailSender.send(usert.getNombre_usuario(), buildEmail(usert.getNombre_usuario(), confirmationUrl));

	}

	private SimpleMailMessage constructEmailMessage(final OnRegistrationCompleteEvent event, final Usuario user,
			final String token) {
		final String recipientAddress = user.getEmail();
		final String subject = "Registration Confirmation from Nanifarfalla";
		final String confirmationUrl = event.getAppUrl() + "/usuarios/registrationConfirm?token=" + token;
		final String message = messages.getMessage("message.regSucc", null, event.getLocale());
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(recipientAddress);
		email.setSubject(subject);
		// email.setText(buildEmail(user.getNombre_usuario(), confirmationUrl) + " \r\n"
		// + confirmationUrl);
		email.setText(message + " \r\n" + confirmationUrl);

		email.setFrom(env.getProperty("support.email"));
		return email;
	}

	private String getAppUrl(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}

	@Override
	public NewLocationToken isNewLoginLocation(String username, String ip) {

		/*
		 * if(!isGeoIpLibEnabled()) { return null; }
		 * 
		 * try { final InetAddress ipAddress = InetAddress.getByName(ip); final String
		 * country = databaseReader.country(ipAddress) .getCountry() .getName();
		 * System.out.println(country + "====****"); final Usuario user =
		 * userRepository.findByEmail(username); final UserLocation loc =
		 * userLocationRepository.findByCountryAndUser(country, user); if ((loc == null)
		 * || !loc.isEnabled()) { return createNewLocationToken(country, user); } }
		 * catch (final Exception e) { return null; }
		 */
		return null;
	}

	private boolean isGeoIpLibEnabled() {
		return Boolean.parseBoolean(env.getProperty("geo.ip.lib.enabled"));
	}

	private NewLocationToken createNewLocationToken(String country, Usuario user) {
		UserLocation loc = new UserLocation(country, user);
		loc = userLocationRepository.save(loc);

		final NewLocationToken token = new NewLocationToken(UUID.randomUUID().toString(), loc);
		return newLocationTokenRepository.save(token);
	}

	@Override
	public String isValidNewLocationToken(String token) {
		final NewLocationToken locToken = newLocationTokenRepository.findByToken(token);
		if (locToken == null) {
			return null;
		}
		UserLocation userLoc = locToken.getUserLocation();
		userLoc.setEnabled(true);
		userLoc = userLocationRepository.save(userLoc);
		newLocationTokenRepository.delete(locToken);
		return userLoc.getCountry();
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		// mailSender.setHost(mailServerHost);
		// mailSender.setPort(mailServerPort);
		mailSender.setPort(587);

		mailSender.setUsername("nanifarfalla@gmail.com");
		mailSender.setPassword("rqvzxlrrwuacbxdz");

		// mailSender.setUsername(mailServerUsername);
		// mailSender.setPassword(mailServerPassword);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.auth", mailServerAuth);
		props.put("mail.smtp.starttls.enable", "true");
		// props.put("mail.smtp.starttls.enable", mailServerStartTls);
		props.put("mail.debug", "true");

		return mailSender;
	}

	@Override
	public void send(String to, String email) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
			helper.setText(email, true);
			helper.setTo(to);
			helper.setSubject("Confirm your email");
			helper.setFrom("MailVerification@nanifarfalla.com.pe");
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			LOGGER.error("failed to send email", e);
			throw new IllegalStateException("failed to send email");
		}

	}

	/*
	 * @Bean public JavaMailSender getJavaMailSenderx() { JavaMailSenderImpl
	 * mailSender = new JavaMailSenderImpl();
	 * 
	 * mailSender.setHost(mailServerHost); mailSender.setPort(mailServerPort);
	 * 
	 * mailSender.setUsername(mailServerUsername);
	 * mailSender.setPassword(mailServerPassword);
	 * 
	 * Properties props = mailSender.getJavaMailProperties();
	 * props.put("mail.transport.protocol", "smtp"); props.put("mail.smtp.auth",
	 * mailServerAuth); props.put("mail.smtp.starttls.enable", mailServerStartTls);
	 * props.put("mail.debug", "true");
	 * 
	 * return mailSender; }
	 */
}
