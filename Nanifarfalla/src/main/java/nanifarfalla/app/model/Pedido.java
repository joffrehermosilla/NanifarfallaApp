package nanifarfalla.app.model;

import java.util.Date;

public class Pedido {

	private Integer codigo_pedido_web;
	private Date fecha_pedido;
	private Date fecha_entrega;
	private Integer cantidad_producto;

	private String documento;
	private String estado;
	private Double precio_uni;
	
	
	public Pedido(Integer codigo_pedido_web, Date fecha_pedido, Date fecha_entrega, Integer cantidad_producto,
			String documento, String estado, Double precio_uni) {
		this.codigo_pedido_web = codigo_pedido_web;
		this.fecha_pedido = fecha_pedido;
		this.fecha_entrega = fecha_entrega;
		this.cantidad_producto = cantidad_producto;
		this.documento = documento;
		this.estado = estado;
		this.precio_uni = precio_uni;
	}
	public Pedido() {
	}
	public Integer getCodigo_pedido_web() {
		return codigo_pedido_web;
	}
	public void setCodigo_pedido_web(Integer codigo_pedido_web) {
		this.codigo_pedido_web = codigo_pedido_web;
	}
	public Date getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(Date fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public Date getFecha_entrega() {
		return fecha_entrega;
	}
	public void setFecha_entrega(Date fecha_entrega) {
		this.fecha_entrega = fecha_entrega;
	}
	public Integer getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Double getPrecio_uni() {
		return precio_uni;
	}
	public void setPrecio_uni(Double precio_uni) {
		this.precio_uni = precio_uni;
	}
	
	
}
