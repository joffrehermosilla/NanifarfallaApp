package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_zona")
public class AuditoriaZona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audizona;
	String usuario;
	Date fecha_cambio;
	String nombre_zona_old;
	String claveApi_old;
	Date version_old;
	String nombre_zona_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaZona() {

	}

	public int getCodigo_audizona() {
		return codigo_audizona;
	}

	public void setCodigo_audizona(int codigo_audizona) {
		this.codigo_audizona = codigo_audizona;
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

	public String getNombre_zona_old() {
		return nombre_zona_old;
	}

	public void setNombre_zona_old(String nombre_zona_old) {
		this.nombre_zona_old = nombre_zona_old;
	}

	public String getClaveApi_old() {
		return claveApi_old;
	}

	public void setClaveApi_old(String claveApi_old) {
		this.claveApi_old = claveApi_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getNombre_zona_new() {
		return nombre_zona_new;
	}

	public void setNombre_zona_new(String nombre_zona_new) {
		this.nombre_zona_new = nombre_zona_new;
	}

	public String getClaveApi_new() {
		return claveApi_new;
	}

	public void setClaveApi_new(String claveApi_new) {
		this.claveApi_new = claveApi_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
