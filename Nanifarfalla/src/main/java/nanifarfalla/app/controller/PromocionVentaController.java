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

import nanifarfalla.app.model.PromocionVenta;
import nanifarfalla.app.service.IPromocionVentaService;

@RestController
@RequestMapping("/promocionventa")
public class PromocionVentaController {

	@Autowired
	IPromocionVentaService promocionVentaService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<PromocionVenta> promocionventa = promocionVentaService.buscarTodas();
		model.addAttribute("promocionventay", promocionventa);
		return "promocionventa/listPromocionVenta";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  PromocionVenta promocionventas,Model model) {
		List<PromocionVenta> promocionventa = promocionVentaService.buscarTodas();
		model.addAttribute("promocionventaz", promocionventa);
		return "promocionventa/formPromocionVenta";
	}

	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute PromocionVenta promocionventa, BindingResult result, RedirectAttributes attributes,
			 HttpServletRequest request) {

		System.out.println("Recibiendo objeto PromocionVenta: " + promocionventa);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "promocionventa/formPromocionVenta";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		
		System.out.println("Recibiendo objeto PromocionVenta: " + promocionventa);
		System.out.println("Elementos en la lista antes de la insersion: " + promocionVentaService.buscarTodas().size());
		
		promocionVentaService.inserta(promocionventa);
		
		System.out.println("Elementos en la lista despues de la insersion: " + promocionVentaService.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El PromocionVenta fue guardado");
		return "redirect:/promocionventa/listPromocionVenta";
	}
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<PromocionVenta> lista = promocionVentaService.buscarTodas(page);
		model.addAttribute("promocionventax", lista);
		return "promocionventa/listPromocionVenta";
	}

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
