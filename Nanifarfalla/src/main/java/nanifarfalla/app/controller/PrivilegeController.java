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

import nanifarfalla.app.model.Privilege;
import nanifarfalla.app.service.IPrivelegeService;

@Controller
@RequestMapping("/privilege")
public class PrivilegeController {
	private final static Logger LOGGER = LoggerFactory.getLogger(PrivilegeController.class);
	@Autowired
	IPrivelegeService privilegeService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaEstadoContrato") Privilege privilege, Model model,
			BindingResult result) {
		List<Privilege> privilegey = privilegeService.buscarTodas();
		model.addAttribute("privilegey", privilegey);
		return "privilege/listPrivilege";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaPrivilege") Privilege privilege, Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "privilege/formPrivilege";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		List<Privilege> privilegez = privilegeService.buscarTodas();
		model.addAttribute("privilegez", privilegez);
		LOGGER.info("formPrivilege para crear nuevo Estado Contrato");

		return "privilege/formPrivilege";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaPrivilege") Privilege privilege,
			BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Privilege: " + privilege);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "privilege/formPrivilege";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto Privilege: " + privilege);
		System.out
				.println("Elementos en la lista antes de la insersion: " + privilegeService.buscarTodas().size());

		privilegeService.inserta(privilege);

		System.out.println(
				"Elementos en la lista despues de la insersion: " + privilegeService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El Privilege fue guardado");
		return "redirect:/privilege/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idPrivilege, Model model) {
		Optional<Privilege> privilege = privilegeService.buscarporId(idPrivilege);
		model.addAttribute("InstanciaPrivilege", privilege);
		LOGGER.warn("Privilege fue actualizado");

		return "privilege/formPrivilege";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idPrivilege,
			@ModelAttribute("InstanciaPrivilege") Privilege privilege, BindingResult result, Model model,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Estado Contrato: " + privilege);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "privilege/formPrivilege";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Privilege: " + privilege);
		System.out.println(
				"Elementos en la lista antes de la eliminación: " + privilegeService.buscarTodas().size());

		privilegeService.eliminar(idPrivilege);

		System.out.println(
				"Elementos en la lista despues de la eliminación: " + privilegeService.buscarTodas().size());
		attributes.addFlashAttribute("mensajedelete", "El Privilege fue eliminado");
		LOGGER.warn("Privilege fue eliminado");

		return "redirect:/privilege/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Privilege> lista = privilegeService.buscarTodas(page);
		model.addAttribute("privilegex", lista);
		LOGGER.warn("Privilege paginate cargado correctamente");

		return "privilege/listPrivilege";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
