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

import nanifarfalla.app.model.EstadoInsumo;
import nanifarfalla.app.service.IEstadoInsumoService;

@Controller
@RequestMapping("/estadoinsumo")
public class EstadoInsumoController {

	@Autowired
	IEstadoInsumoService estadoInsumoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<EstadoInsumo> estadoinsumo = estadoInsumoService.buscarTodas();
		model.addAttribute("estadoinsumoy", estadoinsumo);
		return "estadoinsumo/listEstadoInsumo";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  EstadoInsumo estadoinsumos,Model model) {
		List<EstadoInsumo> estadoinsumo = estadoInsumoService.buscarTodas();
		model.addAttribute("estadoinsumoz", estadoinsumo);
		return "estadoinsumo/formEstadoInsumo";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute EstadoInsumo estadoinsumo, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto EstadoInsumo: " + estadoinsumo);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadoinsumo/formEstadoInsumo";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto EstadoInsumo: " + estadoinsumo);
		System.out.println("Elementos en la lista antes de la insersion: " + estadoInsumoService.buscarTodas().size());
		
		estadoInsumoService.inserta(estadoinsumo);
		
		System.out.println("Elementos en la lista despues de la insersion: " + estadoInsumoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El EstadoInsumo fue guardado");
		return "redirect:/estadoinsumo/listEstadoInsumo";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoInsumo> lista = estadoInsumoService.buscarTodas(page);
		model.addAttribute("estadoinsumox", lista);
		return "estadoinsumo/listEstadoInsumo";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
