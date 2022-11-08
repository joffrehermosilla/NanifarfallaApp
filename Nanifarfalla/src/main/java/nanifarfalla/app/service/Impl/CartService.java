package nanifarfalla.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.service.IClienteTienePedidoService;
import nanifarfalla.app.service.IProductoxpedidoService;

import javax.servlet.http.HttpSession;

@Service("cartService")
public class CartService {

	@Autowired
	private IClienteTienePedidoService clienteTienePedidoService;

	@Autowired
	private IProductoxpedidoService productoxpedidoService;
	
	@Autowired
	private HttpSession session;
	

}
