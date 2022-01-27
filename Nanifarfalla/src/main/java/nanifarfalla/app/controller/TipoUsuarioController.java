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

import nanifarfalla.app.model.TipoUsuario;
import nanifarfalla.app.service.ITipoUsuarioService;

@Controller
@RequestMapping("/tipousuario")
public class TipoUsuarioController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TipoUsuarioController.class);
	
	@Autowired
	ITipoUsuarioService tipoUsuarioService;
	
	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaTipoUsuario") TipoUsuario tipousuario,Model model,
			BindingResult result) {
		List<TipoUsuario> tipousuarioy = tipoUsuarioService.buscarTodas();
		model.addAttribute("tipousuarioy", tipousuarioy);
		LOGGER.info("Tipo usuario fue cargado");
		return "tipousuario/listTipoUsuario";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaTipoUsuario") TipoUsuario tipousuario,Model model,
			BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipousuario/formTipoUsuario";
		}		
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}			
		List<TipoUsuario> tipousuarioz = tipoUsuarioService.buscarTodas();
		model.addAttribute("tipousuarioz", tipousuarioz);
		LOGGER.info("FormTipoUsuario para crear nuevo Tipo Usuario");
		
		return "tipousuario/formTipoUsuario";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaTipoUsuario") TipoUsuario tipousuario, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {
		
		System.out.println("Recibiendo objeto TipoUsuario: " + tipousuario);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipousuario/formTipoUsuario";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto TipoUsuario: " + tipousuario);
		System.out.println("Elementos en la lista antes de la insersion: " + tipoUsuarioService.buscarTodas().size());
		
		tipoUsuarioService.inserta(tipousuario);
		
		System.out.println("Elementos en la lista despues de la insersion: " + tipoUsuarioService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El TipoUsuario fue guardado");
		LOGGER.info("Tipo Usuario fue guardado");
		
		return "redirect:/tipousuario/index";
	}
	
	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idTipoUsuario, Model model) {
		Optional<TipoUsuario> tipousuario = tipoUsuarioService.buscarporId(idTipoUsuario);
		model.addAttribute("InstanciaTipoUsuario", tipousuario);
		LOGGER.warn("Tipo Usuario fue actualizado");

		return "tipousuario/formTipoUsuario";
	}	
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idTipoUsuario,
			@ModelAttribute("InstanciaTipoUsuario") TipoUsuario tipousuario, BindingResult result, Model model,
			RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Tipo Usuario: " + tipousuario);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "tipousuario/formTipoUsuario";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Tipo Usuario: " + tipousuario);
		System.out.println("Elementos en la lista antes de la eliminación: " + tipoUsuarioService.buscarTodas().size());
		
		tipoUsuarioService.eliminar(idTipoUsuario);
		
		System.out.println("Elementos en la lista despues de la eliminación: " + tipoUsuarioService.buscarTodas().size());
		attributes.addFlashAttribute("mensajedelete", "El Tipo Usuario fue eliminado");
		LOGGER.warn("Tipo Usuario fue eliminado");
		
		return "redirect:/tipousuario/index";
	}	
	
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<TipoUsuario> lista = tipoUsuarioService.buscarTodas(page);
		model.addAttribute("tipousuariox", lista);
		LOGGER.warn("Tipo Usuario paginate cargado correctamente");
		return "tipousuario/listTipoUsuario";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
