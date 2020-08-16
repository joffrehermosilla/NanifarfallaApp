package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_rolehasprivilege")
public class AuditoriaRoleHasPrivileges {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_rolehasprivilege;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_role_old;
	int fkcodigo_privilege_old;
	Date version_old;
	int fkcodigo_role_new;
	int fkcodigo_privilege_new;
	Date version_new;

	public AuditoriaRoleHasPrivileges() {

	}

	public int getCodigo_audi_rolehasprivilege() {
		return codigo_audi_rolehasprivilege;
	}

	public void setCodigo_audi_rolehasprivilege(int codigo_audi_rolehasprivilege) {
		this.codigo_audi_rolehasprivilege = codigo_audi_rolehasprivilege;
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

	public int getFkcodigo_privilege_old() {
		return fkcodigo_privilege_old;
	}

	public void setFkcodigo_privilege_old(int fkcodigo_privilege_old) {
		this.fkcodigo_privilege_old = fkcodigo_privilege_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public int getFkcodigo_role_new() {
		return fkcodigo_role_new;
	}

	public void setFkcodigo_role_new(int fkcodigo_role_new) {
		this.fkcodigo_role_new = fkcodigo_role_new;
	}

	public int getFkcodigo_privilege_new() {
		return fkcodigo_privilege_new;
	}

	public void setFkcodigo_privilege_new(int fkcodigo_privilege_new) {
		this.fkcodigo_privilege_new = fkcodigo_privilege_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
