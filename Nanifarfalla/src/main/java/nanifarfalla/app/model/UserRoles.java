	package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_roles")
public class UserRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_usersroles;
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;
	// int fkcodigo_usuario;

	//int user_id = 0;
	@JoinColumn(name = "fkcodigo_role", referencedColumnName = "codigo_role")
	@ManyToOne
	Role mRole;
	// int fkcodigo_role;
	Date version;
	String claveApi;

	public UserRoles() {

	}

	public int getCodigo_usersroles() {
		return codigo_usersroles;
	}

	public void setCodigo_usersroles(int codigo_usersroles) {
		this.codigo_usersroles = codigo_usersroles;
	}

	public Usuario getmUsuario() {
		return mUsuario;
	}

	public void setmUsuario(Usuario mUsuario) {
		this.mUsuario = mUsuario;
	}

	public Role getmRole() {
		return mRole;
	}

	public void setmRole(Role mRole) {
		this.mRole = mRole;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

}
