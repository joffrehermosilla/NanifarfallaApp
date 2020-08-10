package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "audi_cliente_tiene_pedido")
public class AuditoriaClienteTienePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_cliente_tiene_pedido;
	String usuario;
	Date fecha_cambio;
	int fkcodigo_usuario_old;
	int fkcodigo_cliente_old;
	int fkcodigo_vendedor_old;
	int fkcodigo_igv_venta_old;
	int fkcodigo_promocion_venta_old;
	int fkcodigo_estado_cliente_tiene_pedido_old;
	int fkcodigo_factura_cliente_tiene_pedido_old;
	Double descuento_web_pedido_old;
	Double precio_uni_desc_igv_old;
	Double precio_uni_desc_sin_igv_old;
	Date fecha_pedido_old;
	Date fecha_entrega_old;
	int cantidad_producto_old;
	Double monto_por_descuentos_old;
	String claveApi_old;
	Date version_old;
	int fkcodigo_usuario_new;
	int fkcodigo_cliente_new;
	int fkcodigo_vendedor_new;
	int fkcodigo_igv_venta_new;
	int fkcodigo_promocion_venta_new;
	int fkcodigo_estado_cliente_tiene_pedido_new;
	int fkcodigo_factura_cliente_tiene_pedido_new;
	Double descuento_web_pedido_new;
	Double precio_uni_desc_igv_new;
	Double precio_uni_desc_sin_igv_new;
	Date fecha_pedido_new;
	Date fecha_entrega_new;
	int cantidad_producto_new;
	Double monto_por_descuentos_new;
	String claveApi_new;
	Date version_new;
	
	
	
	public int getCodigo_audi_cliente_tiene_pedido() {
		return codigo_audi_cliente_tiene_pedido;
	}



	public void setCodigo_audi_cliente_tiene_pedido(int codigo_audi_cliente_tiene_pedido) {
		this.codigo_audi_cliente_tiene_pedido = codigo_audi_cliente_tiene_pedido;
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



	public int getFkcodigo_usuario_old() {
		return fkcodigo_usuario_old;
	}



	public void setFkcodigo_usuario_old(int fkcodigo_usuario_old) {
		this.fkcodigo_usuario_old = fkcodigo_usuario_old;
	}



	public int getFkcodigo_cliente_old() {
		return fkcodigo_cliente_old;
	}



	public void setFkcodigo_cliente_old(int fkcodigo_cliente_old) {
		this.fkcodigo_cliente_old = fkcodigo_cliente_old;
	}



	public int getFkcodigo_vendedor_old() {
		return fkcodigo_vendedor_old;
	}



	public void setFkcodigo_vendedor_old(int fkcodigo_vendedor_old) {
		this.fkcodigo_vendedor_old = fkcodigo_vendedor_old;
	}



	public int getFkcodigo_igv_venta_old() {
		return fkcodigo_igv_venta_old;
	}



	public void setFkcodigo_igv_venta_old(int fkcodigo_igv_venta_old) {
		this.fkcodigo_igv_venta_old = fkcodigo_igv_venta_old;
	}



	public int getFkcodigo_promocion_venta_old() {
		return fkcodigo_promocion_venta_old;
	}



	public void setFkcodigo_promocion_venta_old(int fkcodigo_promocion_venta_old) {
		this.fkcodigo_promocion_venta_old = fkcodigo_promocion_venta_old;
	}



	public int getFkcodigo_estado_cliente_tiene_pedido_old() {
		return fkcodigo_estado_cliente_tiene_pedido_old;
	}



	public void setFkcodigo_estado_cliente_tiene_pedido_old(int fkcodigo_estado_cliente_tiene_pedido_old) {
		this.fkcodigo_estado_cliente_tiene_pedido_old = fkcodigo_estado_cliente_tiene_pedido_old;
	}



	public int getFkcodigo_factura_cliente_tiene_pedido_old() {
		return fkcodigo_factura_cliente_tiene_pedido_old;
	}



	public void setFkcodigo_factura_cliente_tiene_pedido_old(int fkcodigo_factura_cliente_tiene_pedido_old) {
		this.fkcodigo_factura_cliente_tiene_pedido_old = fkcodigo_factura_cliente_tiene_pedido_old;
	}



	public Double getDescuento_web_pedido_old() {
		return descuento_web_pedido_old;
	}



	public void setDescuento_web_pedido_old(Double descuento_web_pedido_old) {
		this.descuento_web_pedido_old = descuento_web_pedido_old;
	}



	public Double getPrecio_uni_desc_igv_old() {
		return precio_uni_desc_igv_old;
	}



	public void setPrecio_uni_desc_igv_old(Double precio_uni_desc_igv_old) {
		this.precio_uni_desc_igv_old = precio_uni_desc_igv_old;
	}



	public Double getPrecio_uni_desc_sin_igv_old() {
		return precio_uni_desc_sin_igv_old;
	}



	public void setPrecio_uni_desc_sin_igv_old(Double precio_uni_desc_sin_igv_old) {
		this.precio_uni_desc_sin_igv_old = precio_uni_desc_sin_igv_old;
	}



	public Date getFecha_pedido_old() {
		return fecha_pedido_old;
	}



	public void setFecha_pedido_old(Date fecha_pedido_old) {
		this.fecha_pedido_old = fecha_pedido_old;
	}



	public Date getFecha_entrega_old() {
		return fecha_entrega_old;
	}



	public void setFecha_entrega_old(Date fecha_entrega_old) {
		this.fecha_entrega_old = fecha_entrega_old;
	}



	public int getCantidad_producto_old() {
		return cantidad_producto_old;
	}



	public void setCantidad_producto_old(int cantidad_producto_old) {
		this.cantidad_producto_old = cantidad_producto_old;
	}



	public Double getMonto_por_descuentos_old() {
		return monto_por_descuentos_old;
	}



	public void setMonto_por_descuentos_old(Double monto_por_descuentos_old) {
		this.monto_por_descuentos_old = monto_por_descuentos_old;
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



	public int getFkcodigo_usuario_new() {
		return fkcodigo_usuario_new;
	}



	public void setFkcodigo_usuario_new(int fkcodigo_usuario_new) {
		this.fkcodigo_usuario_new = fkcodigo_usuario_new;
	}



	public int getFkcodigo_cliente_new() {
		return fkcodigo_cliente_new;
	}



	public void setFkcodigo_cliente_new(int fkcodigo_cliente_new) {
		this.fkcodigo_cliente_new = fkcodigo_cliente_new;
	}



	public int getFkcodigo_vendedor_new() {
		return fkcodigo_vendedor_new;
	}



	public void setFkcodigo_vendedor_new(int fkcodigo_vendedor_new) {
		this.fkcodigo_vendedor_new = fkcodigo_vendedor_new;
	}



	public int getFkcodigo_igv_venta_new() {
		return fkcodigo_igv_venta_new;
	}



	public void setFkcodigo_igv_venta_new(int fkcodigo_igv_venta_new) {
		this.fkcodigo_igv_venta_new = fkcodigo_igv_venta_new;
	}



	public int getFkcodigo_promocion_venta_new() {
		return fkcodigo_promocion_venta_new;
	}



	public void setFkcodigo_promocion_venta_new(int fkcodigo_promocion_venta_new) {
		this.fkcodigo_promocion_venta_new = fkcodigo_promocion_venta_new;
	}



	public int getFkcodigo_estado_cliente_tiene_pedido_new() {
		return fkcodigo_estado_cliente_tiene_pedido_new;
	}



	public void setFkcodigo_estado_cliente_tiene_pedido_new(int fkcodigo_estado_cliente_tiene_pedido_new) {
		this.fkcodigo_estado_cliente_tiene_pedido_new = fkcodigo_estado_cliente_tiene_pedido_new;
	}



	public int getFkcodigo_factura_cliente_tiene_pedido_new() {
		return fkcodigo_factura_cliente_tiene_pedido_new;
	}



	public void setFkcodigo_factura_cliente_tiene_pedido_new(int fkcodigo_factura_cliente_tiene_pedido_new) {
		this.fkcodigo_factura_cliente_tiene_pedido_new = fkcodigo_factura_cliente_tiene_pedido_new;
	}



	public Double getDescuento_web_pedido_new() {
		return descuento_web_pedido_new;
	}



	public void setDescuento_web_pedido_new(Double descuento_web_pedido_new) {
		this.descuento_web_pedido_new = descuento_web_pedido_new;
	}



	public Double getPrecio_uni_desc_igv_new() {
		return precio_uni_desc_igv_new;
	}



	public void setPrecio_uni_desc_igv_new(Double precio_uni_desc_igv_new) {
		this.precio_uni_desc_igv_new = precio_uni_desc_igv_new;
	}



	public Double getPrecio_uni_desc_sin_igv_new() {
		return precio_uni_desc_sin_igv_new;
	}



	public void setPrecio_uni_desc_sin_igv_new(Double precio_uni_desc_sin_igv_new) {
		this.precio_uni_desc_sin_igv_new = precio_uni_desc_sin_igv_new;
	}



	public Date getFecha_pedido_new() {
		return fecha_pedido_new;
	}



	public void setFecha_pedido_new(Date fecha_pedido_new) {
		this.fecha_pedido_new = fecha_pedido_new;
	}



	public Date getFecha_entrega_new() {
		return fecha_entrega_new;
	}



	public void setFecha_entrega_new(Date fecha_entrega_new) {
		this.fecha_entrega_new = fecha_entrega_new;
	}



	public int getCantidad_producto_new() {
		return cantidad_producto_new;
	}



	public void setCantidad_producto_new(int cantidad_producto_new) {
		this.cantidad_producto_new = cantidad_producto_new;
	}



	public Double getMonto_por_descuentos_new() {
		return monto_por_descuentos_new;
	}



	public void setMonto_por_descuentos_new(Double monto_por_descuentos_new) {
		this.monto_por_descuentos_new = monto_por_descuentos_new;
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



	public AuditoriaClienteTienePedido() {
	
	}
	

}
