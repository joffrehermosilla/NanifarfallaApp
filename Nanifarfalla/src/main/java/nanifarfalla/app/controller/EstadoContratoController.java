package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.EstadoContrato;
import nanifarfalla.app.service.IEstadoContratoService;

@Controller
@RequestMapping("/estadocontrato")
public class EstadoContratoController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EstadoContratoController.class);
	@Autowired
	IEstadoContratoService estadocontratoService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaEstadoContrato") EstadoContrato estadocontrato, Model model,
			BindingResult result) {
		List<EstadoContrato> estadocontratoy = estadocontratoService.buscarTodas();
		model.addAttribute("estadocontratoy", estadocontratoy);
		ModelAndView mv = new ModelAndView("plainpage");
		mv.addObject("estadocontrato", "Estado Contrato");
		mv.addObject("userClickEstadoContrato", true);
		
		return "estadocontrato/listEstadoContrato";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaEstadoContrato") EstadoContrato estadocontrato, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocontrato/formEstadoContrato";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		List<EstadoContrato> estadocontratoz = estadocontratoService.buscarTodas();
		model.addAttribute("estadocontratoz", estadocontratoz);
		LOGGER.info("formEstadoContrato para crear nuevo Estado Contrato");

		return "estadocontrato/formEstadoContrato";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaEstadoContrato") EstadoContrato estadocontrato,
			BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto EstadoContrato: " + estadocontrato);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocontrato/formEstadoContrato";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto EstadoContrato: " + estadocontrato);
		System.out
				.println("Elementos en la lista antes de la insersion: " + estadocontratoService.buscarTodas().size());

		estadocontratoService.inserta(estadocontrato);

		System.out.println(
				"Elementos en la lista despues de la insersion: " + estadocontratoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El EstadoContrato fue guardado");
		return "redirect:/estadocontrato/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idEstadoContrato, Model model) {
		Optional<EstadoContrato> estadocontrato = estadocontratoService.buscarporId(idEstadoContrato);
		model.addAttribute("InstanciaEstadoContrato", estadocontrato);
		LOGGER.warn("Estado Contrato fue actualizado");

		return "estadocontrato/formEstadoContrato";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idEstadoContrato,
			@ModelAttribute("InstanciaEstadoContrato") EstadoContrato estadocontrato, BindingResult result, Model model,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Estado Contrato: " + estadocontrato);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocontrato/formEstadoContrato";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Estado Contrato: " + estadocontrato);
		System.out.println(
				"Elementos en la lista antes de la eliminación: " + estadocontratoService.buscarTodas().size());

		estadocontratoService.eliminar(idEstadoContrato);

		System.out.println(
				"Elementos en la lista despues de la eliminación: " + estadocontratoService.buscarTodas().size());
		attributes.addFlashAttribute("mensajedelete", "El Estado Contrato fue eliminado");
		LOGGER.warn("Estado Contrato fue eliminado");

		return "redirect:/estadocontrato/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoContrato> lista = estadocontratoService.buscarTodas(page);
		model.addAttribute("estadocontratox", lista);
		LOGGER.warn("Estado Contrato paginate cargado correctamente");

		return "estadocontrato/listEstadoContrato";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
