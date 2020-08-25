package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "privilege")
public class Privilege {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_privilege;
	String name
	;
	Date version;

	// private Long id;

	// private String name;

	@ManyToMany(mappedBy = "privileges")
	private Collection<Role> roles;

	public Privilege(final String name) {
		super();
		this.name = name;
	}

	@OneToMany(mappedBy = "mPrivilege")
	private Collection<RoleHasPrivileges> roleHasPrivileges = new ArrayList<>();

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public Collection<RoleHasPrivileges> getRoleHasPrivileges() {
		return roleHasPrivileges;
	}

	public void setRoleHasPrivileges(Collection<RoleHasPrivileges> roleHasPrivileges) {
		this.roleHasPrivileges = roleHasPrivileges;
	}

	public int getCodigo_privilege() {
		return codigo_privilege;
	}

	public void setCodigo_privilege(int codigo_privilege) {
		this.codigo_privilege = codigo_privilege;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public Privilege() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Privilege other = (Privilege) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Privilege [nombre_privilege=").append(name).append("]").append("[codigo_privilege=")
				.append(codigo_privilege).append("]");
		return builder.toString();
	}

}
