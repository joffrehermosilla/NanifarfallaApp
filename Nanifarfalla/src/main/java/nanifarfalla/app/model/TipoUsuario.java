package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipousuario")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_tipousuario;
	String nombre_tipousuario;
	Date version;

	public TipoUsuario() {

	}

	public int getCodigo_tipousuario() {
		return codigo_tipousuario;
	}

	public void setCodigo_tipousuario(int codigo_tipousuario) {
		this.codigo_tipousuario = codigo_tipousuario;
	}

	public String getNombre_tipousuario() {
		return nombre_tipousuario;
	}

	public void setNombre_tipousuario(String nombre_tipousuario) {
		this.nombre_tipousuario = nombre_tipousuario;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
