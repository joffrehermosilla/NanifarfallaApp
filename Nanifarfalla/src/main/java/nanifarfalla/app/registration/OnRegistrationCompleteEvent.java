package nanifarfalla.app.registration;

import java.util.Locale;

import nanifarfalla.app.model.Usuario;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class OnRegistrationCompleteEvent extends ApplicationEvent {

	private final String appUrl;
	private final Locale locale;
	private final Usuario user;

	public OnRegistrationCompleteEvent(final Usuario user, final Locale locale, final String appUrl) {
		super(user);
		this.user = user;
		this.locale = locale;
		this.appUrl = appUrl;
	}

	//

	public String getAppUrl() {
		return appUrl;
	}

	public Locale getLocale() {
		return locale;
	}

	public Usuario getUser() {
		return user;
	}

}
