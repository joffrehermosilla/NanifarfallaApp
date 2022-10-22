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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.Anuncio;

import nanifarfalla.app.service.IAnunciosService;

@Controller
@RequestMapping("/anuncios")
public class AnunciosController {
	private final static Logger LOGGER = LoggerFactory.getLogger(AnunciosController.class);
	@Autowired
	IAnunciosService anunciosService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaAnuncio") Anuncio anuncio, Model model, BindingResult result) {
		List<Anuncio> anuncios = anunciosService.buscarTodas();
		model.addAttribute("anunciosy", anuncios);
		LOGGER.info("ANUNCIO FUE CARGADO");
		return "anuncios/listAnuncios";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaAnuncio") Anuncio anuncio, Model model, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "anuncios/formAnuncio";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		List<Anuncio> anuncios = anunciosService.buscarTodas();
		model.addAttribute("anunciosz", anuncios);
		LOGGER.info("FORM ANUNCIO PARA CREAR UN ANUNCIO");
		return "anuncios/formAnuncio";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaAnuncio") Anuncio anuncio, BindingResult result,
			@RequestParam("archivoImagen") MultipartFile multiPart, RedirectAttributes attributes,
			HttpServletRequest request) {

		System.out.println("Recibiendo objeto Anuncio: " + anuncio);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "anuncios/formAnuncio";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto Anuncio: " + anuncio);
		System.out.println("Elementos en la lista antes de la insersion: " + anunciosService.buscarTodas().size());

		anunciosService.inserta(anuncio, multiPart, request);

		System.out.println("Elementos en la lista despues de la insersion: " + anunciosService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El Anuncio fue guardado");
		return "redirect:/anuncios/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idAnuncio, Model model) {
		Optional<Anuncio> anuncio = anunciosService.buscarporId(idAnuncio);
		model.addAttribute("InstanciaAnuncio", anuncio);
		LOGGER.warn("Anuncio FUE ACTUALIZADO");

		return "anuncios/formAnuncio";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idAnuncio, @ModelAttribute("InstanciaAnuncio") Anuncio anuncio,
			BindingResult result, Model model, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto anuncio: " + anuncio);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "anuncios/formAnuncio";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Anuncio: " + anuncio);

		System.out.println("Elementos en la lista antes de la eliminación: " + anunciosService.buscarTodas().size());
		anunciosService.eliminar(idAnuncio);
		System.out.println("Elementos en la lista despues de la eliminación: " + anunciosService.buscarTodas().size());

		attributes.addFlashAttribute("mensajedelete", "El Anuncio fue eliminado");
		LOGGER.warn("Anuncio FUE ELIMINADO");
		return "redirect:/anuncios/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Anuncio> anuncio = anunciosService.buscarTodas(page);
		model.addAttribute("anunciosx", anuncio);
		return "anuncios/listAnuncios";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
