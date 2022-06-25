package nanifarfalla.app.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BodyResponse {
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String idTransaccion;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String codigoRespuesta;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String mensajeRespuesta;
	
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String mensajeError;
	
	public BodyResponse() {
		super();
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getCodigoRespuesta() {
		return codigoRespuesta;
	}

	public void setCodigoRespuesta(String codigoRespuesta) {
		this.codigoRespuesta = codigoRespuesta;
	}

	public String getMensajeRespuesta() {
		return mensajeRespuesta;
	}

	public void setMensajeRespuesta(String mensajeRespuesta) {
		this.mensajeRespuesta = mensajeRespuesta;
	}

	public String getMensajeError() {
		return mensajeError;
	}

	public void setMensajeError(String mensajeError) {
		this.mensajeError = mensajeError;
	}
	
	
}
