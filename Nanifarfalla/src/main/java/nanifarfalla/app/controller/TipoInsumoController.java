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

import nanifarfalla.app.model.TipoInsumo;
import nanifarfalla.app.service.ITipoInsumoService;

@Controller
@RequestMapping("/tipoinsumo")
public class TipoInsumoController {

	@Autowired
	ITipoInsumoService tipoInsumoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<TipoInsumo> tipoinsumo = tipoInsumoService.buscarTodas();
		model.addAttribute("tipoinsumoy", tipoinsumo);
		return "tipoinsumo/listTipoInsumo";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  TipoInsumo tipoinsumos,Model model) {
		List<TipoInsumo> tipoinsumo = tipoInsumoService.buscarTodas();
		model.addAttribute("tipoinsumoz", tipoinsumo);
		return "tipoinsumo/formTipoInsumo";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute TipoInsumo tipoinsumo, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto TipoInsumo: " + tipoinsumo);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipoinsumo/formTipoInsumo";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto TipoInsumo: " + tipoinsumo);
		System.out.println("Elementos en la lista antes de la insersion: " + tipoInsumoService.buscarTodas().size());
		
		tipoInsumoService.inserta(tipoinsumo);
		
		System.out.println("Elementos en la lista despues de la insersion: " + tipoInsumoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El TipoInsumo fue guardado");
		return "redirect:/tipoinsumo/listTipoInsumo";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<TipoInsumo> lista = tipoInsumoService.buscarTodas(page);
		model.addAttribute("tipoinsumox", lista);
		return "tipoinsumo/listTipoInsumo";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
