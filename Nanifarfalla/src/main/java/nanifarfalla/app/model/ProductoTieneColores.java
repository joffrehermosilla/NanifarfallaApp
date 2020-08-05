package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto_tiene_colores")
public class ProductoTieneColores {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_producto_tiene_colores;
	@JoinColumn(name = "fkcodigo_color", referencedColumnName = "codigo_colores")
	@ManyToOne
	Colores mColores;

	// fkcodigo_color
	@JoinColumn(name = "fkcodigo_producto", referencedColumnName = "codigo_producto")
	@ManyToOne
	Producto mProducto;
//	fkcodigo_producto	
	int stock;
	int disponible;
	String claveApi;
	Date version;

	public int getCodigo_producto_tiene_colores() {
		return codigo_producto_tiene_colores;
	}

	public void setCodigo_producto_tiene_colores(int codigo_producto_tiene_colores) {
		this.codigo_producto_tiene_colores = codigo_producto_tiene_colores;
	}

	public Colores getmColores() {
		return mColores;
	}

	public void setmColores(Colores mColores) {
		this.mColores = mColores;
	}

	public Producto getmProducto() {
		return mProducto;
	}

	public void setmProducto(Producto mProducto) {
		this.mProducto = mProducto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getDisponible() {
		return disponible;
	}

	public void setDisponible(int disponible) {
		this.disponible = disponible;
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

	public ProductoTieneColores() {

	}

}
