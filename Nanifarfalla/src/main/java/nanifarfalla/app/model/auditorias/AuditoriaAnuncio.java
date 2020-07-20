package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_anuncios")
public class AuditoriaAnuncio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_anuncios;
	String usuario;
	Date fecha_cambio;
	String mensaje_anuncio_old;
	String anuncio_principal_old;
	String pie_mensaje_old;
	String link_mensaje_old;
	String ruta_imagen_old;
	Double precio_old;
	int fkcodigo_tipoalerta_old;
	Date version_old;
	String mensaje_anuncio_new;
	String anuncio_principal_new;
	String pie_mensaje_new;
	String link_mensaje_new;
	String ruta_imagen_new;
	Double precio_new;
	int fkcodigo_tipoalerta_new;
	Date version_new;

	public AuditoriaAnuncio() {

	}

	public int getCodigo_audi_anuncios() {
		return codigo_audi_anuncios;
	}

	public void setCodigo_audi_anuncios(int codigo_audi_anuncios) {
		this.codigo_audi_anuncios = codigo_audi_anuncios;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_cambio() {
		return fecha_cambio;
	}

	public void setFecha_cambio(Date fecha_cambio) {
		this.fecha_cambio = fecha_cambio;
	}

	public String getMensaje_anuncio_old() {
		return mensaje_anuncio_old;
	}

	public void setMensaje_anuncio_old(String mensaje_anuncio_old) {
		this.mensaje_anuncio_old = mensaje_anuncio_old;
	}

	public String getAnuncio_principal_old() {
		return anuncio_principal_old;
	}

	public void setAnuncio_principal_old(String anuncio_principal_old) {
		this.anuncio_principal_old = anuncio_principal_old;
	}

	public String getPie_mensaje_old() {
		return pie_mensaje_old;
	}

	public void setPie_mensaje_old(String pie_mensaje_old) {
		this.pie_mensaje_old = pie_mensaje_old;
	}

	public String getLink_mensaje_old() {
		return link_mensaje_old;
	}

	public void setLink_mensaje_old(String link_mensaje_old) {
		this.link_mensaje_old = link_mensaje_old;
	}

	public String getRuta_imagen_old() {
		return ruta_imagen_old;
	}

	public void setRuta_imagen_old(String ruta_imagen_old) {
		this.ruta_imagen_old = ruta_imagen_old;
	}

	public Double getPrecio_old() {
		return precio_old;
	}

	public void setPrecio_old(Double precio_old) {
		this.precio_old = precio_old;
	}

	public int getFkcodigo_tipoalerta_old() {
		return fkcodigo_tipoalerta_old;
	}

	public void setFkcodigo_tipoalerta_old(int fkcodigo_tipoalerta_old) {
		this.fkcodigo_tipoalerta_old = fkcodigo_tipoalerta_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getMensaje_anuncio_new() {
		return mensaje_anuncio_new;
	}

	public void setMensaje_anuncio_new(String mensaje_anuncio_new) {
		this.mensaje_anuncio_new = mensaje_anuncio_new;
	}

	public String getAnuncio_principal_new() {
		return anuncio_principal_new;
	}

	public void setAnuncio_principal_new(String anuncio_principal_new) {
		this.anuncio_principal_new = anuncio_principal_new;
	}

	public String getPie_mensaje_new() {
		return pie_mensaje_new;
	}

	public void setPie_mensaje_new(String pie_mensaje_new) {
		this.pie_mensaje_new = pie_mensaje_new;
	}

	public String getLink_mensaje_new() {
		return link_mensaje_new;
	}

	public void setLink_mensaje_new(String link_mensaje_new) {
		this.link_mensaje_new = link_mensaje_new;
	}

	public String getRuta_imagen_new() {
		return ruta_imagen_new;
	}

	public void setRuta_imagen_new(String ruta_imagen_new) {
		this.ruta_imagen_new = ruta_imagen_new;
	}

	public Double getPrecio_new() {
		return precio_new;
	}

	public void setPrecio_new(Double precio_new) {
		this.precio_new = precio_new;
	}

	public int getFkcodigo_tipoalerta_new() {
		return fkcodigo_tipoalerta_new;
	}

	public void setFkcodigo_tipoalerta_new(int fkcodigo_tipoalerta_new) {
		this.fkcodigo_tipoalerta_new = fkcodigo_tipoalerta_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
