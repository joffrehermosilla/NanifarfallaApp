package nanifarfalla.app.web.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import nanifarfalla.app.security.ISecurityUserService;
import nanifarfalla.app.model.Privilege;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.model.VerificationToken;
import nanifarfalla.app.registration.OnRegistrationCompleteEvent;
import nanifarfalla.app.service.IUserService;
import nanifarfalla.app.web.dto.PasswordDto;
import nanifarfalla.app.web.dto.UserDto;
import nanifarfalla.app.web.error.InvalidOldPasswordException;
import nanifarfalla.app.web.util.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUserService userService;

	@Autowired
	private ISecurityUserService securityUserService;

	@Autowired
	private MessageSource messages;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private Environment env;

	@Autowired
	private AuthenticationManager authenticationManager;

	public RegistrationController() {
		super();
	}

	// Registration

	@PostMapping("/user/registration")
	@ResponseBody
	public GenericResponse registerUserAccount(@Valid final UserDto accountDto, final HttpServletRequest request) {
		LOGGER.debug("Registering user account with information: {}", accountDto);

		final Usuario registered = userService.registerNewUserAccount(accountDto);
		eventPublisher
				.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
		return new GenericResponse("success");
	}

	@GetMapping("/registrationConfirm")
	public String confirmRegistration(final HttpServletRequest request, final Model model,
			@RequestParam("token") final String token) throws UnsupportedEncodingException {
		Locale locale = request.getLocale();
		final String result = userService.validateVerificationToken(token);
		if (result.equals("valid")) {
			final Usuario user = userService.getUser(token);
			// if (user.isUsing2FA()) {
			// model.addAttribute("qr", userService.generateQRUrl(user));
			// return "redirect:/qrcode.html?lang=" + locale.getLanguage();
			// }
			authWithoutPassword(user);
			model.addAttribute("message", messages.getMessage("message.accountVerified", null, locale));
			return "redirect:/console.html?lang=" + locale.getLanguage();
		}

		model.addAttribute("message", messages.getMessage("auth.message." + result, null, locale));
		model.addAttribute("expired", "expired".equals(result));
		model.addAttribute("token", token);
		return "redirect:/badUser.html?lang=" + locale.getLanguage();
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

	@GetMapping("/user/changePassword")
	public String showChangePasswordPage(final Locale locale, final Model model, @RequestParam("id") final long id,
			@RequestParam("token") final String token) {
		final String result = securityUserService.validatePasswordResetToken(id, token);
		if (result != null) {
			model.addAttribute("message", messages.getMessage("auth.message." + result, null, locale));
			return "redirect:/login?lang=" + locale.getLanguage();
		}
		return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
	}

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
		final String confirmationUrl = contextPath + "/registrationConfirm.html?token=" + newToken.getToken();
		final String message = messages.getMessage("message.resendToken", null, locale);
		return constructEmail("Resend Registration Token", message + " \r\n" + confirmationUrl, user);
	}

	private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale,
			final String token, final Usuario user) {
		final String url = contextPath + "/user/changePassword?id=" + user.getCodigo_usuario() + "&token=" + token;
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

	private String getAppUrl(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
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

	public void authWithoutPassword(Usuario user) {
		List<Privilege> privileges = user.getRoles().stream().map(role -> role.getPrivileges())
				.flatMap(list -> list.stream()).distinct().collect(Collectors.toList());
		List<GrantedAuthority> authorities = privileges.stream()
				.map(p -> new SimpleGrantedAuthority(p.getName())).collect(Collectors.toList());

		Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);

		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
