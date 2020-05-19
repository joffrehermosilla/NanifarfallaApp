package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int codigo_pais;
	
	String nombre_pais;
	String claveApi;
	Date version;
	public Pais() {

	}
	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public int getCodigo_pais() {
		return codigo_pais;
	}



	public void setCodigo_pais(int codigo_pais) {
		this.codigo_pais = codigo_pais;
	}

	public String getNombre_pais() {
		return nombre_pais;
	}

	public void setNombre_pais(String nombre_pais) {
		this.nombre_pais = nombre_pais;
	}

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

}
