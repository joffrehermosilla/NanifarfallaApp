package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estadousuario")
public class EstadoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estadousuario;
	String nombre_estadousuario;
	String claveApi;

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	public EstadoUsuario() {

	}

	Date version;

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

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}
}
