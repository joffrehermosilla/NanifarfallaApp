package nanifarfalla.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Cart;
import nanifarfalla.app.model.CartLine;
import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.model.ProductoxPedido;
import nanifarfalla.app.model.UserModel;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.service.CartLineDAO;
import nanifarfalla.app.service.IClienteTienePedidoService;
import nanifarfalla.app.service.IProductoxpedidoService;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class CartServiceJPA {


	private CartLineDAO cartLineDAO;

	@Autowired
	private IClienteTienePedidoService clienteTienePedidoService;

	@Autowired
	private IProductoxpedidoService productoxpedidoService;

	@Autowired
	private HttpSession session;

	// retorna el carrito del usuario que ha estado logeado

	private Collection<ClienteTienePedido> getCarts() {

		return ((Usuario) session.getAttribute("Usuario")).getClientetienepedidos();

	}

	public ClienteTienePedido getCartx() {

		return (ClienteTienePedido) ((Usuario) session.getAttribute("Usuario")).getClientetienepedidos();
	}

	// return the entire cart lines

	public List<ProductoxPedido> getCartLinesx() {

		return productoxpedidoService.list(this.getCartx().getCodigo_pedido_web());

	}

	private ProductoxPedido getCarrito() {
		return null;
	}

	private Cart getCart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	public List<CartLine> getCartLines() {

		return cartLineDAO.list(getCart().getId());

	}
}
