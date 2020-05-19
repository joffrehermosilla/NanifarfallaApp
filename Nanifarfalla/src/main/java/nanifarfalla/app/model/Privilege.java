package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "privilege")
public class Privilege {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_privilege;
	String nombre_privilege;
	Date version;

	public int getCodigo_privilege() {
		return codigo_privilege;
	}

	public void setCodigo_privilege(int codigo_privilege) {
		this.codigo_privilege = codigo_privilege;
	}

	public String getNombre_privilege() {
		return nombre_privilege;
	}

	public void setNombre_privilege(String nombre_privilege) {
		this.nombre_privilege = nombre_privilege;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public Privilege() {

	}

}
