package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.model.EstadoClienteTienePedido;
import nanifarfalla.app.model.Pais;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.service.IClienteTienePedidoService;
import nanifarfalla.app.service.UserService;
import nanifarfalla.app.service.Impl.CartServiceJPA;

@Controller
@RequestMapping("/clientetienepedido")
public class ClienteTienePedidoController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ClienteTienePedidoController.class);

	@Autowired
	IClienteTienePedidoService clienteTienePedidoService;

	@Autowired
	private CartServiceJPA cartService;

	@Autowired
	private UserService userService;

	@Autowired
	private IClienteTienePedidoService clienteTienePedido;

	private Usuario user = new Usuario();

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaClienteTienePedido") ClienteTienePedido clienteTienePedido,
			Model model, BindingResult result) {
		List<ClienteTienePedido> clienteTienePedidoy = clienteTienePedidoService.buscarTodas();
		model.addAttribute("clienteTienePedidoy", clienteTienePedidoy);
		LOGGER.info("InstanciaClienteTienePedido fue cargado");
		return "ecommerce/cart";
	}

	@RequestMapping("/show")
	public ModelAndView showCart() {

		ModelAndView mv = new ModelAndView("page");

		// mv.addObject("title", "Shopping Cart");
		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", null);
		//mv.addObject("cartLines", cartService.getCartLines());
		// mv.addObject("estadocart",
		// cartService.getCart().getmEstadoClienteTienePedido());
		// mv.addObject("cartx", cartService.getCart());
		return mv;

	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaClienteTienePedido") ClienteTienePedido clienteTienePedido,
			BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

		ClienteTienePedido clienteTienePedidofill = new ClienteTienePedido();

		EstadoClienteTienePedido estadoClienteTienePedido = new EstadoClienteTienePedido();
		estadoClienteTienePedido.setCodigo_estado_cliente_tiene_pedido(4);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		user = userService.findUserByEmail(authentication.getName());
		LOGGER.info("usuario en sesion: " + user.toString());

		LOGGER.info("existe pedido con estado cerrado ?: " + clienteTienePedidofill);
		clienteTienePedido.setmEstadoClienteTienePedido(estadoClienteTienePedido);
		clienteTienePedido.setmUsuario(user);

		System.out.println(
				"Recibiendo objeto PedidoWeb creacion carrito de compras CLIENTE TIENE PEDIDO: " + clienteTienePedido);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "page-index-1.jsp";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto clienteTienePedido: " + clienteTienePedido);
		System.out.println(
				"Elementos en la lista antes de la insersion: " + clienteTienePedidoService.buscarTodas().size());

		/*
		 * if (clienteTienePedidoService.findPedido(user.getCodigo_usuario()).isEmpty()
		 * || clienteTienePedidofill != null) {
		 * 
		 * clienteTienePedidoService.inserta(clienteTienePedido); LOGGER.
		 * info("se guardo exitosamente CARRITO DE COMPRAS CLIENTE TIENE PEDIDO: " +
		 * clienteTienePedido); attributes.addFlashAttribute("mensaje",
		 * "Se creo un carrito de compras para el cliente: " + user.getNombre_usuario()
		 * + " " + user.getApellido_usuario());
		 * 
		 * } else { attributes.addFlashAttribute("mensajecerrarcarrito",
		 * "Existe un pedido " +
		 * clienteTienePedidoService.findPedido(user.getCodigo_usuario()) +
		 * " con estado no cerrado. Para continuar con la compra");
		 * LOGGER.info("NO SE guardo el CARRITO DE COMPRAS CLIENTE TIENE PEDIDO: ");
		 * return "redirect:/show/all/products"; }
		 */
		System.out.println(
				"Elementos en la lista despues de la insersion: " + clienteTienePedidoService.buscarTodas().size());
		clienteTienePedidoService.insertar(clienteTienePedido);

		return "redirect:/cart/show";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
