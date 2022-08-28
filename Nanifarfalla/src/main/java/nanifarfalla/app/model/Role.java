package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_role;
	String name;
	Long id;
	Date version;
	@OneToMany(mappedBy = "mRole")
	private Collection<UserRoles> userRoles = new ArrayList<>();

	@OneToMany(mappedBy = "mRole")
	private Collection<RoleHasPrivileges> roleHasPrivileges = new ArrayList<>();

	@ManyToMany(mappedBy = "roles")
	private Collection<Usuario> users;

	// private Long id;

	@ManyToMany
	@JoinTable(name = "rolehasprivilege", joinColumns = @JoinColumn(name = "fkcodigo_role", referencedColumnName = "codigo_role"), inverseJoinColumns = @JoinColumn(name = "fkcodigo_privilege", referencedColumnName = "codigo_privilege"))
	private Collection<Privilege> privileges;

	// private String name;

	@OneToMany(mappedBy = "mRole")
		private Collection<MenuRoles> menuRoles = new ArrayList<>();
	
	
	public Collection<MenuRoles> getMenuRoles() {
		return menuRoles;
	}

	public void setMenuRoles(Collection<MenuRoles> menuRoles) {
		this.menuRoles = menuRoles;
	}

	public Collection<RoleHasPrivileges> getRoleHasPrivileges() {
		return roleHasPrivileges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Usuario> getUsers() {
		return users;
	}

	public void setUsers(Collection<Usuario> users) {
		this.users = users;
	}

	public Collection<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(Collection<Privilege> privileges) {
		this.privileges = privileges;
	}

	public void setRoleHasPrivileges(Collection<RoleHasPrivileges> roleHasPrivileges) {
		this.roleHasPrivileges = roleHasPrivileges;
	}

	public Role() {
		super();
	}

	public Role(final String name) {
		super();
		this.name = name;
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



	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Role role = (Role) obj;
		if (!getName().equals(role.getName())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Role [nombre_role=").append(name).append("]").append("[codigo_role=").append(codigo_role)
				.append("]");
		return builder.toString();
	}

}
