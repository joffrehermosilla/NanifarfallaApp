package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_estadocliente")
public class AuditoriaEstadoCliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audiestadocliente;
	String usuario;
	Date fecha_cambio;
	String nombre_estadocliente_old;
	Date version_old;
	String nombre_estadocliente_new;
	Date version_new;

	public AuditoriaEstadoCliente() {

	}

	public int getCodigo_audiestadocliente() {
		return codigo_audiestadocliente;
	}

	public void setCodigo_audiestadocliente(int codigo_audiestadocliente) {
		this.codigo_audiestadocliente = codigo_audiestadocliente;
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

	public String getNombre_estadocliente_old() {
		return nombre_estadocliente_old;
	}

	public void setNombre_estadocliente_old(String nombre_estadocliente_old) {
		this.nombre_estadocliente_old = nombre_estadocliente_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getNombre_estadocliente_new() {
		return nombre_estadocliente_new;
	}

	public void setNombre_estadocliente_new(String nombre_estadocliente_new) {
		this.nombre_estadocliente_new = nombre_estadocliente_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
