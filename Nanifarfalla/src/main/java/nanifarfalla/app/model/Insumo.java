package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "insumo")
public class Insumo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_insumo;
	String nombre_insumo;
	Date fecha_ingreso;
	Date fecha_salida;
	int stock_actual;
	String codigo_marca;
	String marca_insumo;
	String lote_marca_insumo;
	String descripcion_insumo;
	String unidad_medida;
	Double cantidad_uni_insumo_almacen;
	Double temperatura_ambiente;
	Date fecha_vencimiento;
	Double precio_unitario;
	Double precio_uni_promocion;
	String codigo_barras;
	String codigo_qr;
	String foto_ruta;
	String claveApi;
	Date version;
	@JoinColumn(name = "fk_codigo_estadoinsumo", referencedColumnName = "codigo_estadoinsumo")
	@ManyToOne
	EstadoInsumo mEstadoinsumo;

	@JoinColumn(name = "fkcodigo_tipoinsumo", referencedColumnName = "codigo_tipoinsumo")
	@ManyToOne
	TipoInsumo mTipoinsumo;

	@JoinColumn(name = "fkcodigo_presentacioninsumo", referencedColumnName = "codigo_presentacioninsumo")
	@ManyToOne
	PresentacionInsumo mPresentacion_insumo;

	@JoinColumn(name = "fkcodigo_loteinsumo", referencedColumnName = "codigo_loteinsumo")
	@ManyToOne
	private LoteInsumo mLoteinsumo;

	@OneToMany(mappedBy = "mInsumo")
	private Collection<RecetaProductotieneInsumo> recetasproductoinsumos = new ArrayList<>();

	public int getCodigo_insumo() {
		return codigo_insumo;
	}

	public void setCodigo_insumo(int codigo_insumo) {
		this.codigo_insumo = codigo_insumo;
	}

	public String getNombre_insumo() {
		return nombre_insumo;
	}

	public void setNombre_insumo(String nombre_insumo) {
		this.nombre_insumo = nombre_insumo;
	}

	public Date getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(Date fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public int getStock_actual() {
		return stock_actual;
	}

	public void setStock_actual(int stock_actual) {
		this.stock_actual = stock_actual;
	}

	public String getCodigo_marca() {
		return codigo_marca;
	}

	public void setCodigo_marca(String codigo_marca) {
		this.codigo_marca = codigo_marca;
	}

	public String getMarca_insumo() {
		return marca_insumo;
	}

	public void setMarca_insumo(String marca_insumo) {
		this.marca_insumo = marca_insumo;
	}

	public String getLote_marca_insumo() {
		return lote_marca_insumo;
	}

	public void setLote_marca_insumo(String lote_marca_insumo) {
		this.lote_marca_insumo = lote_marca_insumo;
	}

	public String getDescripcion_insumo() {
		return descripcion_insumo;
	}

	public void setDescripcion_insumo(String descripcion_insumo) {
		this.descripcion_insumo = descripcion_insumo;
	}

	public String getUnidad_medida() {
		return unidad_medida;
	}

	public void setUnidad_medida(String unidad_medida) {
		this.unidad_medida = unidad_medida;
	}

	public Double getCantidad_uni_insumo_almacen() {
		return cantidad_uni_insumo_almacen;
	}

	public void setCantidad_uni_insumo_almacen(Double cantidad_uni_insumo_almacen) {
		this.cantidad_uni_insumo_almacen = cantidad_uni_insumo_almacen;
	}

	public Double getTemperatura_ambiente() {
		return temperatura_ambiente;
	}

	public void setTemperatura_ambiente(Double temperatura_ambiente) {
		this.temperatura_ambiente = temperatura_ambiente;
	}

	public Date getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(Date fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public Double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public Double getPrecio_uni_promocion() {
		return precio_uni_promocion;
	}

	public void setPrecio_uni_promocion(Double precio_uni_promocion) {
		this.precio_uni_promocion = precio_uni_promocion;
	}

	public String getCodigo_barras() {
		return codigo_barras;
	}

	public void setCodigo_barras(String codigo_barras) {
		this.codigo_barras = codigo_barras;
	}

	public String getCodigo_qr() {
		return codigo_qr;
	}

	public void setCodigo_qr(String codigo_qr) {
		this.codigo_qr = codigo_qr;
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

	public EstadoInsumo getmEstadoinsumo() {
		return mEstadoinsumo;
	}

	public void setmEstadoinsumo(EstadoInsumo mEstadoinsumo) {
		this.mEstadoinsumo = mEstadoinsumo;
	}

	public TipoInsumo getmTipoinsumo() {
		return mTipoinsumo;
	}

	public void setmTipoinsumo(TipoInsumo mTipoinsumo) {
		this.mTipoinsumo = mTipoinsumo;
	}

	public PresentacionInsumo getmPresentacion_insumo() {
		return mPresentacion_insumo;
	}

	public void setmPresentacion_insumo(PresentacionInsumo mPresentacion_insumo) {
		this.mPresentacion_insumo = mPresentacion_insumo;
	}

	public LoteInsumo getmLoteinsumo() {
		return mLoteinsumo;
	}

	public void setmLoteinsumo(LoteInsumo mLoteinsumo) {
		this.mLoteinsumo = mLoteinsumo;
	}

	public Collection<RecetaProductotieneInsumo> getRecetasproductoinsumos() {
		return recetasproductoinsumos;
	}

	public void setRecetasproductoinsumos(Collection<RecetaProductotieneInsumo> recetasproductoinsumos) {
		this.recetasproductoinsumos = recetasproductoinsumos;
	}

	public Insumo() {

	}

}
