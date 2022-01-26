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
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PaisController.class);

	@Autowired
	private IPaisService paisService;
	
	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaPais") Pais pais,Model model,
			BindingResult result) {
		List<Pais> paisy = paisService.buscarTodas();
		model.addAttribute("paisy", paisy);
		LOGGER.info("Pais fue cargado");
		return "pais/listPais";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaPais") Pais pais,Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "pais/formPais";
		}		
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}		
		List<Pais> paisz = paisService.buscarTodas();
		model.addAttribute("paisz", paisz);
		LOGGER.info("FormPais para crear nuevo Pais");
		
		return "pais/formPais";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaPais") Pais pais, BindingResult result, RedirectAttributes attributes,
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
		LOGGER.info("Pais fue guardado");
		
//		return "redirect:/pais/listPais";
		return "redirect:/pais/index";
	}
	
	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idPais, Model model) {
		Optional<Pais> pais = paisService.buscarporId(idPais);
		model.addAttribute("InstanciaPais", pais);
		LOGGER.warn("Pais fue actualizado");

		return "pais/formPais";
	}	
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idPais,
			@ModelAttribute("InstanciaPais") Pais pais, BindingResult result, Model model,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto pais: " + pais);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "pais/formPais";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Pais: " + pais);
		System.out.println("Elementos en la lista antes de la eliminación: " + paisService.buscarTodas().size());
		
		paisService.eliminar(idPais);
		
		System.out.println("Elementos en la lista despues de la eliminación: " + paisService.buscarTodas().size());
		attributes.addFlashAttribute("mensajedelete", "El Pais fue eliminado");
		LOGGER.warn("Pais fue eliminado");
		
		return "redirect:/pais/index";
	}	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pais> lista = paisService.buscarTodas(page);
		model.addAttribute("paisx", lista);
		LOGGER.warn("Pais paginate cargado correctamente");
		return "pais/listPais";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
