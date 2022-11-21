package nanifarfalla.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.model.ProductoxPedido;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.service.IClienteTienePedidoService;
import nanifarfalla.app.service.IProductoxpedidoService;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class CartServiceJPA {

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

	public ClienteTienePedido getCart() {

		return (ClienteTienePedido) ((Usuario) session.getAttribute("Usuario")).getClientetienepedidos();
	}

	// return the entire cart lines

	public List<ProductoxPedido> getCartLines() {

		return productoxpedidoService.list(this.getCart().getCodigo_pedido_web());

	}

	private ProductoxPedido getCarrito() {
		return null;
	}

}
