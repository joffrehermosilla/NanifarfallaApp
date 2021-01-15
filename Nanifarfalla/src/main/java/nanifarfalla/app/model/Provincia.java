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

	@OneToMany(mappedBy = "mPais", fetch = FetchType.EAGER)
	private Collection<Provincia> provincias = new ArrayList<>();
	
	
	
	public Collection<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(Collection<Provincia> provincias) {
		this.provincias = provincias;
	}

	public Provincia() {

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
