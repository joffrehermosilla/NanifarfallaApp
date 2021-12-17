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


import nanifarfalla.app.model.Privilege;
import nanifarfalla.app.service.IPrivelegeService;



@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

	@Autowired
	IPrivelegeService privilegeService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Privilege> privilege = privilegeService.buscarTodas();
		model.addAttribute("privilegey", privilege);

		return "privilege/listPrivilege";
	}
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  Privilege privilege,Model model) {
		List<Privilege> privileges = privilegeService.buscarTodas();
		model.addAttribute("privilegez", privileges);
		return "privilege/formPrivilege";

	}
	
	
	
	
	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Privilege privileges, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto privileges: " + privileges);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "privilege/formPrivilege";
		}

	

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto Privilege: " + privileges);

		System.out.println("Elementos en la lista antes de la insersion: " + privilegeService.buscarTodas().size());
		privilegeService.inserta(privileges);
		System.out.println("Elementos en la lista despues de la insersion: " + privilegeService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El Privilege fue guardado");

		return "redirect:/privilege/listPrivilege";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Privilege> lista = privilegeService.buscarTodas(page);
		model.addAttribute("privilegex", lista);
		return "privilege/listPrivilege";
	}

	

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
