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
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_producto;
	@JoinColumn(name = "fkcodigo_linea", referencedColumnName = "codigo_linea")
	@ManyToOne
	Linea mLinea;
	
	public Linea getmLinea() {
		return mLinea;
	}

	public void setmLinea(Linea mLinea) {
		this.mLinea = mLinea;
	}

	String nombre_producto;
	Date ingreso_almacen;
	Date salida_almacen;
	double stock_producto;
	String preparacion_producto;
	String foto_ruta;
	String colores_producto;
	String qr_producto;
	double ppv_producto;
	double pvf_producto;
	String claveApi;
	Date version;
	


	



	public Producto() {
		System.out.println("Constructor Producto");
	}

	public int getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(int codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public Date getIngreso_almacen() {
		return ingreso_almacen;
	}

	public void setIngreso_almacen(Date ingreso_almacen) {
		this.ingreso_almacen = ingreso_almacen;
	}

	public Date getSalida_almacen() {
		return salida_almacen;
	}

	public void setSalida_almacen(Date salida_almacen) {
		this.salida_almacen = salida_almacen;
	}

	public double getStock_producto() {
		return stock_producto;
	}

	public void setStock_producto(double stock_producto) {
		this.stock_producto = stock_producto;
	}

	public String getPreparacion_producto() {
		return preparacion_producto;
	}

	public void setPreparacion_producto(String preparacion_producto) {
		this.preparacion_producto = preparacion_producto;
	}

	public String getFoto_ruta() {
		return foto_ruta;
	}

	public void setFoto_ruta(String foto_ruta) {
		this.foto_ruta = foto_ruta;
	}

	public String getColores_producto() {
		return colores_producto;
	}

	public void setColores_producto(String colores_producto) {
		this.colores_producto = colores_producto;
	}

	public String getQr_producto() {
		return qr_producto;
	}

	public void setQr_producto(String qr_producto) {
		this.qr_producto = qr_producto;
	}

	public double getPpv_producto() {
		return ppv_producto;
	}

	public void setPpv_producto(double ppv_producto) {
		this.ppv_producto = ppv_producto;
	}

	public double getPvf_producto() {
		return pvf_producto;
	}

	public void setPvf_producto(double pvf_producto) {
		this.pvf_producto = pvf_producto;
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
