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
@Table(name = "zona_tiene_distrito")
public class ZonaTieneDistrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_zona_tiene_distrito;
	@JoinColumn(name = "fkcodigo_zona", referencedColumnName = "codigo_zona")
	@ManyToOne
	Zona mZona;
	// int fkcodigo_zona;
	@JoinColumn(name = "fkcodigo_distrito", referencedColumnName = "codigo_distrito")
	@ManyToOne
	Distrito mDistrito;
	// int fkcodigo_distrito;
	String claveApi;
	Date version;

	public int getCodigo_zona_tiene_distrito() {
		return codigo_zona_tiene_distrito;
	}

	public void setCodigo_zona_tiene_distrito(int codigo_zona_tiene_distrito) {
		this.codigo_zona_tiene_distrito = codigo_zona_tiene_distrito;
	}

	public Zona getmZona() {
		return mZona;
	}

	public void setmZona(Zona mZona) {
		this.mZona = mZona;
	}

	public Distrito getmDistrito() {
		return mDistrito;
	}

	public void setmDistrito(Distrito mDistrito) {
		this.mDistrito = mDistrito;
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

	public ZonaTieneDistrito() {

	}

}
