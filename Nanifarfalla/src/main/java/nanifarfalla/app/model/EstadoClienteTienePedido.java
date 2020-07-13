package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_cliente_tiene_pedido")
public class EstadoClienteTienePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_estado_cliente_tiene_pedido;
	String nombre_estado_cliente_tiene_pedido;
	String claveApi;
	Date version;

	public EstadoClienteTienePedido() {

	}

	public int getCodigo_estado_cliente_tiene_pedido() {
		return codigo_estado_cliente_tiene_pedido;
	}

	public void setCodigo_estado_cliente_tiene_pedido(int codigo_estado_cliente_tiene_pedido) {
		this.codigo_estado_cliente_tiene_pedido = codigo_estado_cliente_tiene_pedido;
	}

	public String getNombre_estado_cliente_tiene_pedido() {
		return nombre_estado_cliente_tiene_pedido;
	}

	public void setNombre_estado_cliente_tiene_pedido(String nombre_estado_cliente_tiene_pedido) {
		this.nombre_estado_cliente_tiene_pedido = nombre_estado_cliente_tiene_pedido;
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
