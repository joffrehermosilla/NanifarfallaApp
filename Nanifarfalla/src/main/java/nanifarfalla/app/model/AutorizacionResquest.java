package nanifarfalla.app.model;

public class AutorizacionResquest {
	private String accessToken;
	private String channel;
	private String captureType;
	private boolean countable;
	private Order order;
	private Card card;
	private CardHolder cardHolder;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getCaptureType() {
		return captureType;
	}
	public void setCaptureType(String captureType) {
		this.captureType = captureType;
	}
	public boolean isCountable() {
		return countable;
	}
	public void setCountable(boolean countable) {
		this.countable = countable;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public CardHolder getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(CardHolder cardHolder) {
		this.cardHolder = cardHolder;
	}
	
	
}
