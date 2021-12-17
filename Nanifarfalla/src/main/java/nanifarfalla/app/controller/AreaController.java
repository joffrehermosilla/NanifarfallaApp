package nanifarfalla.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

import nanifarfalla.app.model.Area;

import nanifarfalla.app.service.IAreaService;



@RestController
@RequestMapping("/area")
public class AreaController {
	
	@Autowired
	IAreaService areaService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Area> area = areaService.buscarTodas();
		model.addAttribute("areay", area);

		return "area/listArea";
	}
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  Area area,Model model) {
		List<Area> areas = areaService.buscarTodas();
		model.addAttribute("areaz", areas);
		return "area/formArea";

	}
	
	
	
	
	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Area area, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto areas: " + area);
		// Pendiente: Guardar el objeto area en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "area/formArea";
		}

	

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto Area: " + area);

		System.out.println("Elementos en la lista antes de la insersion: " + areaService.buscarTodas().size());
		areaService.inserta(area);
		System.out.println("Elementos en la lista despues de la insersion: " + areaService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El Area fue guardado");

		return "redirect:/area/listArea";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Area> lista = areaService.buscarTodas(page);
		model.addAttribute("areax", lista);
		return "area/listArea";
	}

	

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}

	
	


