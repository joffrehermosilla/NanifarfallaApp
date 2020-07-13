package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import nanifarfalla.app.model.Alerta;
import nanifarfalla.app.service.IAlertaService;
//import nanifarfalla.app.util.Utileria;

@Controller
@RequestMapping("/alertas")
public class AlertasController {

	@Autowired
	private IAlertaService serviceAlertas;

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Alerta alerta, Model model) {
		List<Alerta> alertas = serviceAlertas.buscarTodas();
		model.addAttribute("alertas", alertas);
		return "alertas/formAlerta";

	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Alerta> alertas = serviceAlertas.buscarTodas();
		model.addAttribute("alertas", alertas);

		return "alertas/listAlertas";
	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Alerta alertas, BindingResult result, RedirectAttributes attributes,
		 HttpServletRequest request) {

		System.out.println("Recibiendo objeto alertas: " + alertas);
		// Pendiente: Guardar el objeto noticia en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "alertas/formAlerta";
		}

		//if (!multiPart.isEmpty()) {
		//	String nombreImagen = Utileria.guardarImagen(multiPart, request);

			// lineas.setFoto_linea(nombreImagen);
	//	}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto Alertas: " + alertas);

		System.out.println("Elementos en la lista antes de la insersion: " + serviceAlertas.buscarTodas().size());
		serviceAlertas.inserta(alertas);
		System.out.println("Elementos en la lista despues de la insersion: " + serviceAlertas.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "La Alerta fue guardada");

		return "redirect:/alertas/index";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
