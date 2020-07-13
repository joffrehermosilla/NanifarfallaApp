package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_producto")
public class TipoProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_tipoproducto;
	String nombre_tipoproducto;
	Double tiempo_produccion;
	Double precio_costo;
	String foto_ruta;
	String claveApi;
	Date version;

	public TipoProducto() {

	}

	public int getCodigo_tipoproducto() {
		return codigo_tipoproducto;
	}

	public void setCodigo_tipoproducto(int codigo_tipoproducto) {
		this.codigo_tipoproducto = codigo_tipoproducto;
	}

	public String getNombre_tipoproducto() {
		return nombre_tipoproducto;
	}

	public void setNombre_tipoproducto(String nombre_tipoproducto) {
		this.nombre_tipoproducto = nombre_tipoproducto;
	}

	public Double getTiempo_produccion() {
		return tiempo_produccion;
	}

	public void setTiempo_produccion(Double tiempo_produccion) {
		this.tiempo_produccion = tiempo_produccion;
	}

	public Double getPrecio_costo() {
		return precio_costo;
	}

	public void setPrecio_costo(Double precio_costo) {
		this.precio_costo = precio_costo;
	}

	public String getFoto_ruta() {
		return foto_ruta;
	}

	public void setFoto_ruta(String foto_ruta) {
		this.foto_ruta = foto_ruta;
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

}
