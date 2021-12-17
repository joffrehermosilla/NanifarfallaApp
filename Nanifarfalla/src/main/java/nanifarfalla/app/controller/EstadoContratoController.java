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

import nanifarfalla.app.model.EstadoContrato;
import nanifarfalla.app.service.IEstadoContratoService;



@RestController
@RequestMapping("/estadocontrato")
public class EstadoContratoController {

	@Autowired
	IEstadoContratoService estadocontratoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<EstadoContrato> esstadocontrato = estadocontratoService.buscarTodas();
		model.addAttribute("esstadocontratoy", esstadocontrato);

		return "esstadocontrato/listEstadoContratos";
	}
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  EstadoContrato estadocontrato,Model model) {
		List<EstadoContrato> estadocontratos = estadocontratoService.buscarTodas();
		model.addAttribute("estadocontratoz", estadocontratos);
		return "estadocontrato/formEstadoContrato";

	}
	
	
	
	
	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute EstadoContrato estadocontratos, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto estadocontratos: " + estadocontratos);
		// Pendiente: Guardar el objeto EstadoContrato en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocontrato/formEstadoContrato";
		}

	

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto EstadoContrato: " + estadocontratos);

		System.out.println("Elementos en la lista antes de la insersion: " + estadocontratoService.buscarTodas().size());
		estadocontratoService.inserta(estadocontratos);
		System.out.println("Elementos en la lista despues de la insersion: " + estadocontratoService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El EstadoContrato fue guardado");

		return "redirect:/estadocontrato/listEstadoContrato";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoContrato> lista = estadocontratoService.buscarTodas(page);
		model.addAttribute("estadocontratox", lista);
		return "estadocontrato/listEstadoContrato";
	}

	

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
