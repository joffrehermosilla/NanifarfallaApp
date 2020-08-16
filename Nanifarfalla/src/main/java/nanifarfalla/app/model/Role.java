package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_role;
	String nombre_role;
	Date version;
	@OneToMany(mappedBy = "mRole")
	private Collection<UserRoles> userRoles = new ArrayList<>();

	@OneToMany(mappedBy = "mRole")
	private Collection<RoleHasPrivileges> roleHasPrivileges = new ArrayList<>();

	
	
	public Collection<RoleHasPrivileges> getRoleHasPrivileges() {
		return roleHasPrivileges;
	}

	public void setRoleHasPrivileges(Collection<RoleHasPrivileges> roleHasPrivileges) {
		this.roleHasPrivileges = roleHasPrivileges;
	}

	public Role() {

	}

	public Collection<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Collection<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public int getCodigo_role() {
		return codigo_role;
	}

	public void setCodigo_role(int codigo_role) {
		this.codigo_role = codigo_role;
	}

	public String getNombre_role() {
		return nombre_role;
	}

	public void setNombre_role(String nombre_role) {
		this.nombre_role = nombre_role;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
