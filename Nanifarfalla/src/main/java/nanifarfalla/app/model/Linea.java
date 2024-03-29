package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "linea")
public class Linea {
	private final static Logger LOGGER = LoggerFactory.getLogger(Linea.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_linea;

	@OneToMany(mappedBy = "mLinea")
	private transient Collection<Producto> productos = new ArrayList<>();
	@Column(name = "active")
	private Byte isActive;

	private String nombre_linea;
	private String foto_linea = "nanifarfalla.jpeg";

	private String foto_ruta;
	private String claveApi;
	private Date version;

	// @Transient
	// private Producto producto;

	public String getFoto_ruta() {
		return foto_ruta;
	}

	public boolean isActive() {
		return isActive != null && isActive != 0;
	}

	public void setActive(boolean active) {
		isActive = (byte) (active ? 1 : 0);
	}

	public void setFoto_ruta(String foto_ruta) {
		this.foto_ruta = foto_ruta;
	}

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

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

	public Linea(int codigo_linea, String nombre_linea) {

		this.codigo_linea = codigo_linea;
		this.nombre_linea = nombre_linea;
	}

	public Linea() {
		LOGGER.info("CARGANDO MODEL LINEA");
	}

}
