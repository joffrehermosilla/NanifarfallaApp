package nanifarfalla.app.model;

public class SeguridadResponse extends BodyResponse{
//	private String tokenSeguridad;
	private String accessToken;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

//	public String getTokenSeguridad() {
//		return tokenSeguridad;
//	}
//
//	public void setTokenSeguridad(String tokenSeguridad) {
//		this.tokenSeguridad = tokenSeguridad;
//	}
	
	
}
