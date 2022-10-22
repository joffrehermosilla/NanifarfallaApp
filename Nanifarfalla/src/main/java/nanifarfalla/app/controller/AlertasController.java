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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import nanifarfalla.app.model.Alerta;
import nanifarfalla.app.model.TipoAlerta;
import nanifarfalla.app.service.IAlertaService;
//import nanifarfalla.app.util.Utileria;
import nanifarfalla.app.service.ITipoAlertaService;

@Controller
@RequestMapping("/alertas")
public class AlertasController {
	private final static Logger LOGGER = LoggerFactory.getLogger(AlertasController.class);

	@Autowired
	IAlertaService alertaService;

	@Autowired
	ITipoAlertaService tipoalertaService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaAlerta") Alerta alerta, Model model, BindingResult result) {
		List<Alerta> alertas = alertaService.buscarTodas();
		model.addAttribute("alertasy", alertas);
		LOGGER.info("Alerta FUE CARGADO");
		return "alertas/listAlertas";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaAlerta") Alerta alerta, Model model, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "alertas/formAlertas";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		List<Alerta> alertas = alertaService.buscarTodas();
		model.addAttribute("alertasz", alertas);
		LOGGER.info("FORM ALERTA PARA CREAR UNA ALERTA");
		return "alertas/formAlerta";
	}

	@PostMapping(value = "/save")
	public String guardar(@RequestParam("tipo") String tipo, @ModelAttribute("InstanciaAlerta") Alerta alerta,
			BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

		TipoAlerta tipoalerta = new TipoAlerta();

		System.out.println("Recibiendo objeto Alerta: " + alerta);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "alertas/formAlerta";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		int opcion = Integer.parseInt(tipo);
		LOGGER.info("Id de Tipo Alerta: " + opcion);

		tipoalerta = tipoalertaService.get(opcion);

		alerta.setmTipoAlerta(tipoalerta);

		System.out.println("Recibiendo objeto Alerta: " + alerta);
		System.out.println("Elementos en la lista antes de la insersion: " + alertaService.buscarTodas().size());

		alertaService.inserta(alerta);

		System.out.println("Elementos en la lista despues de la insersion: " + alertaService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "La Alerta fue guardado");
		return "redirect:/alertas/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idAlerta, Model model) {
		Optional<Alerta> alerta = alertaService.buscarporId(idAlerta);
		model.addAttribute("InstanciaAlerta", alerta);
		LOGGER.warn("Alerta FUE ACTUALIZADO");

		return "alertas/formAlerta";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idAlerta, @ModelAttribute("InstanciaAlerta") Alerta alerta,
			BindingResult result, Model model, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto anuncio: " + alerta);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "alertas/formAlerta";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Alerta: " + alerta);

		System.out.println("Elementos en la lista antes de la eliminación: " + alertaService.buscarTodas().size());
		alertaService.eliminar(idAlerta);
		System.out.println("Elementos en la lista despues de la eliminación: " + alertaService.buscarTodas().size());

		attributes.addFlashAttribute("mensajedelete", "La Alerta fue eliminada");
		LOGGER.warn("Alerta FUE ELIMINADO");
		return "redirect:/alertas/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Alerta> alerta = alertaService.buscarTodas(page);
		model.addAttribute("alertasx", alerta);
		return "alertas/listAlertas";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
