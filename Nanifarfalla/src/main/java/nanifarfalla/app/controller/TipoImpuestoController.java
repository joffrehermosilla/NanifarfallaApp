package nanifarfalla.app.controller;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nanifarfalla.app.model.EstadoUsuario;
import nanifarfalla.app.model.TipoImpuesto;
import nanifarfalla.app.service.ITipoImpuesto;




@RestController
@RequestMapping("/tipoimpuesto")
public class TipoImpuestoController {

	@Autowired
	ITipoImpuesto tipoimpuestoService;
	
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<TipoImpuesto> estadocatalogo = tipoimpuestoService.buscarTodas();
		model.addAttribute("estadocatalogoy", estadocatalogo);

		return "tipoimpuesto/listTipoImpuestos";
	}
	
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute  TipoImpuesto tipoimpuesto,Model model) {
		List<TipoImpuesto> tipoimpuestos = tipoimpuestoService.buscarTodas();
		model.addAttribute("tipoimpuestoz", tipoimpuestos);
		return "tipoimpuesto/formTipoImpuesto";

	}
	
	
	
	
	
	

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<TipoImpuesto> lista = tipoimpuestoService.buscarTodas(page);
		model.addAttribute("tipoimpuestox", lista);
		return "tipoimpuesto/listTipoImpuesto";
	}

	

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
}
