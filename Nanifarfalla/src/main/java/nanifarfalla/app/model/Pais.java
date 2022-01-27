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
@Table(name = "pais")
public class Pais  {
	private final static Logger LOGGER = LoggerFactory.getLogger(Pais.class);
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_pais;

	String nombre_pais;

	Date version;
	@OneToMany(mappedBy = "mPais", fetch = FetchType.EAGER)
	private transient Collection<Provincia> provincias = new ArrayList<>();

	public Collection<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(Collection<Provincia> provincias) {
		this.provincias = provincias;
	}

	public Pais() {
		LOGGER.info("PAIS MODEL CARGADO");
	}

	public Pais(String nombre_pais) {
     this.nombre_pais= nombre_pais;
	}
	public Pais(String nombre_pais,Collection<Provincia> provincias) {
       this.nombre_pais = nombre_pais;
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

}
