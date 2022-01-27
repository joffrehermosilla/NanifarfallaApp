package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipousuario")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_tipousuario;
	String nombre_tipousuario;
	Date version;

	@OneToMany(mappedBy = "mTipoUsuario", fetch = FetchType.EAGER)
	private Collection<Usuario> usuarios = new ArrayList<>();

	
	
	public TipoUsuario(int codigo_tipousuario, String nombre_tipousuario, Date version, Collection<Usuario> usuarios) {
		System.out.println("Inicio Model Constructor Tipo Usuario");
		this.codigo_tipousuario = codigo_tipousuario;
		this.nombre_tipousuario = nombre_tipousuario;
		this.version = version;
		this.usuarios = usuarios;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

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
