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

import nanifarfalla.app.model.Role;
import nanifarfalla.app.service.IRoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {

	private final static Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	IRoleService roleService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaRole") Role role, Model model, BindingResult result) {

		List<Role> roley = roleService.buscarTodas();
		model.addAttribute("roley", roley);
		LOGGER.info("ROLE FUE CARGADO");
		return "roles/listRoles";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaRole") Role role, Model model, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "roles/formRole";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		List<Role> rolez = roleService.buscarTodas();
		model.addAttribute("rolez", rolez);
		LOGGER.info("FORM ROLES PARA CREAR UN NUEVO ROL");
		return "roles/formRole";

	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaRole") Role roles, BindingResult result,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto roles: " + roles);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "roles/formRole";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto Role: " + roles);

		System.out.println("Elementos en la lista antes de la insersion: " + roleService.buscarTodas().size());
		roleService.inserta(roles);
		System.out.println("Elementos en la lista despues de la insersion: " + roleService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El ROL fue guardado");
		LOGGER.info("ROL FUE GUARDADO");
		return "redirect:/roles/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idRole, Model model) {
		Optional<Role> role = roleService.buscarporId(idRole);
		model.addAttribute("InstanciaRole", role);
		LOGGER.warn("ROLE FUE ACTUALIZADO");

		return "roles/formRole";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idRole, @ModelAttribute("InstanciaRole") Role roles,
			BindingResult result, Model model, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Rol: " + roles);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "roles/formRole";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto ROle: " + roles);

		System.out.println("Elementos en la lista antes de la eliminación: " + roleService.buscarTodas().size());
		roleService.eliminar(idRole);
		System.out.println("Elementos en la lista despues de la eliminación: " + roleService.buscarTodas().size());

		attributes.addFlashAttribute("mensajedelete", "El rol fue eliminado");
		LOGGER.warn("ROLE FUE ELIMINADO");
		return "redirect:/roles/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Role> lista = roleService.buscarTodas(page);
		model.addAttribute("rolex", lista);
		LOGGER.warn("ROLE PAGINATE CARGADO SATISFACTORIAMENTE");
		return "roles/listRoles";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
