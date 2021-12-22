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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.EstadoProducto;
import nanifarfalla.app.service.IEstadoProductoService;

@Controller
@RequestMapping("/estadoproducto")
public class EstadoProductoController {

	@Autowired
	IEstadoProductoService estadoProductoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<EstadoProducto> estadoproducto = estadoProductoService.buscarTodas();
		model.addAttribute("estadoproductoy", estadoproducto);
		return "estadoproducto/listEstadoProducto";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  EstadoProducto estadoproductos,Model model) {
		List<EstadoProducto> estadoproducto = estadoProductoService.buscarTodas();
		model.addAttribute("estadoproductoz", estadoproducto);
		return "estadoproducto/formEstadoProducto";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute EstadoProducto estadoproducto, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto EstadoProducto: " + estadoproducto);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadoproducto/formEstadoProducto";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto EstadoProducto: " + estadoproducto);
		System.out.println("Elementos en la lista antes de la insersion: " + estadoProductoService.buscarTodas().size());
		
		estadoProductoService.inserta(estadoproducto);
		
		System.out.println("Elementos en la lista despues de la insersion: " + estadoProductoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El EstadoProducto fue guardado");
		return "redirect:/estadoproducto/listEstadoProducto";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoProducto> lista = estadoProductoService.buscarTodas(page);
		model.addAttribute("estadoproductox", lista);
		return "estadoproducto/listEstadoProducto";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
