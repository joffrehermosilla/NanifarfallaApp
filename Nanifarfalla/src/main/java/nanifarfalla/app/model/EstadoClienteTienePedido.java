package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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


	@OneToMany(mappedBy = "mEstadoClienteTienePedido", fetch = FetchType.EAGER)
	private Collection<ClienteTienePedido> clientetienepedidos = new ArrayList<>();
	
	public Collection<ClienteTienePedido> getClientetienepedidos() {
		return clientetienepedidos;
	}

	public void setClientetienepedidos(Collection<ClienteTienePedido> clientetienepedidos) {
		this.clientetienepedidos = clientetienepedidos;
	}

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
