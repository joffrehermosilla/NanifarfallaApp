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


import nanifarfalla.app.model.Linea;

import nanifarfalla.app.service.ILineasService;
import nanifarfalla.app.util.Utileria;

@Controller
@RequestMapping("/lineas")
public class LineasController {

	@Autowired
	private ILineasService serviceLineas;

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Linea linea, Model model) {
		List<Linea> lineas = serviceLineas.buscarTodas();
		model.addAttribute("lineas", lineas);
		return "lineas/formLinea";

	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Linea> lineas = serviceLineas.buscarTodas();
		model.addAttribute("lineas", lineas);

		return "lineas/listLineas";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Linea lineas, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

		System.out.println("Recibiendo objeto lineas: " + lineas);
		// Pendiente: Guardar el objeto noticia en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "lineas/formLinea";
		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);

			lineas.setFoto_linea(nombreImagen);
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
	
		System.out.println("Recibiendo objeto Lineas: " + lineas);

		System.out.println("Elementos en la lista antes de la insersion: " + serviceLineas.buscarTodas().size());
		serviceLineas.inserta(lineas);
		System.out.println("Elementos en la lista despues de la insersion: " + serviceLineas.buscarTodas().size());


		attributes.addFlashAttribute("mensaje", "El mensaje fue guardado");

		return "redirect:/lineas/index";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
