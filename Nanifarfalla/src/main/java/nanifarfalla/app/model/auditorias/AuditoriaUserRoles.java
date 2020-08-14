package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_users_roles")
public class AuditoriaUserRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_users_roles;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_role_old;
	int fkcodigo_usuario_old;
	Date version_old;
	String nombre_role_new;
	int fkcodigo_role_new;
	int fkcodigo_usuario_new;
	Date version_new;

	public AuditoriaUserRoles() {

	}

	public int getCodigo_audi_users_roles() {
		return codigo_audi_users_roles;
	}

	public void setCodigo_audi_users_roles(int codigo_audi_users_roles) {
		this.codigo_audi_users_roles = codigo_audi_users_roles;
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

	public int getFkcodigo_role_old() {
		return fkcodigo_role_old;
	}

	public void setFkcodigo_role_old(int fkcodigo_role_old) {
		this.fkcodigo_role_old = fkcodigo_role_old;
	}

	public int getFkcodigo_usuario_old() {
		return fkcodigo_usuario_old;
	}

	public void setFkcodigo_usuario_old(int fkcodigo_usuario_old) {
		this.fkcodigo_usuario_old = fkcodigo_usuario_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getNombre_role_new() {
		return nombre_role_new;
	}

	public void setNombre_role_new(String nombre_role_new) {
		this.nombre_role_new = nombre_role_new;
	}

	public int getFkcodigo_role_new() {
		return fkcodigo_role_new;
	}

	public void setFkcodigo_role_new(int fkcodigo_role_new) {
		this.fkcodigo_role_new = fkcodigo_role_new;
	}

	public int getFkcodigo_usuario_new() {
		return fkcodigo_usuario_new;
	}

	public void setFkcodigo_usuario_new(int fkcodigo_usuario_new) {
		this.fkcodigo_usuario_new = fkcodigo_usuario_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
