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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.Anuncio;
import nanifarfalla.app.model.Producto;
import nanifarfalla.app.service.IProductoService;
import nanifarfalla.app.util.Utileria;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	
	@Autowired
	private IProductoService productoService;

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute Producto producto, Model model) {
		List<Producto> productos = productoService.buscarTodas();
		model.addAttribute("productos", productos);
		return "productos/formProducto";

	}
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {

		List<Producto> productos = productoService.buscarTodas();
		model.addAttribute("productos", productos);

		return "productos/listProductos";
	}
	
	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute Producto productos, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

		System.out.println("Recibiendo objeto productos: " + productos);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "productos/formProducto";
		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);
			
			productos.setFoto_ruta(nombreImagen);
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto Productos: " + productos);

		System.out.println("Elementos en la lista antes de la insersion: " + productoService.buscarTodas().size());
		productoService.inserta(productos);
		System.out.println("Elementos en la lista despues de la insersion: " + productoService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El producto fue guardado");

		return "redirect:/productos/index";
	}



	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	
}
