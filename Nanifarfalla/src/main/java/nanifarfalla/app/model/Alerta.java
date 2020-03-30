package nanifarfalla.app.model;

import java.util.Date;

public class Alerta {
	public Alerta() {

	}



	private int codigo_alerta;
	private String mensaje_alerta;
	private String categoria;
	private Double precio;
	private Date version;
	private int fkcodigo_tipoalerta;
	
	
	
	public int getFkcodigo_tipoalerta() {
		return fkcodigo_tipoalerta;
	}

	public void setFkcodigo_tipoalerta(int fkcodigo_tipoalerta) {
		this.fkcodigo_tipoalerta = fkcodigo_tipoalerta;
	}

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
