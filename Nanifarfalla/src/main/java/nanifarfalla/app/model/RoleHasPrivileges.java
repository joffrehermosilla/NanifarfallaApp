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
@Table(name = "rolehasprivilege")
public class RoleHasPrivileges {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_rolehasprivilege;

	@JoinColumn(name = "fkcodigo_role", referencedColumnName = "codigo_role")
	@ManyToOne
	Role mRole;

//	int fkcodigo_role;
	@JoinColumn(name = "fkcodigo_privilege", referencedColumnName = "codigo_privilege")
	@ManyToOne
	Privilege mPrivilege;
//	int fkcodigo_privilege;
	Date version;

	public RoleHasPrivileges() {

	}

	public int getCodigo_rolehasprivilege() {
		return codigo_rolehasprivilege;
	}

	public void setCodigo_rolehasprivilege(int codigo_rolehasprivilege) {
		this.codigo_rolehasprivilege = codigo_rolehasprivilege;
	}

	public Role getmRole() {
		return mRole;
	}

	public void setmRole(Role mRole) {
		this.mRole = mRole;
	}

	public Privilege getmPrivilege() {
		return mPrivilege;
	}

	public void setmPrivilege(Privilege mPrivilege) {
		this.mPrivilege = mPrivilege;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
