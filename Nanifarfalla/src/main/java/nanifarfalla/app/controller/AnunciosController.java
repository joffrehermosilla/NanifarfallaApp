package nanifarfalla.app.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.Anuncio;

import nanifarfalla.app.service.IAnunciosService;
import nanifarfalla.app.util.Utileria;


@Controller
@RequestMapping("/anuncios")
public class AnunciosController {

	@Autowired
	private IAnunciosService serviceAnuncios;

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  Anuncio anuncio,Model model) {
		List<Anuncio> anuncios = serviceAnuncios.buscarTodas();
		model.addAttribute("anuncios", anuncios);
		return "anuncios/formAnuncio";

	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Anuncio> anuncios = serviceAnuncios.buscarTodas();
		model.addAttribute("anuncios", anuncios);

		return "anuncios/listAnuncios";
	}

	// public String guardar(@RequestParam("titulo") String titulo,
	// @RequestParam("estatus") String estatus,
	// @RequestParam("detalle") String detalle) {
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Anuncio anuncios, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

		System.out.println("Recibiendo objeto anuncios: " + anuncios);
		// Pendiente: Guardar el objeto noticia en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "anuncios/formAnuncio";
		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			anuncios.setRuta_imagen(nombreImagen);
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(anuncios);
		System.out.println("Recibiendo objeto Anuncios: " + anuncios);

		System.out.println("Elementos en la lista antes de la insersion: " + serviceAnuncios.buscarTodas().size());
		serviceAnuncios.inserta(anuncios);
		System.out.println("Elementos en la lista despues de la insersion: " + serviceAnuncios.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El mensaje fue guardado");

		return "redirect:/anuncios/index";
	}



	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
