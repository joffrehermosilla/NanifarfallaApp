package nanifarfalla.app.controller.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nanifarfalla.app.model.Cliente;
import nanifarfalla.app.service.IClienteService;

@RestController
@RequestMapping("/apiCliente")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteservice;

	
	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteservice.findAll();
	}
}
