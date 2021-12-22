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

import nanifarfalla.app.model.PresentacionInsumo;
import nanifarfalla.app.service.IPresentacionInsumoService;

@Controller
@RequestMapping("/presentacioninsumo")
public class PresentacionInsumoController {

	@Autowired
	IPresentacionInsumoService presentacioninsumoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<PresentacionInsumo> presentacioninsumo = presentacioninsumoService.buscarTodas();
		model.addAttribute("presentacioninsumoy", presentacioninsumo);
		return "presentacioninsumo/listPresentacionInsumo";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  PresentacionInsumo presentacioninsumos,Model model) {
		List<PresentacionInsumo> presentacioninsumo = presentacioninsumoService.buscarTodas();
		model.addAttribute("presentacioninsumoz", presentacioninsumo);
		return "presentacioninsumo/formPresentacionInsumo";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute PresentacionInsumo presentacioninsumo, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto PresentacionInsumo: " + presentacioninsumo);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "presentacioninsumo/formPresentacionInsumo";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto PresentacionInsumo: " + presentacioninsumo);
		System.out.println("Elementos en la lista antes de la insersion: " + presentacioninsumoService.buscarTodas().size());
		
		presentacioninsumoService.inserta(presentacioninsumo);
		
		System.out.println("Elementos en la lista despues de la insersion: " + presentacioninsumoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El PresentacionInsumo fue guardado");
		return "redirect:/presentacioninsumo/listPresentacionInsumo";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<PresentacionInsumo> lista = presentacioninsumoService.buscarTodas(page);
		model.addAttribute("presentacioninsumox", lista);
		return "presentacioninsumo/listPresentacionInsumo";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}	
}
