package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "provincia")
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_provincia;

	@JoinColumn(name = "fkcodigo_pais", referencedColumnName = "codigo_pais")
	@ManyToOne
	Pais mPais;
	// int fkcodigo_pais;
	String nombre_provincia;

	@OneToMany(mappedBy = "mProvincias", fetch = FetchType.EAGER)
	private transient Collection<Ciudad> ciudades = new ArrayList<>();

	public Collection<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(Collection<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public Provincia() {

	}

	public Provincia(int codigo_provincia, String nombre_provincia) {
		this.codigo_provincia = codigo_provincia;
		this.nombre_provincia = nombre_provincia;
	}

	public int getCodigo_provincia() {
		return codigo_provincia;
	}

	public void setCodigo_provincia(int codigo_provincia) {
		this.codigo_provincia = codigo_provincia;
	}

	public Pais getmPais() {
		return mPais;
	}

	public void setmPais(Pais mPais) {
		this.mPais = mPais;
	}

	public String getNombre_provincia() {
		return nombre_provincia;
	}

	public void setNombre_provincia(String nombre_provincia) {
		this.nombre_provincia = nombre_provincia;
	}

}
