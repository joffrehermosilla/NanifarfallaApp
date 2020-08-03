package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

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
@Table(name = "ciudad")
public class Ciudad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_ciudad;
	@JoinColumn(name = "fkcodigo_provincia", referencedColumnName = "codigo_provincia")
	@ManyToOne
	Provincia mProvincia;
	
	//int fkcodigo_provincia;
	String nombre_ciudad;
	Date version;

	@OneToMany(mappedBy = "mCiudad", fetch = FetchType.EAGER)
	private Collection<Distrito> distritos = new ArrayList<>();
	
	public Ciudad() {

	}

	public Collection<Distrito> getDistritos() {
		return distritos;
	}

	public void setDistritos(Collection<Distrito> distritos) {
		this.distritos = distritos;
	}

	public int getCodigo_ciudad() {
		return codigo_ciudad;
	}

	public void setCodigo_ciudad(int codigo_ciudad) {
		this.codigo_ciudad = codigo_ciudad;
	}

	public Provincia getmProvincia() {
		return mProvincia;
	}

	public void setmProvincia(Provincia mProvincia) {
		this.mProvincia = mProvincia;
	}



	public String getNombre_ciudad() {
		return nombre_ciudad;
	}

	public void setNombre_ciudad(String nombre_ciudad) {
		this.nombre_ciudad = nombre_ciudad;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
