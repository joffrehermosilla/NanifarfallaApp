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

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.EstadoCatalogo;

import nanifarfalla.app.service.IEstadoCatalogoService;

//@RestController
@Controller
@RequestMapping("/estadocatalogo")
public class EstadoCatalogoController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EstadoCatalogoController.class);
	@Autowired
	IEstadoCatalogoService estadoCatalagoService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaEstadoCatalogo") EstadoCatalogo estadocatalogos, Model model,
			BindingResult result) {
		List<EstadoCatalogo> estadocatalogo = estadoCatalagoService.buscarTodas();
		model.addAttribute("estadocatalogoy", estadocatalogo);
		LOGGER.info("ESTADO CATALOGO CONTROLLER FUE CARGADO");
		return "estadocatalogo/listEstadoCatalogo";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaEstadoCatalogo") EstadoCatalogo estadocatalogos, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocatalogo/formEstadoCatalogo";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		List<EstadoCatalogo> estadocatalogo = estadoCatalagoService.buscarTodas();
		model.addAttribute("estadocatalogoz", estadocatalogo);
		LOGGER.info("FORM ESTADO CATALOGO PARA CREAR UN NUEVO ESTADO DEL CATALOGO");
		return "estadocatalogo/formEstadoCatalogo";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaEstadoCatalogo") EstadoCatalogo estadocatalogos,
			BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Estado Catalogo: " + estadocatalogos);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocatalogo/formEstadoCatalogo";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out
				.println("Elementos en la lista antes de la insersion: " + estadoCatalagoService.buscarTodas().size());
		estadoCatalagoService.inserta(estadocatalogos);
		System.out.println(
				"Elementos en la lista despues de la insersion: " + estadoCatalagoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El Estado Catalogo fue guardado");
		return "redirect:/estadocatalogo/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idEestadocatalogo, Model model) {
		Optional<EstadoCatalogo> estadocatalogo = estadoCatalagoService.buscarporId(idEestadocatalogo);
		model.addAttribute("InstanciaEstadoCatalogo", estadocatalogo);
		LOGGER.warn("Estado del CATALOGO FUE ACTUALIZADO");

		return "estadocatalogo/formEstadoCatalogo";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idEestadocatalogo,
			@ModelAttribute("InstanciaEstadoCatalogo") EstadoCatalogo estadocatalogo, BindingResult result, Model model,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto estadocatalogo: " + estadocatalogo);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadocatalogo/formEstadoCatalogo";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Estado Catalogo: " + estadocatalogo);

		System.out.println(
				"Elementos en la lista antes de la eliminación: " + estadoCatalagoService.buscarTodas().size());
		estadoCatalagoService.eliminar(idEestadocatalogo);
		System.out.println(
				"Elementos en la lista despues de la eliminación: " + estadoCatalagoService.buscarTodas().size());

		attributes.addFlashAttribute("mensajedelete", "El Estado Catalogo fue eliminado");
		LOGGER.warn("ESTADO CATALOGO FUE ELIMINADO");
		return "redirect:/estadocatalogo/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoCatalogo> lista = estadoCatalagoService.buscarTodas(page);
		model.addAttribute("estadocatalogox", lista);
		return "estadocatalogo/listEstadoCatalogo";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
