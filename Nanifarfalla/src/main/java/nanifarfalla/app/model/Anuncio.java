package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Anuncio {

	public Anuncio() {
		System.out.println("Constructor Anuncio desde el model");
		this.version = new Date();

	}

	private int codigo_anuncio;
	private String mensaje_anuncio;
	private String anuncio_principal;
	private String pie_mensaje;
	private String link_mensaje = "";
	private String ruta_imagen = "";
	private Double precio = 0.0;
	private int fkcodigo_tipoalerta;
	private Date version;

	@OneToMany(mappedBy = "mAnuncio", fetch = FetchType.EAGER)
	private Collection<UserAnuncios> useranuncios = new ArrayList<>();

	@Override
	public String toString() {
		return "Anuncios [codigo_anuncio=" + codigo_anuncio + ", mensaje_anuncio=" + mensaje_anuncio
				+ ", anuncio_principal=" + anuncio_principal + ", pie_mensaje=" + pie_mensaje + ", link_mensaje="
				+ link_mensaje + ", ruta_imagen=" + ruta_imagen + ", precio=" + precio + ", fkcodigo_tipoalerta="
				+ fkcodigo_tipoalerta + ", version=" + version + "]";
	}

	public Collection<UserAnuncios> getUseranuncios() {
		return useranuncios;
	}

	public void setUseranuncios(Collection<UserAnuncios> useranuncios) {
		this.useranuncios = useranuncios;
	}

	public int getCodigo_anuncio() {
		return codigo_anuncio;
	}

	public void setCodigo_anuncio(int codigo_anuncio) {
		this.codigo_anuncio = codigo_anuncio;
	}

	public String getMensaje_anuncio() {
		return mensaje_anuncio;
	}

	public void setMensaje_anuncio(String mensaje_anuncio) {
		System.out.println("Set Mensaje Anuncio");

		this.mensaje_anuncio = mensaje_anuncio;
	}

	public String getAnuncio_principal() {
		return anuncio_principal;
	}

	public void setAnuncio_principal(String anuncio_principal) {
		this.anuncio_principal = anuncio_principal;
	}

	public String getPie_mensaje() {
		return pie_mensaje;
	}

	public void setPie_mensaje(String pie_mensaje) {
		this.pie_mensaje = pie_mensaje;
	}

	public String getLink_mensaje() {
		return link_mensaje;
	}

	public void setLink_mensaje(String link_mensaje) {
		this.link_mensaje = link_mensaje;
	}

	public String getRuta_imagen() {
		return ruta_imagen;
	}

	public void setRuta_imagen(String ruta_imagen) {
		this.ruta_imagen = ruta_imagen;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getFkcodigo_tipoalerta() {
		return fkcodigo_tipoalerta;
	}

	public void setFkcodigo_tipoalerta(int fkcodigo_tipoalerta) {
		this.fkcodigo_tipoalerta = fkcodigo_tipoalerta;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		System.out.println("Set Version");
		this.version = version;
	}

}
