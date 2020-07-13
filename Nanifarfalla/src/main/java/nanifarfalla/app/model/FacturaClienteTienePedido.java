package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "factura_c_tiene_pedido")
public class FacturaClienteTienePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_factura_cliente_tiene_pedido;
	String nombre_factura_cliente_tiene_pedido;
	String claveApi;
	Date version;

	public FacturaClienteTienePedido() {

	}

	public int getCodigo_factura_cliente_tiene_pedido() {
		return codigo_factura_cliente_tiene_pedido;
	}

	public void setCodigo_factura_cliente_tiene_pedido(int codigo_factura_cliente_tiene_pedido) {
		this.codigo_factura_cliente_tiene_pedido = codigo_factura_cliente_tiene_pedido;
	}

	public String getNombre_factura_cliente_tiene_pedido() {
		return nombre_factura_cliente_tiene_pedido;
	}

	public void setNombre_factura_cliente_tiene_pedido(String nombre_factura_cliente_tiene_pedido) {
		this.nombre_factura_cliente_tiene_pedido = nombre_factura_cliente_tiene_pedido;
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
