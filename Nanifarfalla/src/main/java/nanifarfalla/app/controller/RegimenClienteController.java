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

import nanifarfalla.app.model.RegimenCliente;
import nanifarfalla.app.service.IRegimenCliente;




@RestController
@RequestMapping("/regimencliente")
public class RegimenClienteController {
	
	@Autowired
	IRegimenCliente regimenclienteService;
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<RegimenCliente> regimencliente = regimenclienteService.buscarTodas();
		model.addAttribute("regimenclientey", regimencliente);

		return "regimencliente/listRegimenCliente";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  RegimenCliente regimencliente,Model model) {
		List<RegimenCliente> regimenclientes = regimenclienteService.buscarTodas();
		model.addAttribute("regimenclientez", regimenclientes);
		return "regimencliente/formRegimenCliente";

	}
	
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute RegimenCliente regimenclientes, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto regimencliente: " + regimenclientes);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "regimencliente/formRegimenCliente";
		}

	

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto RegimenCliente: " + regimenclientes);

		System.out.println("Elementos en la lista antes de la insersion: " + regimenclienteService.buscarTodas().size());
		regimenclienteService.inserta(regimenclientes);
		System.out.println("Elementos en la lista despues de la insersion: " + regimenclienteService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El RegimenCliente fue guardado");

		return "redirect:/regimencliente/listRegimenCliente";
	}
	
	
	
	
	
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<RegimenCliente> lista = regimenclienteService.buscarTodas(page);
		model.addAttribute("regimenclientex", lista);
		return "regimencliente/listRegimenCliente";
	}

	

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
}
