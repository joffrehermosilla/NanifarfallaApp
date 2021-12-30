package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.Pais;
import nanifarfalla.app.service.IPaisService;

@Controller
@RequestMapping(path="/pais")
public class PaisController {

	@Autowired
	private IPaisService paisService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pais> pais = paisService.buscarTodas();
		model.addAttribute("paisy", pais);
		return "pais/listPais";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  Pais paiss,Model model) {
		List<Pais> pais = paisService.buscarTodas();
		model.addAttribute("paisz", pais);
		return "pais/formPais";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Pais pais, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto Pais: " + pais);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "pais/formPais";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto Pais: " + pais);
		System.out.println("Elementos en la lista antes de la insersion: " + paisService.buscarTodas().size());
		
		paisService.inserta(pais);
		
		System.out.println("Elementos en la lista despues de la insersion: " + paisService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El Pais fue guardado");
		return "redirect:/pais/listPais";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pais> lista = paisService.buscarTodas(page);
		model.addAttribute("paisx", lista);
		return "pais/listPais";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
