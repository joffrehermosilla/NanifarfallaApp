package nanifarfalla.app.web.controller;

import nanifarfalla.app.captcha.ICaptchaService;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.registration.OnRegistrationCompleteEvent;
import nanifarfalla.app.service.IUserService;
import nanifarfalla.app.web.dto.UserDto;
import nanifarfalla.app.web.util.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationCaptchaController {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private IUserService userService;

	@Autowired
	private ICaptchaService captchaService;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	public RegistrationCaptchaController() {
		super();
	}

	// Registration

	@PostMapping("/user/registrationCaptcha")
	@ResponseBody
	public GenericResponse captchaRegisterUserAccount(@Valid final UserDto accountDto,
			final HttpServletRequest request) {

		final String response = request.getParameter("g-recaptcha-response");
		captchaService.processResponse(response);

		LOGGER.debug("Registering user account with information: {}", accountDto);

		final Usuario registered = userService.registerNewUserAccount(accountDto);
		eventPublisher
				.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
		return new GenericResponse("success");
	}

	private String getAppUrl(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}

}
