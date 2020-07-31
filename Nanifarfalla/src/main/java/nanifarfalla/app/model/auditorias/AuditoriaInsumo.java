package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_insumo")
public class AuditoriaInsumo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audiinsumo;
	String usuario;
	Date fecha_cambio;
	String nombre_insumo_old;
	Date fecha_ingreso_old;
	Date fecha_salida_old;
	int stock_actual_old;
	String codigo_marca_old;
	String marca_insumo_old;
	String lote_marca_insumo_old;
	String descripcion_insumo_old;
	String unidad_medida_old;
	Double cantidad_uni_insumo_almacen_old;
	Double temperatura_ambiente_old;
	Date fecha_vencimiento_old;
	Double precio_unitario_old;
	Double precio_uni_promocion_old;
	String codigo_barras_old;
	String codigo_qr_old;
	int fkcodigo_estadoinsumo_old;
	int fkcodigo_tipoinsumo_old;
	int fkcodigo_presentacioninsumo_old;
	int fkcodigo_loteinsumo_old;
	String claveApi_old;
	Date version_old;
	String nombre_insumo_new;
	Date fecha_ingreso_new;
	Date fecha_salida_new;
	int stock_actual_new;
	String codigo_marca_new;
	String marca_insumo_new;
	String lote_marca_insumo_new;
	String descripcion_insumo_new;
	String unidad_medida_new;
	Double cantidad_uni_insumo_almacen_new;
	Double temperatura_ambiente_new;
	Date fecha_vencimiento_new;
	Double precio_unitario_new;
	Double precio_uni_promocion_new;
	String codigo_barras_new;
	String codigo_qr_new;
	int fkcodigo_estadoinsumo_new;
	int fkcodigo_tipoinsumo_new;
	int fkcodigo_presentacioninsumo_new;
	int fkcodigo_loteinsumo_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaInsumo() {

	}

	public int getCodigo_audiinsumo() {
		return codigo_audiinsumo;
	}

	public void setCodigo_audiinsumo(int codigo_audiinsumo) {
		this.codigo_audiinsumo = codigo_audiinsumo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_cambio() {
		return fecha_cambio;
	}

	public void setFecha_cambio(Date fecha_cambio) {
		this.fecha_cambio = fecha_cambio;
	}

	public String getNombre_insumo_old() {
		return nombre_insumo_old;
	}

	public void setNombre_insumo_old(String nombre_insumo_old) {
		this.nombre_insumo_old = nombre_insumo_old;
	}

	public Date getFecha_ingreso_old() {
		return fecha_ingreso_old;
	}

	public void setFecha_ingreso_old(Date fecha_ingreso_old) {
		this.fecha_ingreso_old = fecha_ingreso_old;
	}

	public Date getFecha_salida_old() {
		return fecha_salida_old;
	}

	public void setFecha_salida_old(Date fecha_salida_old) {
		this.fecha_salida_old = fecha_salida_old;
	}

	public int getStock_actual_old() {
		return stock_actual_old;
	}

	public void setStock_actual_old(int stock_actual_old) {
		this.stock_actual_old = stock_actual_old;
	}

	public String getCodigo_marca_old() {
		return codigo_marca_old;
	}

	public void setCodigo_marca_old(String codigo_marca_old) {
		this.codigo_marca_old = codigo_marca_old;
	}

	public String getMarca_insumo_old() {
		return marca_insumo_old;
	}

	public void setMarca_insumo_old(String marca_insumo_old) {
		this.marca_insumo_old = marca_insumo_old;
	}

	public String getLote_marca_insumo_old() {
		return lote_marca_insumo_old;
	}

	public void setLote_marca_insumo_old(String lote_marca_insumo_old) {
		this.lote_marca_insumo_old = lote_marca_insumo_old;
	}

	public String getDescripcion_insumo_old() {
		return descripcion_insumo_old;
	}

	public void setDescripcion_insumo_old(String descripcion_insumo_old) {
		this.descripcion_insumo_old = descripcion_insumo_old;
	}

	public String getUnidad_medida_old() {
		return unidad_medida_old;
	}

	public void setUnidad_medida_old(String unidad_medida_old) {
		this.unidad_medida_old = unidad_medida_old;
	}

	public Double getCantidad_uni_insumo_almacen_old() {
		return cantidad_uni_insumo_almacen_old;
	}

	public void setCantidad_uni_insumo_almacen_old(Double cantidad_uni_insumo_almacen_old) {
		this.cantidad_uni_insumo_almacen_old = cantidad_uni_insumo_almacen_old;
	}

	public Double getTemperatura_ambiente_old() {
		return temperatura_ambiente_old;
	}

	public void setTemperatura_ambiente_old(Double temperatura_ambiente_old) {
		this.temperatura_ambiente_old = temperatura_ambiente_old;
	}

	public Date getFecha_vencimiento_old() {
		return fecha_vencimiento_old;
	}

	public void setFecha_vencimiento_old(Date fecha_vencimiento_old) {
		this.fecha_vencimiento_old = fecha_vencimiento_old;
	}

	public Double getPrecio_unitario_old() {
		return precio_unitario_old;
	}

	public void setPrecio_unitario_old(Double precio_unitario_old) {
		this.precio_unitario_old = precio_unitario_old;
	}

	public Double getPrecio_uni_promocion_old() {
		return precio_uni_promocion_old;
	}

	public void setPrecio_uni_promocion_old(Double precio_uni_promocion_old) {
		this.precio_uni_promocion_old = precio_uni_promocion_old;
	}

	public String getCodigo_barras_old() {
		return codigo_barras_old;
	}

	public void setCodigo_barras_old(String codigo_barras_old) {
		this.codigo_barras_old = codigo_barras_old;
	}

	public String getCodigo_qr_old() {
		return codigo_qr_old;
	}

	public void setCodigo_qr_old(String codigo_qr_old) {
		this.codigo_qr_old = codigo_qr_old;
	}

	public int getFkcodigo_estadoinsumo_old() {
		return fkcodigo_estadoinsumo_old;
	}

	public void setFkcodigo_estadoinsumo_old(int fkcodigo_estadoinsumo_old) {
		this.fkcodigo_estadoinsumo_old = fkcodigo_estadoinsumo_old;
	}

	public int getFkcodigo_tipoinsumo_old() {
		return fkcodigo_tipoinsumo_old;
	}

	public void setFkcodigo_tipoinsumo_old(int fkcodigo_tipoinsumo_old) {
		this.fkcodigo_tipoinsumo_old = fkcodigo_tipoinsumo_old;
	}

	public int getFkcodigo_presentacioninsumo_old() {
		return fkcodigo_presentacioninsumo_old;
	}

	public void setFkcodigo_presentacioninsumo_old(int fkcodigo_presentacioninsumo_old) {
		this.fkcodigo_presentacioninsumo_old = fkcodigo_presentacioninsumo_old;
	}

	public int getFkcodigo_loteinsumo_old() {
		return fkcodigo_loteinsumo_old;
	}

	public void setFkcodigo_loteinsumo_old(int fkcodigo_loteinsumo_old) {
		this.fkcodigo_loteinsumo_old = fkcodigo_loteinsumo_old;
	}

	public String getClaveApi_old() {
		return claveApi_old;
	}

	public void setClaveApi_old(String claveApi_old) {
		this.claveApi_old = claveApi_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getNombre_insumo_new() {
		return nombre_insumo_new;
	}

	public void setNombre_insumo_new(String nombre_insumo_new) {
		this.nombre_insumo_new = nombre_insumo_new;
	}

	public Date getFecha_ingreso_new() {
		return fecha_ingreso_new;
	}

	public void setFecha_ingreso_new(Date fecha_ingreso_new) {
		this.fecha_ingreso_new = fecha_ingreso_new;
	}

	public Date getFecha_salida_new() {
		return fecha_salida_new;
	}

	public void setFecha_salida_new(Date fecha_salida_new) {
		this.fecha_salida_new = fecha_salida_new;
	}

	public int getStock_actual_new() {
		return stock_actual_new;
	}

	public void setStock_actual_new(int stock_actual_new) {
		this.stock_actual_new = stock_actual_new;
	}

	public String getCodigo_marca_new() {
		return codigo_marca_new;
	}

	public void setCodigo_marca_new(String codigo_marca_new) {
		this.codigo_marca_new = codigo_marca_new;
	}

	public String getMarca_insumo_new() {
		return marca_insumo_new;
	}

	public void setMarca_insumo_new(String marca_insumo_new) {
		this.marca_insumo_new = marca_insumo_new;
	}

	public String getLote_marca_insumo_new() {
		return lote_marca_insumo_new;
	}

	public void setLote_marca_insumo_new(String lote_marca_insumo_new) {
		this.lote_marca_insumo_new = lote_marca_insumo_new;
	}

	public String getDescripcion_insumo_new() {
		return descripcion_insumo_new;
	}

	public void setDescripcion_insumo_new(String descripcion_insumo_new) {
		this.descripcion_insumo_new = descripcion_insumo_new;
	}

	public String getUnidad_medida_new() {
		return unidad_medida_new;
	}

	public void setUnidad_medida_new(String unidad_medida_new) {
		this.unidad_medida_new = unidad_medida_new;
	}

	public Double getCantidad_uni_insumo_almacen_new() {
		return cantidad_uni_insumo_almacen_new;
	}

	public void setCantidad_uni_insumo_almacen_new(Double cantidad_uni_insumo_almacen_new) {
		this.cantidad_uni_insumo_almacen_new = cantidad_uni_insumo_almacen_new;
	}

	public Double getTemperatura_ambiente_new() {
		return temperatura_ambiente_new;
	}

	public void setTemperatura_ambiente_new(Double temperatura_ambiente_new) {
		this.temperatura_ambiente_new = temperatura_ambiente_new;
	}

	public Date getFecha_vencimiento_new() {
		return fecha_vencimiento_new;
	}

	public void setFecha_vencimiento_new(Date fecha_vencimiento_new) {
		this.fecha_vencimiento_new = fecha_vencimiento_new;
	}

	public Double getPrecio_unitario_new() {
		return precio_unitario_new;
	}

	public void setPrecio_unitario_new(Double precio_unitario_new) {
		this.precio_unitario_new = precio_unitario_new;
	}

	public Double getPrecio_uni_promocion_new() {
		return precio_uni_promocion_new;
	}

	public void setPrecio_uni_promocion_new(Double precio_uni_promocion_new) {
		this.precio_uni_promocion_new = precio_uni_promocion_new;
	}

	public String getCodigo_barras_new() {
		return codigo_barras_new;
	}

	public void setCodigo_barras_new(String codigo_barras_new) {
		this.codigo_barras_new = codigo_barras_new;
	}

	public String getCodigo_qr_new() {
		return codigo_qr_new;
	}

	public void setCodigo_qr_new(String codigo_qr_new) {
		this.codigo_qr_new = codigo_qr_new;
	}

	public int getFkcodigo_estadoinsumo_new() {
		return fkcodigo_estadoinsumo_new;
	}

	public void setFkcodigo_estadoinsumo_new(int fkcodigo_estadoinsumo_new) {
		this.fkcodigo_estadoinsumo_new = fkcodigo_estadoinsumo_new;
	}

	public int getFkcodigo_tipoinsumo_new() {
		return fkcodigo_tipoinsumo_new;
	}

	public void setFkcodigo_tipoinsumo_new(int fkcodigo_tipoinsumo_new) {
		this.fkcodigo_tipoinsumo_new = fkcodigo_tipoinsumo_new;
	}

	public int getFkcodigo_presentacioninsumo_new() {
		return fkcodigo_presentacioninsumo_new;
	}

	public void setFkcodigo_presentacioninsumo_new(int fkcodigo_presentacioninsumo_new) {
		this.fkcodigo_presentacioninsumo_new = fkcodigo_presentacioninsumo_new;
	}

	public int getFkcodigo_loteinsumo_new() {
		return fkcodigo_loteinsumo_new;
	}

	public void setFkcodigo_loteinsumo_new(int fkcodigo_loteinsumo_new) {
		this.fkcodigo_loteinsumo_new = fkcodigo_loteinsumo_new;
	}

	public String getClaveApi_new() {
		return claveApi_new;
	}

	public void setClaveApi_new(String claveApi_new) {
		this.claveApi_new = claveApi_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
