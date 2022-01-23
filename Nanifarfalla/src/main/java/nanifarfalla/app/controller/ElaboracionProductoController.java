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

import nanifarfalla.app.model.ElaboracionProducto;

import nanifarfalla.app.service.IElaboracionProductoService;

@Controller
@RequestMapping("/elaboracionproducto")
public class ElaboracionProductoController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ElaboracionProductoController.class);
	@Autowired
	IElaboracionProductoService elaboracionProductoService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaElaboracionProducto") ElaboracionProducto elaboracionproductos,
			Model model, BindingResult result) {
		List<ElaboracionProducto> elaboracionproducto = elaboracionProductoService.buscarTodas();
		model.addAttribute("elaboracionproductoy", elaboracionproducto);
		LOGGER.info("ELABORACION DEL PRODUCTO FUE CARGADO");
		return "elaboracionproducto/listElaboracionProducto";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaElaboracionProducto") ElaboracionProducto elaboracionproductos,
			Model model, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadousuario/formEstadoUsuario";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		List<ElaboracionProducto> elaboracionproducto = elaboracionProductoService.buscarTodas();
		model.addAttribute("elaboracionproductoz", elaboracionproducto);
		LOGGER.info("FORM ELABORACIONPRODUCTO PARA CREAR UN NUEVO ESTADO USUARIO");
		return "elaboracionproducto/formElaboracionProducto";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaElaboracionProducto") ElaboracionProducto elaboracionproducto,
			BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto ElaboracionProducto: " + elaboracionproducto);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "elaboracionproducto/formElaboracionProducto";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto ElaboracionProducto: " + elaboracionproducto);
		System.out.println(
				"Elementos en la lista antes de la insersion: " + elaboracionProductoService.buscarTodas().size());

		elaboracionProductoService.inserta(elaboracionproducto);

		System.out.println(
				"Elementos en la lista despues de la insersion: " + elaboracionProductoService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El ElaboracionProducto fue guardado");
		return "redirect:/elaboracionproducto/listElaboracionProducto";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idElaboracionProducto, Model model) {
		Optional<ElaboracionProducto> estadoUsuario = elaboracionProductoService.buscarporId(idElaboracionProducto);
		model.addAttribute("InstanciaElaboracionProducto", estadoUsuario);
		LOGGER.warn("ELABORACION DEL PRODUCTO FUE ACTUALIZADO");

		return "estadousuario/formEstadoUsuario";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idElaboracionProducto,
			@ModelAttribute("InstanciaElaboracionProducto") ElaboracionProducto elaboracionProducto,
			BindingResult result, Model model, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto estadousuarios: " + elaboracionProducto);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "estadousuario/formEstadoUsuario";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Elaboracion del Producto: " + elaboracionProducto);

		System.out.println(
				"Elementos en la lista antes de la eliminación: " + elaboracionProductoService.buscarTodas().size());
		elaboracionProductoService.eliminar(idElaboracionProducto);
		System.out.println(
				"Elementos en la lista despues de la eliminación: " + elaboracionProductoService.buscarTodas().size());

		attributes.addFlashAttribute("mensajedelete", "El Elaboracion del producto fue eliminado");
		LOGGER.warn("ELABORACION DEL PRODUCTO FUE ELIMINADO");
		return "redirect:/estadousuario/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<ElaboracionProducto> lista = elaboracionProductoService.buscarTodas(page);
		model.addAttribute("elaboracionproductox", lista);
		return "elaboracionproducto/listElaboracionProducto";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
