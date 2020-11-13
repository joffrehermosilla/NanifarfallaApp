package nanifarfalla.app.web.controller;

import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import nanifarfalla.app.model.PasswordRessetToken;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.model.VerificationToken;
import nanifarfalla.app.registration.OnRegistrationCompleteEvent;
import nanifarfalla.app.service.IUserService;
import nanifarfalla.app.web.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/old")
public class OldRegistrationController {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUserService userService;

	@Autowired
	private MessageSource messages;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private Environment env;

	public OldRegistrationController() {
		super();
	}

	// API

	@GetMapping("/user/registration")
	public String showRegistrationForm(final HttpServletRequest request, final Model model) {
		LOGGER.debug("Rendering registration page.");
		final UserDto accountDto = new UserDto();
		model.addAttribute("user", accountDto);
		return "registration";
	}

	@GetMapping("/registrationConfirm")
	public String confirmRegistration(final HttpServletRequest request, final Model model,
			@RequestParam("token") final String token) {
		final Locale locale = request.getLocale();

		final VerificationToken verificationToken = userService.getVerificationToken(token);
		if (verificationToken == null) {
			final String message = messages.getMessage("auth.message.invalidToken", null, locale);
			model.addAttribute("message", message);
			return "redirect:/badUser.html?lang=" + locale.getLanguage();
		}

		final Usuario user = verificationToken.getUser();
		final Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
			model.addAttribute("expired", true);
			model.addAttribute("token", token);
			return "redirect:/badUser.html?lang=" + locale.getLanguage();
		}

		user.setEnabled(true);
		userService.saveRegisteredUser(user);
		model.addAttribute("message", messages.getMessage("message.accountVerified", null, locale));
		return "redirect:/login.html?lang=" + locale.getLanguage();
	}

	@PostMapping("/user/registration")
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid final UserDto userDto,
			final HttpServletRequest request, final Errors errors) {
		LOGGER.debug("Registering user account with information: {}", userDto);

		final Usuario registered = userService.registerNewUserAccount(userDto);
		if (registered == null) {
			// result.rejectValue("email", "message.regError");
			return new ModelAndView("registration", "user", userDto);
		}
		try {
			final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), appUrl));
		} catch (final Exception ex) {
			LOGGER.warn("Unable to register user", ex);
			return new ModelAndView("emailError", "user", userDto);
		}
		return new ModelAndView("successRegister", "user", userDto);
	}

	@GetMapping("/user/resendRegistrationToken")
	public String resendRegistrationToken(final HttpServletRequest request, final Model model,
			@RequestParam("token") final String existingToken) {
		final Locale locale = request.getLocale();
		final VerificationToken newToken = userService.generateNewVerificationToken(existingToken);
		final Usuario user = userService.getUser(newToken.getToken());
		try {
			final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			final SimpleMailMessage email = constructResetVerificationTokenEmail(appUrl, request.getLocale(), newToken,
					user);
			mailSender.send(email);
		} catch (final MailAuthenticationException e) {
			LOGGER.debug("MailAuthenticationException", e);
			return "redirect:/emailError.html?lang=" + locale.getLanguage();
		} catch (final Exception e) {
			LOGGER.debug(e.getLocalizedMessage(), e);
			model.addAttribute("message", e.getLocalizedMessage());
			return "redirect:/login.html?lang=" + locale.getLanguage();
		}
		model.addAttribute("message", messages.getMessage("message.resendToken", null, locale));
		return "redirect:/login.html?lang=" + locale.getLanguage();
	}

	@PostMapping("/user/resetPassword")
	public String resetPassword(final HttpServletRequest request, final Model model,
			@RequestParam("email") final String userEmail) {
		final Usuario user = userService.findUserByEmail(userEmail);
		if (user == null) {
			model.addAttribute("message", messages.getMessage("message.userNotFound", null, request.getLocale()));
			return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
		}

		final String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user, token);
		try {
			final String appUrl = "http://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath();
			final SimpleMailMessage email = constructResetTokenEmail(appUrl, request.getLocale(), token, user);
			mailSender.send(email);
		} catch (final MailAuthenticationException e) {
			LOGGER.debug("MailAuthenticationException", e);
			return "redirect:/emailError.html?lang=" + request.getLocale().getLanguage();
		} catch (final Exception e) {
			LOGGER.debug(e.getLocalizedMessage(), e);
			model.addAttribute("message", e.getLocalizedMessage());
			return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
		}
		model.addAttribute("message", messages.getMessage("message.resetPasswordEmail", null, request.getLocale()));
		return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
	}

	@GetMapping("/user/changePassword")
	public String changePassword(final HttpServletRequest request, final Model model, @RequestParam("id") final long id,
			@RequestParam("token") final String token) {
		final Locale locale = request.getLocale();

		final PasswordRessetToken passToken = userService.getPasswordResetToken(token);
		final Usuario user = passToken.getUser();
		if ((passToken == null) || (user.getCodigo_usuario() != id)) {
			final String message = messages.getMessage("auth.message.invalidToken", null, locale);
			model.addAttribute("message", message);
			return "redirect:/login.html?lang=" + locale.getLanguage();
		}

		final Calendar cal = Calendar.getInstance();
		if ((passToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			model.addAttribute("message", messages.getMessage("auth.message.expired", null, locale));
			return "redirect:/login.html?lang=" + locale.getLanguage();
		}

		final Authentication auth = new UsernamePasswordAuthenticationToken(user, null,
				userDetailsService.loadUserByUsername(user.getEmail()).getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);

		return "redirect:/updatePassword.html?lang=" + locale.getLanguage();
	}

	@PostMapping("/user/savePassword")
	@PreAuthorize("hasRole('READ_PRIVILEGE')")
	public String savePassword(final HttpServletRequest request, final Model model,
			@RequestParam("password") final String password) {
		final Locale locale = request.getLocale();

		final Usuario user = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		userService.changeUserPassword(user, password);
		model.addAttribute("message", messages.getMessage("message.resetPasswordSuc", null, locale));
		return "redirect:/login?lang=" + locale;
	}

	// NON-API

	private final SimpleMailMessage constructResetVerificationTokenEmail(final String contextPath, final Locale locale,
			final VerificationToken newToken, final Usuario user) {
		final String confirmationUrl = contextPath + "/old/registrationConfirm.html?token=" + newToken.getToken();
		final String message = messages.getMessage("message.resendToken", null, locale);
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setSubject("Resend Registration Token");
		email.setText(message + " \r\n" + confirmationUrl);
		email.setTo(user.getEmail());
		email.setFrom(env.getProperty("support.email"));
		return email;
	}

	private final SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale,
			final String token, final Usuario user) {
		final String url = contextPath + "/old/user/changePassword?id=" + user.getCodigo_usuario() + "&token=" + token;
		final String message = messages.getMessage("message.resetPassword", null, locale);
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Reset Password");
		email.setText(message + " \r\n" + url);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}
}
