package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import nanifarfalla.app.model.EstadoCatalogo;

import nanifarfalla.app.service.IEstadoCatalogoService;

//@RestController
@Controller
@RequestMapping("/estadocatalogo")
public class EstadoCatalogoController {

	@Autowired
	IEstadoCatalogoService estadoCatalagoService;
	
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<EstadoCatalogo> estadocatalogo = estadoCatalagoService.buscarTodas();
		model.addAttribute("estadocatalogoy", estadocatalogo);

		return "estadocatalogo/listEstadoCatalogo";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  EstadoCatalogo estadocatalogo,Model model) {
		List<EstadoCatalogo> estadocatalogos = estadoCatalagoService.buscarTodas();
		model.addAttribute("estadocatalogoz", estadocatalogos);
		return "estadocatalogo/formEstadoCatalogo";

	}
	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute EstadoCatalogo estadocatalogos, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto estadocatalogos: " + estadocatalogos);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocatalogo/formEstadoCatalogo";
		}

	

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto EstadoCatologo: " + estadocatalogos);

		System.out.println("Elementos en la lista antes de la insersion: " + estadoCatalagoService.buscarTodas().size());
		estadoCatalagoService.inserta(estadocatalogos);
		System.out.println("Elementos en la lista despues de la insersion: " + estadoCatalagoService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El EstadoCatalogo fue guardado");

		return "redirect:/estadocatalogo/listEstadoCatalogo";
	}
	
	
	
	
	
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoCatalogo> lista = estadoCatalagoService.buscarTodas(page);
		model.addAttribute("estadocatalogox", lista);
		return "estadocatalogo/listEstadoCatalogo";
	}

	

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
}
