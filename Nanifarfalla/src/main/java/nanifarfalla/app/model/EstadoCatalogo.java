package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_catalogo")
public class EstadoCatalogo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estadoCatalogo;
	String descripcion;
	String claveApi;
	Date version;

	public int getCodigo_estadoCatalogo() {
		return codigo_estadoCatalogo;
	}

	public EstadoCatalogo() {

	}

	public void setCodigo_estadoCatalogo(int codigo_estadoCatalogo) {
		this.codigo_estadoCatalogo = codigo_estadoCatalogo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
