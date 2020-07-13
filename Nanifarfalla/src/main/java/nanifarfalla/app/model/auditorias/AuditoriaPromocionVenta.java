package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_promocion_venta")
public class AuditoriaPromocionVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_promocion_venta;
	String usuario;
	Date fecha_cambio;
	int cantidad_sku_pedido_old;
	Double descuento_sku_pedido_old;
	Date fecha_inicio_promocion_old;
	Date fecha_expiracion_promocion_old;
	String descripcion_promocion_old;
	String claveApi_old;
	Date version_old;
	int cantidad_sku_pedido_new;
	Double descuento_sku_pedido_new;
	Date fecha_inicio_promocion_new;
	Date fecha_expiracion_promocion_new;
	String descripcion_promocion_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaPromocionVenta() {

	}

	public int getCodigo_audi_promocion_venta() {
		return codigo_audi_promocion_venta;
	}

	public void setCodigo_audi_promocion_venta(int codigo_audi_promocion_venta) {
		this.codigo_audi_promocion_venta = codigo_audi_promocion_venta;
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

	public int getCantidad_sku_pedido_old() {
		return cantidad_sku_pedido_old;
	}

	public void setCantidad_sku_pedido_old(int cantidad_sku_pedido_old) {
		this.cantidad_sku_pedido_old = cantidad_sku_pedido_old;
	}

	public Double getDescuento_sku_pedido_old() {
		return descuento_sku_pedido_old;
	}

	public void setDescuento_sku_pedido_old(Double descuento_sku_pedido_old) {
		this.descuento_sku_pedido_old = descuento_sku_pedido_old;
	}

	public Date getFecha_inicio_promocion_old() {
		return fecha_inicio_promocion_old;
	}

	public void setFecha_inicio_promocion_old(Date fecha_inicio_promocion_old) {
		this.fecha_inicio_promocion_old = fecha_inicio_promocion_old;
	}

	public Date getFecha_expiracion_promocion_old() {
		return fecha_expiracion_promocion_old;
	}

	public void setFecha_expiracion_promocion_old(Date fecha_expiracion_promocion_old) {
		this.fecha_expiracion_promocion_old = fecha_expiracion_promocion_old;
	}

	public String getDescripcion_promocion_old() {
		return descripcion_promocion_old;
	}

	public void setDescripcion_promocion_old(String descripcion_promocion_old) {
		this.descripcion_promocion_old = descripcion_promocion_old;
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

	public int getCantidad_sku_pedido_new() {
		return cantidad_sku_pedido_new;
	}

	public void setCantidad_sku_pedido_new(int cantidad_sku_pedido_new) {
		this.cantidad_sku_pedido_new = cantidad_sku_pedido_new;
	}

	public Double getDescuento_sku_pedido_new() {
		return descuento_sku_pedido_new;
	}

	public void setDescuento_sku_pedido_new(Double descuento_sku_pedido_new) {
		this.descuento_sku_pedido_new = descuento_sku_pedido_new;
	}

	public Date getFecha_inicio_promocion_new() {
		return fecha_inicio_promocion_new;
	}

	public void setFecha_inicio_promocion_new(Date fecha_inicio_promocion_new) {
		this.fecha_inicio_promocion_new = fecha_inicio_promocion_new;
	}

	public Date getFecha_expiracion_promocion_new() {
		return fecha_expiracion_promocion_new;
	}

	public void setFecha_expiracion_promocion_new(Date fecha_expiracion_promocion_new) {
		this.fecha_expiracion_promocion_new = fecha_expiracion_promocion_new;
	}

	public String getDescripcion_promocion_new() {
		return descripcion_promocion_new;
	}

	public void setDescripcion_promocion_new(String descripcion_promocion_new) {
		this.descripcion_promocion_new = descripcion_promocion_new;
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
