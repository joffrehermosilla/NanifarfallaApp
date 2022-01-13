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

import nanifarfalla.app.model.EstadoUsuario;
import nanifarfalla.app.service.IEstadoUsuarioService;

@Controller
@RequestMapping("/estadousuario")
public class EstadoUsuarioController {

	@Autowired
	IEstadoUsuarioService estadousuarioservice;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaEstadoUsuario") EstadoUsuario estadousuario,Model model, BindingResult result) {

		List<EstadoUsuario> estadousuarioy = estadousuarioservice.buscarTodas();
		model.addAttribute("estadousuarioy", estadousuarioy);

		return "estadousuario/listEstadoUsuario";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaEstadoUsuario") EstadoUsuario estadousuario,Model model, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadousuario/formEstadoUsuario";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		List<EstadoUsuario> estadousuarioz = estadousuarioservice.buscarTodas();
		model.addAttribute("estadousuarioz", estadousuarioz);
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

		return "redirect:/estadousuario/listEstadoUsuario";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<EstadoUsuario> lista = estadousuarioservice.buscarTodas(page);
		model.addAttribute("estadousuariox", lista);
		return "estadousuario/listEstadoUsuario";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
