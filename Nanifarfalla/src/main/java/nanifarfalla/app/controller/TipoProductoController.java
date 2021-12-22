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

import nanifarfalla.app.model.TipoProducto;
import nanifarfalla.app.service.ITipoProductoService;

@Controller
@RequestMapping("/tipoproducto")
public class TipoProductoController {
	
	@Autowired
	ITipoProductoService tipoProductoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<TipoProducto> tipoproducto = tipoProductoService.buscarTodas();
		model.addAttribute("tipoproductoy", tipoproducto);
		return "tipoproducto/listTipoProducto";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  TipoProducto tipoproductos,Model model) {
		List<TipoProducto> tipoproducto = tipoProductoService.buscarTodas();
		model.addAttribute("tipoproductoz", tipoproducto);
		return "tipoproducto/formTipoProducto";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute TipoProducto tipoproducto, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto TipoProducto: " + tipoproducto);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipoproducto/formTipoProducto";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto TipoProducto: " + tipoproducto);
		System.out.println("Elementos en la lista antes de la insersion: " + tipoProductoService.buscarTodas().size());
		
		tipoProductoService.inserta(tipoproducto);
		
		System.out.println("Elementos en la lista despues de la insersion: " + tipoProductoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El TipoProducto fue guardado");
		return "redirect:/tipoproducto/listTipoProducto";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<TipoProducto> lista = tipoProductoService.buscarTodas(page);
		model.addAttribute("tipoproductox", lista);
		return "tipoproducto/listTipoProducto";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
