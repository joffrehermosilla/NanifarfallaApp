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
@Table(name = "estado_producto")
public class EstadoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estadoproducto;
	String nombre_estado_producto;
	String claveApi;
	Date version;

	@OneToMany(mappedBy = "mEstadoProducto", fetch = FetchType.EAGER)
	private Collection<Producto> productos = new ArrayList<>();

	public EstadoProducto() {

	}

	public int getCodigo_estadoproducto() {
		return codigo_estadoproducto;
	}

	public void setCodigo_estadoproducto(int codigo_estadoproducto) {
		this.codigo_estadoproducto = codigo_estadoproducto;
	}

	public String getNombre_estado_producto() {
		return nombre_estado_producto;
	}

	public void setNombre_estado_producto(String nombre_estado_producto) {
		this.nombre_estado_producto = nombre_estado_producto;
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

	public Collection<Producto> getProductos() {
		return productos;
	}

	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}

}
