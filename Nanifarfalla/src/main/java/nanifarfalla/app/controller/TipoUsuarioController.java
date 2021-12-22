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

import nanifarfalla.app.model.TipoUsuario;
import nanifarfalla.app.service.ITipoUsuarioService;

@RestController
@RequestMapping("/tipousuario")
public class TipoUsuarioController {
	
	@Autowired
	ITipoUsuarioService tipoUsuarioService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<TipoUsuario> tipousuario = tipoUsuarioService.buscarTodas();
		model.addAttribute("tipousuarioy", tipousuario);
		return "tipousuario/listTipoUsuario";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  TipoUsuario tipousuarios,Model model) {
		List<TipoUsuario> tipousuario = tipoUsuarioService.buscarTodas();
		model.addAttribute("tipousuarioz", tipousuario);
		return "tipousuario/formTipoUsuario";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute TipoUsuario tipousuario, BindingResult result, RedirectAttributes attributes,
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
		return "redirect:/tipousuario/listTipoUsuario";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<TipoUsuario> lista = tipoUsuarioService.buscarTodas(page);
		model.addAttribute("tipousuariox", lista);
		return "tipousuario/listTipoUsuario";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
