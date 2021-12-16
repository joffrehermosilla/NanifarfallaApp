package nanifarfalla.app.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.EstadoClienteTienePedido;
import nanifarfalla.app.service.IEstadoClienteTienePedidoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estadoclientetienepedido")
public class EstadoClienteTienePedidoController {

	
	@Autowired 
	IEstadoClienteTienePedidoService estadoclientetienepedidoService;
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<EstadoClienteTienePedido> estadoclientetienepedido = estadoclientetienepedidoService.buscarTodas();
		model.addAttribute("estadoclientetienepedidoy", estadoclientetienepedido);

		return "estadoclientetienepedido/listEstadoClienteTienePedido";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  EstadoClienteTienePedido estadoclientetienepedido,Model model) {
		List<EstadoClienteTienePedido> estadoclientetienepedidos = estadoclientetienepedidoService.buscarTodas();
		model.addAttribute("estadoclientetienepedidoz", estadoclientetienepedidos);
		return "estadoclientetienepedido/formEstadoClienteTienePedido";

	}
	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute EstadoClienteTienePedido estadoclientetienepedidos, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto estadoclientetienepedidos: " + estadoclientetienepedidos);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadoclientetienepedido/formEstadoClienteTienePedido";
		}

	

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto EstadoClientetienepedido: " + estadoclientetienepedidos);

		System.out.println("Elementos en la lista antes de la insersion: " + estadoclientetienepedidoService.buscarTodas().size());
		estadoclientetienepedidoService.inserta(estadoclientetienepedidos);
		System.out.println("Elementos en la lista despues de la insersion: " + estadoclientetienepedidoService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El EstadoClienteTienePedido fue guardado");

		return "redirect:/estadoclientetienepedido/listEstadoClienteTienePedido";
	}
	
	
	
	
	
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoClienteTienePedido> lista = estadoclientetienepedidoService.buscarTodas(page);
		model.addAttribute("estadoclientetienepedidox", lista);
		return "estadoclientetienepedido/listEstadoClienteTienePedido";
	}

	

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
	
}
