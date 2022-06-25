package nanifarfalla.app.model;

public class SesionRequest {
	private String channel;
	private String amount;
	private Antifraud antifraud;
	private String accessToken;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Antifraud getAntifraud() {
		return antifraud;
	}
	public void setAntifraud(Antifraud antifraud) {
		this.antifraud = antifraud;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
