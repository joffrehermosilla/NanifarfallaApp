package nanifarfalla.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.service.IClienteTienePedidoService;

@Controller
@RequestMapping(path="/clienteTienePedido")
//@RestController
//@RequestMapping("/clienteTienePedido")
public class ClienteTienePedidoController {

	@Autowired
	IClienteTienePedidoService clientePedidoService;

	@GetMapping(value = "/buscarPedido")
	public String buscarPedido(Model model) {
		List<ClienteTienePedido> resultado = clientePedidoService.findPedido(1);
		model.addAttribute("listPedidos", resultado);
		return "clienteTienePedido/admin";
	}

}
