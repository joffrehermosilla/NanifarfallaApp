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

import nanifarfalla.app.model.TipoAlerta;
import nanifarfalla.app.service.ITipoAlertaService;

@Controller
@RequestMapping("/tipoalerta")
public class TipoAlertaController {

	@Autowired
	ITipoAlertaService tipoAlertaService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<TipoAlerta> tipoalerta = tipoAlertaService.buscarTodas();
		model.addAttribute("tipoalertay", tipoalerta);
		return "tipoalerta/listTipoAlerta";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  TipoAlerta tipoalertas,Model model) {
		List<TipoAlerta> tipoalerta = tipoAlertaService.buscarTodas();
		model.addAttribute("tipoalertaz", tipoalerta);
		return "tipoalerta/formTipoAlerta";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute TipoAlerta tipoalerta, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto TipoAlerta: " + tipoalerta);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipoalerta/formTipoAlerta";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto TipoAlerta: " + tipoalerta);
		System.out.println("Elementos en la lista antes de la insersion: " + tipoAlertaService.buscarTodas().size());
		
		tipoAlertaService.guardar(tipoalerta);
		
		System.out.println("Elementos en la lista despues de la insersion: " + tipoAlertaService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El TipoAlerta fue guardado");
		return "redirect:/tipoalerta/listTipoAlerta";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<TipoAlerta> lista = tipoAlertaService.buscarTodas(page);
		model.addAttribute("tipoalertax", lista);
		return "tipoalerta/listTipoAlerta";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
