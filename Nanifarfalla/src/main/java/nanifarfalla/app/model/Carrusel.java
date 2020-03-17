package nanifarfalla.app.model;

import java.util.Date;

public class Carrusel {
	private int codigo_carrusel;
	private String mensaje_carrusel1;
	private String mensaje_carrusel2;
	private String mensaje_carrusel3;
	private String categoria_carrusel;
	private Date fechacreacion;
	private String foto_carrusel1 = "nanifarfalla.jpg";
	private String foto_carrusel2 = "nanifarfalla.jpg";

	@Override
	public String toString() {
		return "Carrusel [codigo_carrusel=" + codigo_carrusel + ", mensaje_carrusel1=" + mensaje_carrusel1
				+ ", mensaje_carrusel2=" + mensaje_carrusel2 + ", mensaje_carrusel3=" + mensaje_carrusel3
				+ ", categoria_carrusel=" + categoria_carrusel + ", fechacreacion=" + fechacreacion
				+ ", foto_carrusel1=" + foto_carrusel1 + ", foto_carrusel2=" + foto_carrusel2 + "]";
	}

	public int getCodigo_carrusel() {
		return codigo_carrusel;
	}

	public void setCodigo_carrusel(int codigo_carrusel) {
		this.codigo_carrusel = codigo_carrusel;
	}

	public String getMensaje_carrusel1() {
		return mensaje_carrusel1;
	}

	public void setMensaje_carrusel1(String mensaje_carrusel1) {
		this.mensaje_carrusel1 = mensaje_carrusel1;
	}

	public String getMensaje_carrusel2() {
		return mensaje_carrusel2;
	}

	public void setMensaje_carrusel2(String mensaje_carrusel2) {
		this.mensaje_carrusel2 = mensaje_carrusel2;
	}

	public String getMensaje_carrusel3() {
		return mensaje_carrusel3;
	}

	public void setMensaje_carrusel3(String mensaje_carrusel3) {
		this.mensaje_carrusel3 = mensaje_carrusel3;
	}

	public String getCategoria_carrusel() {
		return categoria_carrusel;
	}

	public void setCategoria_carrusel(String categoria_carrusel) {
		this.categoria_carrusel = categoria_carrusel;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getFoto_carrusel1() {
		return foto_carrusel1;
	}

	public void setFoto_carrusel1(String foto_carrusel1) {
		this.foto_carrusel1 = foto_carrusel1;
	}

	public String getFoto_carrusel2() {
		return foto_carrusel2;
	}

	public void setFoto_carrusel2(String foto_carrusel2) {
		this.foto_carrusel2 = foto_carrusel2;
	}

}
