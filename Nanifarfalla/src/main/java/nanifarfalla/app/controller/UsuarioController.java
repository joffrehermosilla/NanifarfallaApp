package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import org.springframework.validation.Errors;
import lombok.AllArgsConstructor;
import nanifarfalla.app.email.EmailSender;
import nanifarfalla.app.model.Ciudad;
import nanifarfalla.app.model.Distrito;

import nanifarfalla.app.model.Privilege;
import nanifarfalla.app.model.Provincia;
import nanifarfalla.app.model.Role;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.model.VerificationToken;
import nanifarfalla.app.service.ICiudadService;
import nanifarfalla.app.service.IDistritoService;
import nanifarfalla.app.service.IPaisService;
import nanifarfalla.app.service.IProvinciaService;
import nanifarfalla.app.service.IUserService;

import nanifarfalla.app.web.dto.PasswordDto;
import nanifarfalla.app.web.dto.UserDto;
import nanifarfalla.app.web.error.InvalidOldPasswordException;
import nanifarfalla.app.web.error.UserAlreadyExistException;
import nanifarfalla.app.web.util.GenericResponse;

import javax.validation.Valid;
import nanifarfalla.app.registration.OnRegistrationCompleteEvent;

import nanifarfalla.app.security.ISecurityUserService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
//@Controller
@AllArgsConstructor
//@ConfigurationProperties(value = "classpath:your-filename.yml")
@RequestMapping("/usuarios")
public class UsuarioController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUserService userService;

	@Autowired
	private IPaisService paisService;

	@Autowired
	private IProvinciaService provinciaService;

	@Autowired
	private ICiudadService ciudadService;

	@Autowired
	private IDistritoService distritoService;

	@Autowired
	private MessageSource messages;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	private AuthenticationManager authenticationManager;

	@Autowired
	private Environment env;

	private ISecurityUserService securityUserService;

	private JavaMailSender mailSender;

	@GetMapping(value = "/create")
	public ModelAndView crear(@ModelAttribute Usuario usuario, Model model, BindingResult bindingResult) {

		model.addAttribute("listapais", paisService.buscarTodas());

		if (bindingResult.hasErrors()) {
			return  new ModelAndView("/usuarios/formUsuario", "user", usuario);
		}

		return  new ModelAndView("/usuarios/formUsuario", "user", usuario);
	}

	@GetMapping(value = "/registrar")
	public String registrar(@ModelAttribute Usuario usuario) {

		return "/login/registration";
	}

	@RequestMapping(value = "/cargarPais/{codigo_pais}", method = RequestMethod.GET)
	@ResponseBody
	public String cargarPais(@PathVariable("codigo_pais") int codigo_pais, HttpServletResponse response) {

		System.out.println("cargarPais path variable /" + codigo_pais);
		Gson gson = new Gson();
		response.setContentType("text/plain;charset=UTF-8");
		return gson.toJson(provinciaService.findByPaisIdParamsNative(codigo_pais));
		// return "" + provinciaService.findByPaisIdParamsNative(codigo_pais);
	}

	@RequestMapping(value = "/cargarProvincia/{codigo_provincia}", method = RequestMethod.GET)
	@ResponseBody
	public String cargarProvincia(@PathVariable("codigo_provincia") int codigo_provincia,
			HttpServletResponse response) {

		System.out.println("cargarProvincia path variable /" + codigo_provincia);
		Gson gson = new Gson();
		response.setContentType("text/plain;charset=UTF-8");
		// return
		// gson.toJson(provinciaService.findByPaisIdParamsNative(codigo_provincia));

		return gson.toJson(ciudadService.findByProvinciaIdParamsNative(codigo_provincia));
		// return "" + provinciaService.findByPaisIdParamsNative(codigo_pais);
	}

	@RequestMapping(value = "/cargarCiudad/{codigo_ciudad}", method = RequestMethod.GET)
	@ResponseBody
	public String cargarCiudad(@PathVariable("codigo_ciudad") int codigo_ciudad, HttpServletResponse response) {

		System.out.println("cargarCiudad path variable /" + codigo_ciudad);
		Gson gson = new Gson();
		response.setContentType("text/plain;charset=UTF-8");
		// return
		// gson.toJson(provinciaService.findByPaisIdParamsNative(codigo_provincia));

		// return
		// gson.toJson(ciudadService.findByProvinciaIdParamsNative(codigo_provincia));
		// return "" + provinciaService.findByPaisIdParamsNative(codigo_pais);

		return gson.toJson(distritoService.findByCiudadIdParamsNative(codigo_ciudad));
	}

	@GetMapping("/cargarPais")
	@ResponseBody
	public String cargarPaispost(@RequestParam("country") int codigo_pais) {
		Gson gson = new Gson();
		System.out.println("cargarPais RequestParam  /" + codigo_pais);
		return gson.toJson(provinciaService.findByPaisIdParamsNative(codigo_pais));
	}

	@GetMapping(value = "/buscarPorPais")
	public @ResponseBody List<Provincia> buscarPorPais(@RequestParam("idPais") int idPais) {
		System.out.println("buscarPorPais/" + idPais);
		// return provinciaService.findByFkcodigo_pais(idPais);
		// return provinciaService.findByPaisIdParamsNative(idPais);
		// return provinciaService.BuscaPaisporClase(idPais);

		// return provinciaService.findByCountry(idPais);

		return provinciaService.BuscarPaisClaseconParam(idPais);

	}

	@GetMapping(value = "/buscarPorProvincia")
	public @ResponseBody List<Ciudad> buscarPorProvincia(@RequestParam("idProvincia") int idProvincia) {
		System.out.println("buscarPorProvincia/" + idProvincia);
		// return provinciaService.findByFkcodigo_pais(idPais);
		// return provinciaService.findByPaisIdParamsNative(idPais);
		// return provinciaService.BuscaPaisporClase(idPais);

		// return provinciaService.findByCountry(idPais);

		// return provinciaService.BuscarPaisClaseconParam(idProvincia);

		return ciudadService.BuscarProvinciaClaseconParam(idProvincia);

	}

	@GetMapping(value = "/buscarPorCiudad")
	public @ResponseBody List<Distrito> buscarPorCiudad(@RequestParam("idCiudad") int idCiudad) {
		System.out.println("buscarPorCiudad/" + idCiudad);
		// return provinciaService.findByFkcodigo_pais(idPais);
		// return provinciaService.findByPaisIdParamsNative(idPais);
		// return provinciaService.BuscaPaisporClase(idPais);

		// return provinciaService.findByCountry(idPais);

		// return provinciaService.BuscarPaisClaseconParam(idProvincia);

		// return ciudadService.BuscarProvinciaClaseconParam(idProvincia);
		return distritoService.BuscarCiudadClaseconParam(idCiudad);
	}

	@GetMapping(value = "/buscarPorEmail")
	public @ResponseBody Usuario buscarPorEmail(@RequestParam("email") String email) {
		System.out.println("buscarPorEmail   " + email);
		// return provinciaService.findByFkcodigo_pais(idPais);
		// return provinciaService.findByPaisIdParamsNative(idPais);
		// return provinciaService.BuscaPaisporClase(idPais);

		// return provinciaService.findByCountry(idPais);

		return userService.findUserByEmail(email);

	}

	@RequestMapping(value = "/cargarCorreo/{email}", method = RequestMethod.GET)
	@ResponseBody
	public String cargarCorreo(@PathVariable("email") String email, HttpServletResponse response) {

		System.out.println("cargarCorreo path variable /" + email);
		Gson gson = new Gson();
		response.setContentType("text/plain;charset=UTF-8");
		return gson.toJson(userService.findByCorreo(email));
		// return "" + provinciaService.findByPaisIdParamsNative(codigo_pais);
	}

	@GetMapping(value = "/buscarPorCorreo")
	public @ResponseBody String buscarPorEmailList(@RequestParam("email") String email, RedirectAttributes attributes,
			Model model) {
		System.out.println("buscarPorCorreo   " + email);
		ModelAndView mv = new ModelAndView();

		String mensajemail = " mail actualmente registrado usar otro ";

		String mensajemailx = "mail no registrado previamente continuar...";

		if (userService.emailExists(email) == true) {
			model.addAttribute("confirmacion", userService.emailExists(email));
			mv.addObject("confirmacion", userService.emailExists(email));
			model.addAttribute("mensajemail", mensajemail);

			attributes.addFlashAttribute("mensaje", mensajemail);
			mv.addObject("mensajemail", mensajemail);
			System.out.println("resultado Boolean " + userService.emailExists(email));
			System.out.println(" " + mensajemail);
		} else {
			model.addAttribute("confirmacion", userService.emailExists(email));
			mv.addObject("confirmacion", userService.emailExists(email));
			model.addAttribute("mensajemail", mensajemailx);
			attributes.addFlashAttribute("mensaje", mensajemailx);
			mv.addObject("mensajemail", mensajemailx);
			System.out.println("resultado Boolean " + userService.emailExists(email));
			System.out.println(" " + mensajemailx);
		}

		return "" + userService.emailExists(email);

	}

	@GetMapping(value = "/buscarPorMail")
	public @ResponseBody List<Usuario> buscarPorEmailListx(@RequestParam("email") String email) {
		System.out.println("buscarPorMail   " + email);
		// return provinciaService.findByFkcodigo_pais(idPais);
		// return provinciaService.findByPaisIdParamsNative(idPais);
		// return provinciaService.BuscaPaisporClase(idPais);

		// return provinciaService.findByCountry(idPais);
		// System.out.println("List desde Query native CLase" +
		// userService.findByCorreo(email));
		// System.out.println("List desde Query Param " +
		// userService.BuscarEmailParam(email));

		// return userService.BuscarEmailParam(email);

		return userService.findByCorreo(email);

	}

	@PostMapping(value = "/save")
	@ResponseBody
	public ModelAndView guardar(@Valid final UserDto accountDto, @RequestParam("archivoImagen") MultipartFile multiPart,
			Model model, BindingResult result, RedirectAttributes attributes, HttpServletRequest request,
			@RequestParam("role") String role, @RequestParam("idDistrito") int idDistrito) throws IOException {
		/*
		 * @PostMapping(value = "/save")
		 * 
		 * @ResponseBody public GenericResponse guardar(@Valid final UserDto accountDto,
		 * Model model, BindingResult result, RedirectAttributes attributes,
		 * HttpServletRequest request, @RequestParam("role") String role,
		 * 
		 * @RequestParam("idDistrito") int idDistrito) {
		 */
		System.out.println("Opcion role: /" + role);
		System.out.println("idDistrito es: /" + idDistrito);
		LOGGER.debug("Registering user account with information: {} desde el Controller UsuarioController con LOGGER", accountDto);
		// Pendiente: Guardar el objeto noticia en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores desde el Controller UsuarioController");
			// return new ModelAndView("page-index-1");
			ModelAndView mav = new ModelAndView("/login/registration", "user", accountDto);
			String errMessage = messages.getMessage("message.regError", null, request.getLocale());
			LOGGER.warn("Unable to register user", errMessage);
			mav.addObject("message", errMessage);
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		int opcion = Integer.parseInt(role);

		LOGGER.debug("Registering user account with information: {}desde el Controller UsuarioController", accountDto);

		System.out.println("request.getLocal():desde el Controller UsuarioController" + request.getLocale());
		System.out.println("getAppUrl(request):desde el Controller UsuarioController" + getAppUrl(request));

		final Usuario registered = userService.registerNewUserAccount(accountDto, opcion, idDistrito, multiPart,
				request);
		eventPublisher
				.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));

		System.out.println("Recibiendo objeto Usuarios desde el Controller UsuarioController: " + registered);

		attributes.addFlashAttribute("mensaje",
				"El usuario fue registrado espera la autorizacion desde el Controller UsuarioController " + new GenericResponse("success"));

		System.out.println("Elementos en la lista despues de la insersion desde el Controller UsuarioController: " + userService.buscarTodas().size());
		System.out.println("La respuesta del generic response desde el Controller UsuarioController es: " + new GenericResponse("success"));

		// return new ModelAndView("redirect:/");
		new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request));
		System.out.println("creando mail desde Controller: "+	new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
		return new ModelAndView("/login/successRegister", "user", accountDto);
	}

	@PostMapping("/user/registration")
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid final UserDto userDto,
			final HttpServletRequest request, final Errors errors) {
		LOGGER.debug("Registering user account with information: {}", userDto);

		try {
			final Usuario registered = userService.registerNewUserAccount(userDto);

			final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
		} catch (final UserAlreadyExistException uaeEx) {
			ModelAndView mav = new ModelAndView("registration", "user", userDto);
			String errMessage = messages.getMessage("message.regError", null, request.getLocale());
			mav.addObject("message", errMessage);
			return mav;
		} catch (final RuntimeException ex) {
			LOGGER.warn("Unable to register user", ex);
			return new ModelAndView("emailError", "user", userDto);
		}
		return new ModelAndView("successRegister", "user", userDto);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmerEditor);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@PostMapping("/registration")
	@ResponseBody
	public GenericResponse registerUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {
		LOGGER.debug("Registering user account with information: {}", accountDto);

		final Usuario registered = userService.registerNewUserAccount(accountDto);
		eventPublisher
				.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
		return new GenericResponse("success");
	}

	@PostMapping("/successRegister")
	@ResponseBody
	public String MensajeMailConfirmacion(Model model, BindingResult bindingResult) {

		model.addAttribute("listapais", paisService.buscarTodas());

		if (bindingResult.hasErrors()) {
			return "/usuarios/successRegister";
		}
	
		return "/usuarios/successRegister";
	}

	/*
	 * private String getAppUrl(HttpServletRequest request) { return "http://" +
	 * request.getServerName() + ":" + request.getServerPort() +
	 * request.getContextPath(); }
	 */

	/*
	 * @GetMapping("/registrationConfirm") public String confirmRegistration(final
	 * HttpServletRequest request, final Model model,
	 * 
	 * @RequestParam("token") final String token) throws
	 * UnsupportedEncodingException { Locale locale = request.getLocale(); final
	 * String result = userService.validateVerificationToken(token); if
	 * (result.equals("valid")) { final Usuario user = userService.getUser(token);
	 * // if (user.isUsing2FA()) { // model.addAttribute("qr",
	 * userService.generateQRUrl(user)); // return "redirect:/qrcode.html?lang=" +
	 * locale.getLanguage(); // } authWithoutPassword(user);
	 * model.addAttribute("message", messages.getMessage("message.accountVerified",
	 * null, locale)); return "redirect:/login/console?lang=" +
	 * locale.getLanguage(); }
	 * 
	 * model.addAttribute("message", messages.getMessage("auth.message." + result,
	 * null, locale)); model.addAttribute("expired", "expired".equals(result));
	 * model.addAttribute("token", token); return "redirect:/login/badUser?lang=" +
	 * locale.getLanguage(); }
	 */

	@GetMapping("/registrationConfirm")
	public ModelAndView confirmRegistration(final HttpServletRequest request, final ModelMap model,
			@RequestParam("token") final String token) throws UnsupportedEncodingException {
		Locale locale = request.getLocale();
		model.addAttribute("lang", locale.getLanguage());
		final String result = userService.validateVerificationToken(token);
		if (result.equals("valid")) {
			final Usuario user = userService.getUser(token);
			// if (user.isUsing2FA()) {
			// model.addAttribute("qr", userService.generateQRUrl(user));
			// return "redirect:/qrcode.html?lang=" + locale.getLanguage();
			// }
			authWithoutPassword(user);
			model.addAttribute("messageKey", "message.accountVerified");
			return new ModelAndView("redirect:/console", model);
		}

		model.addAttribute("messageKey", "auth.message." + result);
		model.addAttribute("expired", "expired".equals(result));
		model.addAttribute("token", token);
		return new ModelAndView("redirect:/badUser", model);
	}

	// user activation - verification

	@GetMapping("/user/resendRegistrationToken")
	@ResponseBody
	public GenericResponse resendRegistrationToken(final HttpServletRequest request,
			@RequestParam("token") final String existingToken) {
		final VerificationToken newToken = userService.generateNewVerificationToken(existingToken);
		final Usuario user = userService.getUser(newToken.getToken());
		mailSender.send(constructResendVerificationTokenEmail(getAppUrl(request), request.getLocale(), newToken, user));
		return new GenericResponse(messages.getMessage("message.resendToken", null, request.getLocale()));
	}

	// Reset password
	@PostMapping("/user/resetPassword")
	@ResponseBody
	public GenericResponse resetPassword(final HttpServletRequest request,
			@RequestParam("email") final String userEmail) {
		final Usuario user = userService.findUserByEmail(userEmail);
		if (user != null) {
			final String token = UUID.randomUUID().toString();
			userService.createPasswordResetTokenForUser(user, token);
			mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user));
		}
		return new GenericResponse(messages.getMessage("message.resetPasswordEmail", null, request.getLocale()));
	}

	/*
	 * @GetMapping("/user/changePassword") public String
	 * showChangePasswordPage(final Locale locale, final Model
	 * model, @RequestParam("id") final long id,
	 * 
	 * @RequestParam("token") final String token) { final String result =
	 * securityUserService.validatePasswordResetToken(id, token); if (result !=
	 * null) { model.addAttribute("message", messages.getMessage("auth.message." +
	 * result, null, locale)); return "redirect:/loginForm?lang=" +
	 * locale.getLanguage(); } return "redirect:/login/updatePassword?lang=" +
	 * locale.getLanguage(); }
	 */

	@PostMapping("/user/savePassword")
	@ResponseBody
	public GenericResponse savePassword(final Locale locale, @Valid PasswordDto passwordDto) {
		final Usuario user = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userService.changeUserPassword(user, passwordDto.getNewPassword());
		return new GenericResponse(messages.getMessage("message.resetPasswordSuc", null, locale));
	}

	// change user password
	@PostMapping("/user/updatePassword")
	@ResponseBody
	public GenericResponse changeUserPassword(final Locale locale, @Valid PasswordDto passwordDto) {
		final Usuario user = userService.findUserByEmail(
				((Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getEmail());
		if (!userService.checkIfValidOldPassword(user, passwordDto.getOldPassword())) {
			throw new InvalidOldPasswordException();
		}
		userService.changeUserPassword(user, passwordDto.getNewPassword());
		return new GenericResponse(messages.getMessage("message.updatePasswordSuc", null, locale));
	}

	@PostMapping("/user/update/2fa")
	@ResponseBody
	public GenericResponse modifyUser2FA(@RequestParam("use2FA") final boolean use2FA)
			throws UnsupportedEncodingException {
		final Usuario user = userService.updateUser2FA(use2FA);
		if (use2FA) {
			return new GenericResponse(userService.generateQRUrl(user));
		}
		return null;
	}

	// ============== NON-API ============

	private SimpleMailMessage constructResendVerificationTokenEmail(final String contextPath, final Locale locale,
			final VerificationToken newToken, final Usuario user) {
		final String confirmationUrl = contextPath + "/login/registrationConfirm?token=" + newToken.getToken();
		final String message = messages.getMessage("message.resendToken", null, locale);
		return constructEmail("Resend Registration Token", message + " \r\n" + confirmationUrl, user);
	}

	private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale,
			final String token, final Usuario user) {
		final String url = contextPath + "/login/changePassword?id=" + user.getCodigo_usuario() + "&token=" + token;
		final String message = messages.getMessage("message.resetPassword", null, locale);
		return constructEmail("Reset Password", message + " \r\n" + url, user);
	}

	private SimpleMailMessage constructEmail(String subject, String body, Usuario user) {
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setSubject(subject);
		email.setText(body);
		email.setTo(user.getEmail());
		email.setFrom(env.getProperty("support.email"));
		return email;
	}

	public void authWithHttpServletRequest(HttpServletRequest request, String username, String password) {
		try {
			request.login(username, password);
		} catch (ServletException e) {
			LOGGER.error("Error while login ", e);
		}
	}

	public void authWithAuthManager(HttpServletRequest request, String username, String password) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
		authToken.setDetails(new WebAuthenticationDetails(request));
		Authentication authentication = authenticationManager.authenticate(authToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		// request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
		// SecurityContextHolder.getContext());
	}

	/*
	 * public void authWithoutPassword(Usuario user) { List<Privilege> privileges =
	 * user.getRoles().stream().map(role -> role.getPrivileges()) .flatMap(list ->
	 * list.stream()).distinct().collect(Collectors.toList());
	 * List<GrantedAuthority> authorities = privileges.stream().map(p -> new
	 * SimpleGrantedAuthority(p.getName())) .collect(Collectors.toList());
	 * 
	 * Authentication authentication = new UsernamePasswordAuthenticationToken(user,
	 * null, authorities);
	 * 
	 * SecurityContextHolder.getContext().setAuthentication(authentication); }
	 */

	// cREACION DEL TOKEN Y EL ENVIO DE MAIL PARA CONFIRMACIONservice

	//



	@GetMapping("/console")
	public ModelAndView console(final HttpServletRequest request, final ModelMap model,
			@RequestParam("messageKey") final Optional<String> messageKey) {

		Locale locale = request.getLocale();
		messageKey.ifPresent(key -> {
			String message = messages.getMessage(key, null, locale);
			model.addAttribute("message", message);
		});

		return new ModelAndView("console", model);
	}

	@GetMapping("/badUser")
	public ModelAndView badUser(final HttpServletRequest request, final ModelMap model,
			@RequestParam("messageKey") final Optional<String> messageKey,
			@RequestParam("expired") final Optional<String> expired,
			@RequestParam("token") final Optional<String> token) {

		Locale locale = request.getLocale();
		messageKey.ifPresent(key -> {
			String message = messages.getMessage(key, null, locale);
			model.addAttribute("message", message);
		});

		expired.ifPresent(e -> model.addAttribute("expired", e));
		token.ifPresent(t -> model.addAttribute("token", t));

		return new ModelAndView("badUser", model);
	}

	@GetMapping("/user/changePassword")
	public ModelAndView showChangePasswordPage(final ModelMap model, @RequestParam("token") final String token) {
		final String result = securityUserService.validatePasswordResetToken(token);

		if (result != null) {
			String messageKey = "auth.message." + result;
			model.addAttribute("messageKey", messageKey);
			return new ModelAndView("redirect:/login", model);
		} else {
			model.addAttribute("token", token);
			return new ModelAndView("redirect:/updatePassword");
		}
	}

	@GetMapping("/updatePassword")
	public ModelAndView updatePassword(final HttpServletRequest request, final ModelMap model,
			@RequestParam("messageKey") final Optional<String> messageKey) {
		Locale locale = request.getLocale();
		model.addAttribute("lang", locale.getLanguage());
		messageKey.ifPresent(key -> {
			String message = messages.getMessage(key, null, locale);
			model.addAttribute("message", message);
		});

		return new ModelAndView("updatePassword", model);
	}

	@GetMapping("/login")
	public ModelAndView login(final HttpServletRequest request, final ModelMap model,
			@RequestParam("messageKey") final Optional<String> messageKey,
			@RequestParam("error") final Optional<String> error) {
		Locale locale = request.getLocale();
		model.addAttribute("lang", locale.getLanguage());
		messageKey.ifPresent(key -> {
			String message = messages.getMessage(key, null, locale);
			model.addAttribute("message", message);
		});

		error.ifPresent(e -> model.addAttribute("error", e));

		return new ModelAndView("login", model);
	}

	@RequestMapping(value = "/user/enableNewLoc", method = RequestMethod.GET)
	public String enableNewLoc(Locale locale, Model model, @RequestParam("token") String token) {
		final String loc = userService.isValidNewLocationToken(token);
		if (loc != null) {
			model.addAttribute("message", messages.getMessage("message.newLoc.enabled", new Object[] { loc }, locale));
		} else {
			model.addAttribute("message", messages.getMessage("message.error", null, locale));
		}
		return "redirect:/login?lang=" + locale.getLanguage();
	}

	// ============== NON-API ============

	public void authWithoutPassword(Usuario user) {

		List<Privilege> privileges = user.getRoles().stream().map(Role::getPrivileges).flatMap(Collection::stream)
				.distinct().collect(Collectors.toList());

		List<GrantedAuthority> authorities = privileges.stream().map(p -> new SimpleGrantedAuthority(p.getName()))
				.collect(Collectors.toList());

		Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	private String getAppUrl(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}

	private final String getClientIP(HttpServletRequest request) {
		final String xfHeader = request.getHeader("X-Forwarded-For");
		if (xfHeader == null) {
			return request.getRemoteAddr();
		}
		return xfHeader.split(",")[0];
	}

}
