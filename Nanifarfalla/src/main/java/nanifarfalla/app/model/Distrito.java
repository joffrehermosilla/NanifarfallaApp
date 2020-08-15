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
@Table(name = "distrito")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_distrito;
	@JoinColumn(name = "fkcodigo_ciudad", referencedColumnName = "codigo_ciudad")
	@ManyToOne
	Ciudad mCiudad;
//	int fkcodigo_ciudad;
	String nombre_distrito;
	Date version;

	@OneToMany(mappedBy = "mDistrito", fetch = FetchType.EAGER)
	private Collection<Usuario> usuarios = new ArrayList<>();

	@OneToMany(mappedBy = "mDistrito", fetch = FetchType.LAZY)
	private Collection<ZonaTieneDistrito> zonatienedistritos = new ArrayList<>();

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Collection<ZonaTieneDistrito> getZonatienedistritos() {
		return zonatienedistritos;
	}

	public void setZonatienedistritos(Collection<ZonaTieneDistrito> zonatienedistritos) {
		this.zonatienedistritos = zonatienedistritos;
	}

	public Distrito() {

	}

	public int getCodigo_distrito() {
		return codigo_distrito;
	}

	public void setCodigo_distrito(int codigo_distrito) {
		this.codigo_distrito = codigo_distrito;
	}

	public Ciudad getmCiudad() {
		return mCiudad;
	}

	public void setmCiudad(Ciudad mCiudad) {
		this.mCiudad = mCiudad;
	}

	public String getNombre_distrito() {
		return nombre_distrito;
	}

	public void setNombre_distrito(String nombre_distrito) {
		this.nombre_distrito = nombre_distrito;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
