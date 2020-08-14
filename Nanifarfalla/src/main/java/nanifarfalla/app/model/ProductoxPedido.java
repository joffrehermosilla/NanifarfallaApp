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
@Table(name = "producto_por_pedido")
public class ProductoxPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_producto_por_pedido;
	@JoinColumn(name = "fkcodigo_pedido_web", referencedColumnName = "codigo_pedido_web")
	@ManyToOne
	ClienteTienePedido mClientetienepedido;

	@JoinColumn(name = "fkcodigo_producto", referencedColumnName = "codigo_producto")
	@ManyToOne
	Producto mProducto;

	// int fkcodigo_pedido_web;
//	int fkcodigo_producto;
	Double descuento_promocion;
	Double valor_neto;
	Double valor_con_igv;
	int cantidad_producto;
	String claveApi;
	Date version;

	public ProductoxPedido() {

	}

	public int getCodigo_producto_por_pedido() {
		return codigo_producto_por_pedido;
	}

	public void setCodigo_producto_por_pedido(int codigo_producto_por_pedido) {
		this.codigo_producto_por_pedido = codigo_producto_por_pedido;
	}

	public ClienteTienePedido getmClientetienepedido() {
		return mClientetienepedido;
	}

	public void setmClientetienepedido(ClienteTienePedido mClientetienepedido) {
		this.mClientetienepedido = mClientetienepedido;
	}

	public Producto getmProducto() {
		return mProducto;
	}

	public void setmProducto(Producto mProducto) {
		this.mProducto = mProducto;
	}

	public Double getDescuento_promocion() {
		return descuento_promocion;
	}

	public void setDescuento_promocion(Double descuento_promocion) {
		this.descuento_promocion = descuento_promocion;
	}

	public Double getValor_neto() {
		return valor_neto;
	}

	public void setValor_neto(Double valor_neto) {
		this.valor_neto = valor_neto;
	}

	public Double getValor_con_igv() {
		return valor_con_igv;
	}

	public void setValor_con_igv(Double valor_con_igv) {
		this.valor_con_igv = valor_con_igv;
	}

	public int getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(int cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
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
