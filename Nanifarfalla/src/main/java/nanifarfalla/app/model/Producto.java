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
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_producto;
	String nombre_producto;
	double stock_producto;
	String preparacion_producto;
	String foto_ruta;
	String colores_producto;
	String qr_producto;
	double ppv_producto;
	double pvf_producto;
	String claveApi;
	Date version;
	Date ingreso_almacen_producto;
	Date salida_almacen_producto;
	String foto_ruta1;
	String foto_ruta2;
	String foto_ruta3;
	String foto_ruta4;

	public Collection<ProductoTieneColores> getProductoTieneColores() {
		return productoTieneColores;
	}

	public void setProductoTieneColores(Collection<ProductoTieneColores> productoTieneColores) {
		this.productoTieneColores = productoTieneColores;
	}

	@OneToMany(mappedBy = "mColores", fetch = FetchType.EAGER)
	private Collection<ProductoTieneColores> productoTieneColores = new ArrayList<>();

	@JoinColumn(name = "fkcodigo_tipoproducto", referencedColumnName = "codigo_tipoproducto")
	@ManyToOne
	TipoProducto mTipoProducto;

	@JoinColumn(name = "fkcodigo_estadoproducto", referencedColumnName = "codigo_estadoproducto")
	@ManyToOne
	EstadoProducto mEstadoProducto;

	@JoinColumn(name = "fkcodigo_linea", referencedColumnName = "codigo_linea")
	@ManyToOne
	Linea mLinea;

	@OneToMany(mappedBy = "mProducto", fetch = FetchType.LAZY)
	private Collection<RecetaProductoTieneInsumo> recetaproductostienenInsumo = new ArrayList<>();

	public void setRecetaproductostienenInsumo(Collection<RecetaProductoTieneInsumo> recetaproductostienenInsumo) {
		this.recetaproductostienenInsumo = recetaproductostienenInsumo;
	}

	@OneToMany(mappedBy = "mProducto")
	private Collection<ProductoxPedido> productoxpedido = new ArrayList<>();

	public Collection<ProductoxPedido> getProductoxpedido() {
		return productoxpedido;
	}

	public void setProductoxpedido(Collection<ProductoxPedido> productoxpedido) {
		this.productoxpedido = productoxpedido;
	}



	public Linea getmLinea() {
		return mLinea;
	}

	public void setmLinea(Linea mLinea) {
		this.mLinea = mLinea;
	}

	public Date getIngreso_almacen_producto() {
		return ingreso_almacen_producto;
	}

	public void setIngreso_almacen_producto(Date ingreso_almacen_producto) {
		this.ingreso_almacen_producto = ingreso_almacen_producto;
	}

	public Date getSalida_almacen_producto() {
		return salida_almacen_producto;
	}

	public void setSalida_almacen_producto(Date salida_almacen_producto) {
		this.salida_almacen_producto = salida_almacen_producto;
	}

	public String getFoto_ruta1() {
		return foto_ruta1;
	}

	public void setFoto_ruta1(String foto_ruta1) {
		this.foto_ruta1 = foto_ruta1;
	}

	public String getFoto_ruta2() {
		return foto_ruta2;
	}

	public void setFoto_ruta2(String foto_ruta2) {
		this.foto_ruta2 = foto_ruta2;
	}

	public String getFoto_ruta3() {
		return foto_ruta3;
	}

	public void setFoto_ruta3(String foto_ruta3) {
		this.foto_ruta3 = foto_ruta3;
	}

	public String getFoto_ruta4() {
		return foto_ruta4;
	}

	public void setFoto_ruta4(String foto_ruta4) {
		this.foto_ruta4 = foto_ruta4;
	}

	public TipoProducto getmTipoProducto() {
		return mTipoProducto;
	}

	public void setmTipoProducto(TipoProducto mTipoProducto) {
		this.mTipoProducto = mTipoProducto;
	}

	public EstadoProducto getmEstadoProducto() {
		return mEstadoProducto;
	}

	public void setmEstadoProducto(EstadoProducto mEstadoProducto) {
		this.mEstadoProducto = mEstadoProducto;
	}

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
