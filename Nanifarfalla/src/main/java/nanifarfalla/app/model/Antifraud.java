package nanifarfalla.app.model;

import java.util.Map;

public class Antifraud {
	private String clientIp;
	private Map<String, String> merchantDefineData;
	
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public Map<String, String> getMerchantDefineData() {
		return merchantDefineData;
	}
	public void setMerchantDefineData(Map<String, String> merchantDefineData) {
		this.merchantDefineData = merchantDefineData;
	}
	
	
}
