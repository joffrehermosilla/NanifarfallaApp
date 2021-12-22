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

import nanifarfalla.app.model.LoteInsumo;
import nanifarfalla.app.service.ILoteInsumoService;


@Controller
@RequestMapping("/loteinsumo")
public class LoteInsumoController {
	
	@Autowired
	ILoteInsumoService loteInsumoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<LoteInsumo> loteinsumo = loteInsumoService.buscarTodas();
		model.addAttribute("loteinsumoy", loteinsumo);
		return "loteinsumo/listLoteInsumo";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  LoteInsumo loteinsumos,Model model) {
		List<LoteInsumo> loteinsumo = loteInsumoService.buscarTodas();
		model.addAttribute("loteinsumoz", loteinsumo);
		return "loteinsumo/formLoteInsumo";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute LoteInsumo loteinsumo, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto LoteInsumo: " + loteinsumo);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "loteinsumo/formLoteInsumo";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto LoteInsumo: " + loteinsumo);
		System.out.println("Elementos en la lista antes de la insersion: " + loteInsumoService.buscarTodas().size());
		
		loteInsumoService.inserta(loteinsumo);
		
		System.out.println("Elementos en la lista despues de la insersion: " + loteInsumoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El LoteInsumo fue guardado");
		return "redirect:/loteinsumo/listLoteInsumo";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<LoteInsumo> lista = loteInsumoService.buscarTodas(page);
		model.addAttribute("loteinsumox", lista);
		return "loteinsumo/listLoteInsumo";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
