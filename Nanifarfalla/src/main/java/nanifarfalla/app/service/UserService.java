package nanifarfalla.app.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

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
import nanifarfalla.app.web.dto.UserDto;
import nanifarfalla.app.web.error.UserAlreadyExistException;

import nanifarfalla.app.repository.PasswordResetTokenRepository;
import nanifarfalla.app.repository.RoleRepository;
import nanifarfalla.app.repository.UserRepository;

import nanifarfalla.app.repository.VerificationTokenRepository;
import nanifarfalla.app.service.Impl.ClienteServiceJPA;
import nanifarfalla.app.service.Impl.ContratoServiceJPA;
import nanifarfalla.app.service.Impl.MenuServiceJPA;
import nanifarfalla.app.service.Impl.VendedorServiceJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

import nanifarfalla.app.model.EstadoUsuario;
import nanifarfalla.app.model.MenuRoles;
import nanifarfalla.app.model.MenuV1;
import nanifarfalla.app.model.TipoUsuario;

import nanifarfalla.app.util.Utileria;

@Service
public class UserService implements IUserService {

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

	private SessionRegistry sessionRegistry;

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
		System.out.println("contraseña encriptada" + user.getPassword_usuario());

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
			
			System.out.println("codigo usuario: "+totalusuario);
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
			System.out.println("codigo_cliente "+totalcliente);
			
			cliente.setCodigo_cliente(totalcliente );
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
		menuService.guardar(menuv1);
		int totalusuario = userRepository.lastcode()+1;
		int totalcliente = clienteservice.lastcode() + 1;
		int totalcantrato = contratoservice.lastcode() + 1;

		if (!multiPart.isEmpty()) {
			String ruta = "/resources/images/usuarios/" + userx.getCodigo_usuario() + "/" + cliente.getCodigo_cliente()
					+ "/" + kontratox.getCodigo_contrato() + "/";
			String rutax = "/resources/images/usuarios/" + totalusuario + "/" + totalcliente
			+ "/" +totalcantrato  + "/";
			
			System.out.println("ruta: "+ruta);
			
			System.out.println("rutax: "+rutax);
			String nombreImagen = Utileria.guardarImagenPlus(multiPart, request, rutax);
			user.setRuta_foto(nombreImagen);
			accountDto.setRuta_foto(user.getRuta_foto());

		}

		return userRepository.save(user);
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



}
