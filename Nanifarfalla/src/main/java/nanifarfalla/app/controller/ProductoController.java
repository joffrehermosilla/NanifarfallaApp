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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.ElaboracionProducto;
import nanifarfalla.app.model.Producto;

import nanifarfalla.app.service.ILineasService;
import nanifarfalla.app.service.IProductoService;
import nanifarfalla.app.util.Utileria;

@Controller
@RequestMapping("/productos")
public class ProductoController {
	private final static Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

	@Autowired
	private IProductoService productoService;

	@Autowired
	private ILineasService serviceLineas;

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaProducto") Producto producto, Model model, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "productos/formProducto";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		List<Producto> productos = productoService.buscarTodas();
		model.addAttribute("productoz", productos);
		// model.addAttribute("lineas", serviceLineas.buscarTodas());
		LOGGER.info("FORM PRODUCTO PARA CREAR UN NUEVO PRODUCTO");
		return "productos/formProducto";
	}

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaProducto") Producto producto, Model model,
			BindingResult result) {
		List<Producto> productos = productoService.buscarTodas();
		model.addAttribute("productoy", productos);
		LOGGER.info("PRODUCTO FUE CARGADO");
		return "productos/listProductos";
	}

	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("codigo_producto") int codigo_producto) {
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.println("Buscamos el producto : " + codigo_producto);

		model.addAttribute("producto", productoService.buscarPorId(codigo_producto));
		// model.addAttribute("linea", serviceLineas.buscarPorId(codigo_linea));
		model.addAttribute("productos", productoService.buscarTodas());
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
		return "productos/detalleProducto";

	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaProducto") Producto producto, BindingResult result,
			RedirectAttributes attributes, @RequestParam("archivoImagen") MultipartFile multiPart,
			@RequestParam("archivoImagen1") MultipartFile multiPart1,
			@RequestParam("archivoImagen2") MultipartFile multiPart2,
			@RequestParam("archivoImagen3") MultipartFile multiPart3,
			@RequestParam("archivoImagen4") MultipartFile multiPart4, HttpServletRequest request) {

		System.out.println("Recibiendo objeto productos: " + producto);
		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "productos/formProducto";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}
		// serviceAnuncios.guardar(productos);
		System.out.println("Recibiendo objeto Productos: " + producto);

		System.out.println("Elementos en la lista antes de la insersion: " + productoService.buscarTodas().size());
		productoService.inserta(producto, multiPart, multiPart1, multiPart2, multiPart3, multiPart4, request);
		System.out.println("Elementos en la lista despues de la insersion: " + productoService.buscarTodas().size());

		// return "anuncios/formAnuncio";
		attributes.addFlashAttribute("mensaje", "El producto fue guardado");

		return "redirect:/productos/index";
	}
	
	

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idProducto, Model model) {
		Optional<Producto> producto = productoService.buscarporId(idProducto);
		model.addAttribute("InstanciaProducto", producto);
		LOGGER.warn(" PRODUCTO FUE ACTUALIZADO");

		return "productos/formProducto";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idProducto, @ModelAttribute("InstanciaProducto") Producto producto,
			BindingResult result, Model model, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto elaboracion producto: " + producto);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");

			return "productos/formProducto";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto  del Producto: " + producto);

		System.out.println("Elementos en la lista antes de la eliminación: " + productoService.buscarTodas().size());
		productoService.eliminar(idProducto);
		System.out.println("Elementos en la lista despues de la eliminación: " + productoService.buscarTodas().size());

		attributes.addFlashAttribute("mensajedelete", "El producto fue eliminado");
		LOGGER.warn(" PRODUCTO FUE ELIMINADO");
		return "redirect:/productos/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Producto> lista = productoService.buscarTodas(page);
		model.addAttribute("productox", lista);
		return "productos/listProductos";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
