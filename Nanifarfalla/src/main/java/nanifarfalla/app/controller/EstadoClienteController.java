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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.EstadoCliente;
import nanifarfalla.app.service.IEstadoClienteService;

@RestController
@RequestMapping("/estadocliente")
public class EstadoClienteController {

	@Autowired
	IEstadoClienteService estadoClienteService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<EstadoCliente> estadocliente = estadoClienteService.buscarTodas();
		model.addAttribute("estadoclientey", estadocliente);
		return "estadocliente/listEstadoCliente";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  EstadoCliente estadoclientes,Model model) {
		List<EstadoCliente> estadocliente = estadoClienteService.buscarTodas();
		model.addAttribute("estadoclientez", estadocliente);
		return "estadocliente/formEstadoCliente";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute EstadoCliente estadocliente, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto EstadoCliente: " + estadocliente);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocliente/formEstadoCliente";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto EstadoCliente: " + estadocliente);
		System.out.println("Elementos en la lista antes de la insersion: " + estadoClienteService.buscarTodas().size());
		
		estadoClienteService.inserta(estadocliente);
		
		System.out.println("Elementos en la lista despues de la insersion: " + estadoClienteService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El EstadoCliente fue guardado");
		return "redirect:/estadocliente/listEstadoCliente";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoCliente> lista = estadoClienteService.buscarTodas(page);
		model.addAttribute("estadoclientex", lista);
		return "estadocliente/listEstadoCliente";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
