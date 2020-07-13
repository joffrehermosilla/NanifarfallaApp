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
@Table(name = "zona")
public class Zona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_zona;
	String nombre_zona;
	String claveApi;
	Date version;

	@OneToMany(mappedBy = "mZona", fetch = FetchType.EAGER)
	private Collection<ZonaTieneDistrito> zonatienedistritos = new ArrayList<>();

	public Zona() {

	}

	public Collection<ZonaTieneDistrito> getZonatienedistritos() {
		return zonatienedistritos;
	}

	public void setZonatienedistritos(Collection<ZonaTieneDistrito> zonatienedistritos) {
		this.zonatienedistritos = zonatienedistritos;
	}

	public int getCodigo_zona() {
		return codigo_zona;
	}

	public void setCodigo_zona(int codigo_zona) {
		this.codigo_zona = codigo_zona;
	}

	public String getNombre_zona() {
		return nombre_zona;
	}

	public void setNombre_zona(String nombre_zona) {
		this.nombre_zona = nombre_zona;
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
