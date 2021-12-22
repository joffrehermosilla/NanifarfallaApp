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

import nanifarfalla.app.model.Colores;
import nanifarfalla.app.service.IColoresService;

@RestController
@RequestMapping("/colores")
public class ColoresController {

	@Autowired
	IColoresService coloresService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Colores> colores = coloresService.buscarTodas();
		model.addAttribute("coloresy", colores);
		return "colores/listColores";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  Colores coloress,Model model) {
		List<Colores> colores = coloresService.buscarTodas();
		model.addAttribute("coloresz", colores);
		return "colores/formColores";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Colores colores, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto Colores: " + colores);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "colores/formColores";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto Colores: " + colores);
		System.out.println("Elementos en la lista antes de la insersion: " + coloresService.buscarTodas().size());
		
		coloresService.inserta(colores);
		
		System.out.println("Elementos en la lista despues de la insersion: " + coloresService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El Colores fue guardado");
		return "redirect:/colores/listColores";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Colores> lista = coloresService.buscarTodas(page);
		model.addAttribute("coloresx", lista);
		return "colores/listColores";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
