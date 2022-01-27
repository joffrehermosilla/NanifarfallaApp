package nanifarfalla.app.web.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import nanifarfalla.app.model.Producto;

public class LineaDto {

	private int codigo_linea;

	private transient Collection<Producto> productos = new ArrayList<>();

	private boolean isActive;

	private String nombre_linea;
	private String foto_linea;

	private String foto_ruta;
	private String claveApi;
	private Date version;
	public int getCodigo_linea() {
		return codigo_linea;
	}
	public void setCodigo_linea(int codigo_linea) {
		this.codigo_linea = codigo_linea;
	}
	public Collection<Producto> getProductos() {
		return productos;
	}
	public void setProductos(Collection<Producto> productos) {
		this.productos = productos;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
