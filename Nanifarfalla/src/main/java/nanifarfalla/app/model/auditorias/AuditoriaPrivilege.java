package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_privilege")
public class AuditoriaPrivilege {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_privilege;
	String usuario;
	Date fecha_cambio;
	String nombre_privilege_old;
	Date version_old;
	String nombre_privilege_new;
	Date version_new;

	public int getCodigo_audi_privilege() {
		return codigo_audi_privilege;
	}

	public void setCodigo_audi_privilege(int codigo_audi_privilege) {
		this.codigo_audi_privilege = codigo_audi_privilege;
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

	public String getNombre_privilege_old() {
		return nombre_privilege_old;
	}

	public void setNombre_privilege_old(String nombre_privilege_old) {
		this.nombre_privilege_old = nombre_privilege_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getNombre_privilege_new() {
		return nombre_privilege_new;
	}

	public void setNombre_privilege_new(String nombre_privilege_new) {
		this.nombre_privilege_new = nombre_privilege_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
