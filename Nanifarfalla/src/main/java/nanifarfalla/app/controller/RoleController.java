package nanifarfalla.app.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.Role;
import nanifarfalla.app.service.IRoleService;



@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	IRoleService roleService;
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Role> role = roleService.buscarTodas();
		model.addAttribute("roley", role);

		return "role/listRoles";
	}
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  Role role,Model model) {
		List<Role> roles = roleService.buscarTodas();
		model.addAttribute("rolez", roles);
		return "roles/formRole";

	}
	
	
	
	
	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Role roles, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto roles: " + roles);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "roles/formRoles";
		}

	

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto Roles: " + roles);

		System.out.println("Elementos en la lista antes de la insersion: " + roleService.buscarTodas().size());
		roleService.inserta(roles);
		System.out.println("Elementos en la lista despues de la insersion: " + roleService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El EstadoUsuario fue guardado");

		return "redirect:/roles/listRoles";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Role> lista = roleService.buscarTodas(page);
		model.addAttribute("rolex", lista);
		return "roles/listRoles";
	}

	

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}	
	
	
	
	
	
	

