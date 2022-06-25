package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.MenuV1;

import nanifarfalla.app.service.IMenuService;
import nanifarfalla.app.util.Utileria;

@Controller
@RequestMapping("/menus")
public class MenuV1Controller {
	private final static Logger LOGGER = LoggerFactory.getLogger(MenuV1Controller.class);

	@Autowired
	private IMenuService menuservice;

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaMenuV1") MenuV1 menu, Model model, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "menus/formMenu";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		List<MenuV1> menuz = menuservice.buscarTodas();

		Set<String> setpadre = menuservice.padresSet();

		model.addAttribute("menuz", menuz);
		model.addAttribute("setpadre", setpadre);

		LOGGER.info("formMenu para crear nuevo Menu en ARBOL");

		return "menus/formMenu";
	}

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaMenuV1") MenuV1 menu, Model model, BindingResult result) {

		System.out.println("Buscamos el menu concurrente nombre: " + menuservice.Concurrentenombre());
		System.out.println("Buscamos el menu map Service : " + menuservice.map());
		System.out.println("Buscamos el menu mapa service : " + menuservice.mapa());
		System.out.println("Buscamos el menu menusByNombre : " + menuservice.menusByNombre());
		System.out.println("Buscamos el menu menu por Nombre : " + menuservice.menusporNombre());
		System.out.println("Buscamos el menu x NOMBRE : " + menuservice.menusxNombre());
		System.out.println("Buscamos el menuxnombreMap() : " + menuservice.MenuxNombrerMap());
		System.out.println("Buscamos el menu post perPadre Hijos: " + menuservice.postsPerPadreAndhijos());
		menuservice.arbolHijos();
		menuservice.loadChilds();
		menuservice.JpaHijos();

		List<MenuV1> menuy = menuservice.buscarTodas();
		model.addAttribute("menuy", menuy);

		return "menus/listMenus";
	}

	@PostMapping(value = "/save")
	public String guardar(@RequestParam("padre") String padre, @ModelAttribute("InstanciaMenuV1") MenuV1 menu,
			BindingResult result, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Menu: " + menu);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "menus/formMenu";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto Menu: " + menu);
		System.out.println("Elementos en la lista antes de la insersion: " + menuservice.buscarTodas().size());

		int opcion = 0;
		while (opcion <= menuservice.buscarTodas().size()) {
			if (padre.equals(menu.getNombre())) {
				opcion = menu.getId();
			}
			opcion++;
		}
		int cantidadmenu = menuservice.buscarTodas().size();
		int codigomenu = cantidadmenu + 1;
		// System.out.println("codigo menu generado: " + codigomenu);
		LOGGER.info("codigo menu generado: " + codigomenu);
		LOGGER.info("Id seleccionado del Padre: " + opcion);
		menu.setId(codigomenu);
		menu.setmMenuV1(menuservice.buscarporId(opcion));

		menuservice.inserta(menu);

		System.out.println("Elementos en la lista despues de la insersion: " + menuservice.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "El Menu fue guardado");
		return "redirect:/menus/index";
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

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idMenu, Model model) {
		Optional<MenuV1> menu = menuservice.obuscarporId(idMenu);
		model.addAttribute("InstanciaMenuV1", menu);
		LOGGER.warn("Menu fue actualizado");

		return "menus/formMenu";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idMenu, @ModelAttribute("InstanciaMenuV1") MenuV1 menu,
			BindingResult result, Model model, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Menu: " + menu);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "menus/formMenu";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto Menu: " + menu);
		System.out.println("Elementos en la lista antes de la eliminación: " + menuservice.buscarTodas().size());

		menuservice.eliminar(idMenu);

		System.out.println("Elementos en la lista despues de la eliminación: " + menuservice.buscarTodas().size());
		attributes.addFlashAttribute("mensajedelete", "El Menu fue eliminado");
		LOGGER.warn("Menu fue eliminado");

		return "redirect:/menus/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<MenuV1> lista = menuservice.buscarTodas(page);
		model.addAttribute("menux", lista);
		LOGGER.warn("Menu paginate cargado correctamente");

		return "menus/listMenus";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
