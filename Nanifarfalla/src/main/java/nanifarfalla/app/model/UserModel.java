package nanifarfalla.app.model;

import java.io.Serializable;
import java.util.Collection;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String fullName;
	private Collection<Role> role;

	private ProductoxPedido cartx;
	private ClienteTienePedido clienteTienePedido;
	private Cart cart;

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public ProductoxPedido getCartx() {
		return cartx;
	}

	public void setCartx(ProductoxPedido cart) {
		this.cartx = cart;
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
