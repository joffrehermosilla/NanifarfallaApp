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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "estadousuario")
public class EstadoUsuario {
	private final static Logger LOGGER = LoggerFactory.getLogger(EstadoUsuario.class);
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estadousuario;

	String nombre_estadousuario;

	@OneToMany(mappedBy = "mEstadoUsuario", fetch = FetchType.EAGER)
	private Collection<Usuario> usuarios = new ArrayList<>();

	public EstadoUsuario() {

		LOGGER.info("Inicio Model Constructor Estado Usuario");
	}

	Date version;

	public EstadoUsuario(int codigo_estadousuario, String nombre_estadousuario, Collection<Usuario> usuarios,
			Date version) {
		System.out.println("Inicio Model Constructor Estado Usuario");
		this.codigo_estadousuario = codigo_estadousuario;
		this.nombre_estadousuario = nombre_estadousuario;
		this.usuarios = usuarios;
		this.version = version;
	}

	public int getCodigo_estadousuario() {
		return codigo_estadousuario;
	}

	public void setCodigo_estadousuario(int codigo_estadousuario) {
		this.codigo_estadousuario = codigo_estadousuario;
	}

	public String getNombre_estadousuario() {
		return nombre_estadousuario;
	}

	public void setNombre_estadousuario(String nombre_estadousuario) {
		this.nombre_estadousuario = nombre_estadousuario;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
