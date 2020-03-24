package nanifarfalla.app.model;

import java.util.Date;

public class Linea {
	private int codigo_linea;
	private String nombre_linea="nombre de linea";
	private String foto_linea = "nanifarfalla.jpeg";
	private String claveApi="clave api";
	private Date fechacreacion;

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	@Override
	public String toString() {
		return "Linea [codigo_linea=" + codigo_linea + ", nombre_linea=" + nombre_linea + ", foto_linea=" + foto_linea
				+ ", fechacreacion=" + fechacreacion + "]";
	}

	public int getCodigo_linea() {
		return codigo_linea;
	}

	public void setCodigo_linea(int codigo_linea) {
		this.codigo_linea = codigo_linea;
	}

	public String getNombre_linea() {
		return nombre_linea;
	}

	public void setNombre_linea(String nombre_linea) {
		this.nombre_linea = nombre_linea;
	}

	public String getFoto_linea() {
		return foto_linea;
	}

	public void setFoto_linea(String foto_linea) {
		this.foto_linea = foto_linea;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

}
