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
@Table(name = "menu_roles")
public class MenuRoles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_menuroles;

	@JoinColumn(name = "fkid", referencedColumnName = "id")
	@ManyToOne
	MenuV1 mMenuV1;

	@JoinColumn(name = "fkcodigo_role", referencedColumnName = "codigo_role")
	@ManyToOne
	Role mRole;

//	fkid	fkcodigo_role	
	Date version;

	public MenuRoles() {

	}

	public int getCodigo_menuroles() {
		return codigo_menuroles;
	}

	public void setCodigo_menuroles(int codigo_menuroles) {
		this.codigo_menuroles = codigo_menuroles;
	}

	public MenuV1 getmMenuV1() {
		return mMenuV1;
	}

	public void setmMenuV1(MenuV1 mMenuV1) {
		this.mMenuV1 = mMenuV1;
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

}
