package nanifarfalla.app.model;

import java.util.Date;

public class Alerta {
	public Alerta() {

	}

	@Override
	public String toString() {
		return "Alerta [codigo_alerta=" + codigo_alerta + ", mensaje_alerta=" + mensaje_alerta + ", categoria="
				+ categoria + ", precio=" + precio + ", version=" + version + "]";
	}

	private int codigo_alerta;
	private String mensaje_alerta;
	private String categoria;
	private Double precio;
	private Date version;

	
	
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCodigo_alerta() {
		return codigo_alerta;
	}

	public void setCodigo_alerta(int codigo_alerta) {
		this.codigo_alerta = codigo_alerta;
	}

	public String getMensaje_alerta() {
		return mensaje_alerta;
	}

	public void setMensaje_alerta(String mensaje_alerta) {
		this.mensaje_alerta = mensaje_alerta;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
