package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import nanifarfalla.app.model.MenuV1;

import nanifarfalla.app.service.IMenuService;
import nanifarfalla.app.util.Utileria;

@Controller
@RequestMapping("/menus")
public class MenuV1Controller {
	@Autowired
	private IMenuService menuservice;
	
	@GetMapping(value = "/create")
	public String crear(@ModelAttribute MenuV1 menu, Model model) {
		List<MenuV1> menus = menuservice.buscarTodas();
		model.addAttribute("menus", menus);
		
		return "menus/formMenu";

	}

	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<MenuV1> menus = menuservice.buscarTodas();
		model.addAttribute("menus", menus);

		return "menus/listMenus";
	}
	
	
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("id") int id) {
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.println("Buscamos el menu : " + id);

		model.addAttribute("menu", menuservice.buscarPorId(id));
		// model.addAttribute("linea", serviceLineas.buscarPorId(codigo_linea));
		model.addAttribute("menus", menuservice.buscarTodas());
		model.addAttribute("fechas", listaFechas);

//		String tituloLinea = "Carteras";
//		String estado = "disponible";
//		int stock = 136;
//		double precio = 34.5;
//
//		model.addAttribute("linea", tituloLinea);
//		model.addAttribute("estado", estado);
//		model.addAttribute("stock", stock);
//		model.addAttribute("precio", precio);
		return "menus/detalleMenu";

	}
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	
	
}
