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
@Table(name = "linea")
public class Linea {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_linea;
	
	
	@OneToMany(mappedBy = "mLinea",fetch = FetchType.EAGER)
	private Collection<Producto> productos = new ArrayList<>();
	
	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

	private String nombre_linea;
	private String foto_linea = "nanifarfalla.jpeg";
	private Date fechacreacion;
	private String claveApi;
	private Date version;
	
	//@Transient
	//private Producto producto;

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}



	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	public int getCodigo_linea() {
		return codigo_linea;
	}

	public void setCodigo_linea(int codigo_linea) {
		this.codigo_linea = codigo_linea;
	}

	public String getNombre_linea() {
		return nombre_linea;
	}

	public void setNombre_linea(String nombre_linea) {
		this.nombre_linea = nombre_linea;
	}

	public String getFoto_linea() {
		return foto_linea;
	}

	public void setFoto_linea(String foto_linea) {
		this.foto_linea = foto_linea;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

}
