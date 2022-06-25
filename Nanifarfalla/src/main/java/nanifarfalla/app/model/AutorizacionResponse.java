package nanifarfalla.app.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AutorizacionResponse extends BodyResponse{
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Integer errorCode;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String errorMessage;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> dataMap;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String, String> data;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	public Map<String, String> getData() {
		return data;
	}

	public void setData(Map<String, String> data) {
		this.data = data;
	}
	
	
}
