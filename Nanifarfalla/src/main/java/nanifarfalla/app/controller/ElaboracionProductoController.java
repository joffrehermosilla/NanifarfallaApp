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

import nanifarfalla.app.model.ElaboracionProducto;
import nanifarfalla.app.service.IElaboracionProductoService;


@Controller
@RequestMapping("/elaboracionproducto")
public class ElaboracionProductoController {

	@Autowired
	IElaboracionProductoService elaboracionProductoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<ElaboracionProducto> elaboracionproducto = elaboracionProductoService.buscarTodas();
		model.addAttribute("elaboracionproductoy", elaboracionproducto);
		return "elaboracionproducto/listElaboracionProducto";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  ElaboracionProducto elaboracionproductos,Model model) {
		List<ElaboracionProducto> elaboracionproducto = elaboracionProductoService.buscarTodas();
		model.addAttribute("elaboracionproductoz", elaboracionproducto);
		return "elaboracionproducto/formElaboracionProducto";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute ElaboracionProducto elaboracionproducto, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto ElaboracionProducto: " + elaboracionproducto);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "elaboracionproducto/formElaboracionProducto";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto ElaboracionProducto: " + elaboracionproducto);
		System.out.println("Elementos en la lista antes de la insersion: " + elaboracionProductoService.buscarTodas().size());
		
		elaboracionProductoService.inserta(elaboracionproducto);
		
		System.out.println("Elementos en la lista despues de la insersion: " + elaboracionProductoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El ElaboracionProducto fue guardado");
		return "redirect:/elaboracionproducto/listElaboracionProducto";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<ElaboracionProducto> lista = elaboracionProductoService.buscarTodas(page);
		model.addAttribute("elaboracionproductox", lista);
		return "elaboracionproducto/listElaboracionProducto";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
