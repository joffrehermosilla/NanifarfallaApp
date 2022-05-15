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

import nanifarfalla.app.model.TipoAlerta;

import nanifarfalla.app.service.ITipoAlertaService;

@Controller
@RequestMapping("/tipoalerta")
public class TipoAlertaController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TipoAlertaController.class);
	@Autowired
	ITipoAlertaService tipoAlertaService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaTipoAlerta") TipoAlerta tipoalerta, Model model,
			BindingResult result) {
		List<TipoAlerta> tipoalertay = tipoAlertaService.buscarTodas();
		model.addAttribute("tipoalertay", tipoalertay);
		return "tipoalerta/listTipoAlerta";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaTipoAlerta") TipoAlerta tipoalertas, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipoalerta/formTipoAlerta";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		List<TipoAlerta> tipoalertaz = tipoAlertaService.buscarTodas();
		model.addAttribute("tipoalertaz", tipoalertaz);
		LOGGER.info("formTipoAlerta para crear nuevo Tipo Alerta");

		return "tipoalerta/formTipoAlerta";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaTipoAlerta") TipoAlerta tipoalerta, BindingResult result,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto TipoAlerta: " + tipoalerta);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipoalerta/formTipoAlerta";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto TipoAlerta: " + tipoalerta);
		System.out.println("Elementos en la lista antes de la insersion: " + tipoAlertaService.buscarTodas().size());

		tipoAlertaService.inserta(tipoalerta);

		System.out.println("Elementos en la lista despues de la insersion: " + tipoAlertaService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El TipoAlerta fue guardado");
		return "redirect:/tipoalerta/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idTipoAlerta, Model model) {
		Optional<TipoAlerta> tipoalerta = tipoAlertaService.buscarporId(idTipoAlerta);
		model.addAttribute("InstanciaTipoAlerta", tipoalerta);
		LOGGER.warn("Tipo Alerta fue actualizado");

		return "tipoalerta/formTipoAlerta";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idTipoAlerta,
			@ModelAttribute("InstanciaTipoAlerta") TipoAlerta tipoalerta, BindingResult result, Model model,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Tipo Alerta: " + tipoalerta);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipoalerta/formTipoAlerta";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Tipo Alerta: " + tipoalerta);
		System.out.println("Elementos en la lista antes de la eliminación: " + tipoAlertaService.buscarTodas().size());

		tipoAlertaService.eliminar(idTipoAlerta);

		System.out
				.println("Elementos en la lista despues de la eliminación: " + tipoAlertaService.buscarTodas().size());
		attributes.addFlashAttribute("mensajedelete", "El Tipo Alerta fue eliminado");
		LOGGER.warn("Tipo Alerta fue eliminado");

		return "redirect:/tipoalerta/index";
	}
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<TipoAlerta> lista = tipoAlertaService.buscarTodas(page);
		model.addAttribute("tipoalertax", lista);
		LOGGER.warn("Tipo Alerta paginate cargado correctamente");
	
		return "tipoalerta/listTipoAlerta";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
