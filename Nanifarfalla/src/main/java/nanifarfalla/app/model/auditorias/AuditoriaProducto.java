package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_producto")
public class AuditoriaProducto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_auditoria_producto;

	String usuario;
	Date fecha_cambio;
	String nombre_producto_old;
	Date ingreso_almacen_producto_old;
	Date salida_almacen_producto_old;
	int stock_producto_old;
	String preparacion_producto_old;
	String foto_ruta1_old;
	String foto_ruta2_old;
	String foto_ruta3_old;
	String foto_ruta4_old;
	String colores_producto_old;
	String qr_producto_old;
	Double pvv_producto_old;
	Double pvf_producto_old;
	int fkcodigo_linea_old;
	int fkcodigo_tipoproducto_old;
	int fkcodigo_estadoproducto_old;
	String claveApi_old;
	Date version_old;
	String nombre_producto_new;
	Date ingreso_almacen_producto_new;
	Date salida_almacen_producto_new;
	int stock_producto_new;
	String preparacion_producto_new;
	String foto_ruta1_new;
	String foto_ruta2_new;
	String foto_ruta3_new;
	String foto_ruta4_new;
	String colores_producto_new;
	String qr_producto_new;
	Double pvv_producto_new;
	Double pvf_producto_new;
	int fkcodigo_linea_new;
	int fkcodigo_tipoproducto_new;
	int fkcodigo_estadoproducto_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaProducto() {

	}

	public int getCodigo_auditoria_producto() {
		return codigo_auditoria_producto;
	}

	public void setCodigo_auditoria_producto(int codigo_auditoria_producto) {
		this.codigo_auditoria_producto = codigo_auditoria_producto;
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

	public String getNombre_producto_old() {
		return nombre_producto_old;
	}

	public void setNombre_producto_old(String nombre_producto_old) {
		this.nombre_producto_old = nombre_producto_old;
	}

	public Date getIngreso_almacen_producto_old() {
		return ingreso_almacen_producto_old;
	}

	public void setIngreso_almacen_producto_old(Date ingreso_almacen_producto_old) {
		this.ingreso_almacen_producto_old = ingreso_almacen_producto_old;
	}

	public Date getSalida_almacen_producto_old() {
		return salida_almacen_producto_old;
	}

	public void setSalida_almacen_producto_old(Date salida_almacen_producto_old) {
		this.salida_almacen_producto_old = salida_almacen_producto_old;
	}

	public int getStock_producto_old() {
		return stock_producto_old;
	}

	public void setStock_producto_old(int stock_producto_old) {
		this.stock_producto_old = stock_producto_old;
	}

	public String getPreparacion_producto_old() {
		return preparacion_producto_old;
	}

	public void setPreparacion_producto_old(String preparacion_producto_old) {
		this.preparacion_producto_old = preparacion_producto_old;
	}

	public String getFoto_ruta1_old() {
		return foto_ruta1_old;
	}

	public void setFoto_ruta1_old(String foto_ruta1_old) {
		this.foto_ruta1_old = foto_ruta1_old;
	}

	public String getFoto_ruta2_old() {
		return foto_ruta2_old;
	}

	public void setFoto_ruta2_old(String foto_ruta2_old) {
		this.foto_ruta2_old = foto_ruta2_old;
	}

	public String getFoto_ruta3_old() {
		return foto_ruta3_old;
	}

	public void setFoto_ruta3_old(String foto_ruta3_old) {
		this.foto_ruta3_old = foto_ruta3_old;
	}

	public String getFoto_ruta4_old() {
		return foto_ruta4_old;
	}

	public void setFoto_ruta4_old(String foto_ruta4_old) {
		this.foto_ruta4_old = foto_ruta4_old;
	}

	public String getColores_producto_old() {
		return colores_producto_old;
	}

	public void setColores_producto_old(String colores_producto_old) {
		this.colores_producto_old = colores_producto_old;
	}

	public String getQr_producto_old() {
		return qr_producto_old;
	}

	public void setQr_producto_old(String qr_producto_old) {
		this.qr_producto_old = qr_producto_old;
	}

	public Double getPvv_producto_old() {
		return pvv_producto_old;
	}

	public void setPvv_producto_old(Double pvv_producto_old) {
		this.pvv_producto_old = pvv_producto_old;
	}

	public Double getPvf_producto_old() {
		return pvf_producto_old;
	}

	public void setPvf_producto_old(Double pvf_producto_old) {
		this.pvf_producto_old = pvf_producto_old;
	}

	public int getFkcodigo_linea_old() {
		return fkcodigo_linea_old;
	}

	public void setFkcodigo_linea_old(int fkcodigo_linea_old) {
		this.fkcodigo_linea_old = fkcodigo_linea_old;
	}

	public int getFkcodigo_tipoproducto_old() {
		return fkcodigo_tipoproducto_old;
	}

	public void setFkcodigo_tipoproducto_old(int fkcodigo_tipoproducto_old) {
		this.fkcodigo_tipoproducto_old = fkcodigo_tipoproducto_old;
	}

	public int getFkcodigo_estadoproducto_old() {
		return fkcodigo_estadoproducto_old;
	}

	public void setFkcodigo_estadoproducto_old(int fkcodigo_estadoproducto_old) {
		this.fkcodigo_estadoproducto_old = fkcodigo_estadoproducto_old;
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

	public String getNombre_producto_new() {
		return nombre_producto_new;
	}

	public void setNombre_producto_new(String nombre_producto_new) {
		this.nombre_producto_new = nombre_producto_new;
	}

	public Date getIngreso_almacen_producto_new() {
		return ingreso_almacen_producto_new;
	}

	public void setIngreso_almacen_producto_new(Date ingreso_almacen_producto_new) {
		this.ingreso_almacen_producto_new = ingreso_almacen_producto_new;
	}

	public Date getSalida_almacen_producto_new() {
		return salida_almacen_producto_new;
	}

	public void setSalida_almacen_producto_new(Date salida_almacen_producto_new) {
		this.salida_almacen_producto_new = salida_almacen_producto_new;
	}

	public int getStock_producto_new() {
		return stock_producto_new;
	}

	public void setStock_producto_new(int stock_producto_new) {
		this.stock_producto_new = stock_producto_new;
	}

	public String getPreparacion_producto_new() {
		return preparacion_producto_new;
	}

	public void setPreparacion_producto_new(String preparacion_producto_new) {
		this.preparacion_producto_new = preparacion_producto_new;
	}

	public String getFoto_ruta1_new() {
		return foto_ruta1_new;
	}

	public void setFoto_ruta1_new(String foto_ruta1_new) {
		this.foto_ruta1_new = foto_ruta1_new;
	}

	public String getFoto_ruta2_new() {
		return foto_ruta2_new;
	}

	public void setFoto_ruta2_new(String foto_ruta2_new) {
		this.foto_ruta2_new = foto_ruta2_new;
	}

	public String getFoto_ruta3_new() {
		return foto_ruta3_new;
	}

	public void setFoto_ruta3_new(String foto_ruta3_new) {
		this.foto_ruta3_new = foto_ruta3_new;
	}

	public String getFoto_ruta4_new() {
		return foto_ruta4_new;
	}

	public void setFoto_ruta4_new(String foto_ruta4_new) {
		this.foto_ruta4_new = foto_ruta4_new;
	}

	public String getColores_producto_new() {
		return colores_producto_new;
	}

	public void setColores_producto_new(String colores_producto_new) {
		this.colores_producto_new = colores_producto_new;
	}

	public String getQr_producto_new() {
		return qr_producto_new;
	}

	public void setQr_producto_new(String qr_producto_new) {
		this.qr_producto_new = qr_producto_new;
	}

	public Double getPvv_producto_new() {
		return pvv_producto_new;
	}

	public void setPvv_producto_new(Double pvv_producto_new) {
		this.pvv_producto_new = pvv_producto_new;
	}

	public Double getPvf_producto_new() {
		return pvf_producto_new;
	}

	public void setPvf_producto_new(Double pvf_producto_new) {
		this.pvf_producto_new = pvf_producto_new;
	}

	public int getFkcodigo_linea_new() {
		return fkcodigo_linea_new;
	}

	public void setFkcodigo_linea_new(int fkcodigo_linea_new) {
		this.fkcodigo_linea_new = fkcodigo_linea_new;
	}

	public int getFkcodigo_tipoproducto_new() {
		return fkcodigo_tipoproducto_new;
	}

	public void setFkcodigo_tipoproducto_new(int fkcodigo_tipoproducto_new) {
		this.fkcodigo_tipoproducto_new = fkcodigo_tipoproducto_new;
	}

	public int getFkcodigo_estadoproducto_new() {
		return fkcodigo_estadoproducto_new;
	}

	public void setFkcodigo_estadoproducto_new(int fkcodigo_estadoproducto_new) {
		this.fkcodigo_estadoproducto_new = fkcodigo_estadoproducto_new;
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
