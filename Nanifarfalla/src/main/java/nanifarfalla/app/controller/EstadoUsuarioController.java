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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.EstadoUsuario;
import nanifarfalla.app.service.IEstadoUsuarioService;
import nanifarfalla.app.service.UserService;

@Controller
@RequestMapping("/estadousuario")
public class EstadoUsuarioController {
	private final static Logger LOGGER = LoggerFactory.getLogger(EstadoUsuarioController.class);
	@Autowired
	IEstadoUsuarioService estadousuarioservice;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaEstadoUsuario") EstadoUsuario estadousuario, Model model,
			BindingResult result) {

		List<EstadoUsuario> estadousuarioy = estadousuarioservice.buscarTodas();
		model.addAttribute("estadousuarioy", estadousuarioy);
		LOGGER.info("ESTADO USUARIO FUE CARGADO");
		return "estadousuario/listEstadoUsuario";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaEstadoUsuario") EstadoUsuario estadousuario, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadousuario/formEstadoUsuario";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		List<EstadoUsuario> estadousuarioz = estadousuarioservice.buscarTodas();
		model.addAttribute("estadousuarioz", estadousuarioz);
		LOGGER.info("FORM ESTADOUSUARIO PARA CREAR UN NUEVO ESTADO USUARIO");
		return "estadousuario/formEstadoUsuario";

	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaEstadoUsuario") EstadoUsuario estadousuario, BindingResult result,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto estadousuarios: " + estadousuario);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadousuario/formEstadoUsuario";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto EstadoUsuario: " + estadousuario);

		System.out.println("Elementos en la lista antes de la insersion: " + estadousuarioservice.buscarTodas().size());
		estadousuarioservice.inserta(estadousuario);
		System.out
				.println("Elementos en la lista despues de la insersion: " + estadousuarioservice.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El EstadoUsuario fue guardado");
		LOGGER.info("ESTADO USUARIO FUE GUARDADO");
		return "redirect:/estadousuario/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idEstadoUsuario, Model model) {
		Optional<EstadoUsuario> estadoUsuario = estadousuarioservice.buscarporId(idEstadoUsuario);
		model.addAttribute("InstanciaEstadoUsuario", estadoUsuario);
		LOGGER.warn("ESTADO USUARIO FUE ACTUALIZADO");

		return "estadousuario/formEstadoUsuario";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idEstadoUsuario,
			@ModelAttribute("InstanciaEstadoUsuario") EstadoUsuario estadousuario, BindingResult result, Model model,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto estadousuarios: " + estadousuario);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadousuario/formEstadoUsuario";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto EstadoUsuario: " + estadousuario);

		System.out
				.println("Elementos en la lista antes de la eliminación: " + estadousuarioservice.buscarTodas().size());
		estadousuarioservice.eliminar(idEstadoUsuario);
		System.out.println(
				"Elementos en la lista despues de la eliminación: " + estadousuarioservice.buscarTodas().size());

		attributes.addFlashAttribute("mensajedelete", "El EstadoUsuario fue eliminado");
		LOGGER.warn("ESTADO USUARIO FUE ELIMINADO");
		return "redirect:/estadousuario/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoUsuario> lista = estadousuarioservice.buscarTodas(page);
		model.addAttribute("estadousuariox", lista);
		LOGGER.warn("ESTADO USUARIO PAGINATE CARGADO SATISFACTORIAMENTE");
		return "estadousuario/listEstadoUsuario";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
