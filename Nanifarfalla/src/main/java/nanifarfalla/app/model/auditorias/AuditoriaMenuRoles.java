package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_menu_roles")
public class AuditoriaMenuRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_menu_roles;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_role_old;
	int fkid_old;
	Date version_old;
	String nombre_role_new;
	int fkcodigo_role_new;
	int fkid_new;
	Date version_new;

	public AuditoriaMenuRoles() {

	}

	public int getCodigo_audi_menu_roles() {
		return codigo_audi_menu_roles;
	}

	public void setCodigo_audi_menu_roles(int codigo_audi_menu_roles) {
		this.codigo_audi_menu_roles = codigo_audi_menu_roles;
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

	public int getFkid_old() {
		return fkid_old;
	}

	public void setFkid_old(int fkid_old) {
		this.fkid_old = fkid_old;
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

	public int getFkid_new() {
		return fkid_new;
	}

	public void setFkid_new(int fkid_new) {
		this.fkid_new = fkid_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
