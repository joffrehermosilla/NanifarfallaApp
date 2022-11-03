package nanifarfalla.app.model;

import java.io.Serializable;
import java.util.Collection;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String fullName;
	private Collection<Role> role;

	private ProductoxPedido cart;
	private ClienteTienePedido clienteTienePedido;

	public ProductoxPedido getCart() {
		return cart;
	}

	public void setCart(ProductoxPedido cart) {
		this.cart = cart;
	}

	public ClienteTienePedido getClienteTienePedido() {
		return clienteTienePedido;
	}

	public void setClienteTienePedido(ClienteTienePedido clienteTienePedido) {
		this.clienteTienePedido = clienteTienePedido;
	}

	public Collection<Role> getRole() {
		return role;
	}

	public void setRole(Collection<Role> collection) {
		this.role = collection;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
