package nanifarfalla.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.exception.ProductNotFoundException;
import nanifarfalla.app.model.Ceo;
import nanifarfalla.app.model.Linea;
import nanifarfalla.app.model.Producto;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.service.IAlertaService;
import nanifarfalla.app.service.IAnunciosService;
import nanifarfalla.app.service.ILineasService;
import nanifarfalla.app.service.IMenuService;
import nanifarfalla.app.service.IProductoService;
import nanifarfalla.app.service.IUserService;
import nanifarfalla.app.util.Utileria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * @author joffre
 *
 */
@Controller
public class HomeController {
	private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	private ILineasService serviceLineas;
	@Autowired
	private IAlertaService serviceAlertas;
	@Autowired
	private IAnunciosService serviceAnuncios;

	@Autowired
	private IProductoService serviceProductos;

	@Autowired
	private IMenuService menuservice;

	@Autowired
	private IUserService userService;

	private SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/*
	 * @RequestMapping(value = "/home", method = RequestMethod.GET) public String
	 * goHome() { return "home"; }
	 */

	@RequestMapping(value = { "/page" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("ecommerce/listProducts");
		mv.addObject("title", "Home");

		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");

		// passing the list of categories
		mv.addObject("categories", serviceLineas.buscarTodas());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	/*
	 * Methods to load all the products and based on category
	 */

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", serviceLineas.buscarTodas());
	//	mv.addObject("productos", serviceLineas.buscarTodas());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		List<Linea> category = serviceLineas.findByid_linea(id);
	
		//category = serviceLineas.buscarPorId(id);
    
	
		System.out.println("Linea elegida: "+category);
		
		mv.addObject("title", category.get(id).getNombre_linea());

		// passing the list of categories
		mv.addObject("lineas", serviceLineas.buscarTodas());

		// passing the single category object
		mv.addObject("lineaid", category.get(id).getCodigo_linea());

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}
	
	
	
	/*
	 * Viewing a single product
	 * */
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Producto product = serviceProductos.buscarPorId(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		// update the view count
		
		 // product.setViews(product.getViews() + 1); 
		  
		//  serviceProductos.update(product);
		 
		//---------------------------
		
		mv.addObject("title", product.getNombre_producto());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
		
	}
	
	

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {

		List<String> listaFechas = Utileria.getNextDays(4);
		// List<String> listaFechas = Utileria.getPastDays(-4);
//	System.out.println(listaFechas);

		// List<Linea> lineas = serviceLineas.buscarTodas();
		// List<Alerta> alertas = getLista2();
		// List<Anuncio> anuncios = getLista3();
		List<Usuario> usuarios = getLista5();
		List<Ceo> ceos = getLista4();

		// lineas.add("Carteras");
		// lineas.add("Mochilas");
		// lineas.add("Neceser");
		// lineas.add("Joyas");
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechabusqueda", fecha);
		// model.addAttribute("lineas", lineas);
		model.addAttribute("lineas", serviceLineas.buscarTodas());
		// model.addAttribute("alertas", alertas);
		model.addAttribute("alertas", serviceAlertas.buscarTodas());

		model.addAttribute("productos", serviceProductos.buscarTodas());

		// model.addAttribute("anuncios", anuncios);
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("ceos", ceos);
		model.addAttribute("anuncios", serviceAnuncios.buscarTodas());
		System.out.println("Buscando todas las lineas creadas en exhibicion para la fecha: " + fecha);
		for (int i = 0; i < listaFechas.size(); i++) {
			System.out.println(listaFechas.get(i));
		}
		return "page-index-1";

	}

	// @RequestMapping(value = "/detail/{id}/{fecha}", method = RequestMethod.GET)
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
//	public String mostrarDetalle(Model model, @PathVariable("id") int codigo_linea, @PathVariable("fecha") String fecha ) {
	public String mostrarDetalle(Model model, @RequestParam("codigo_linea") int codigo_linea,
			@RequestParam("fecha") String fecha) {

		System.out.println("Buscamos las lineas : " + codigo_linea);
		System.out.println("creadas en las fechas : " + fecha);
		model.addAttribute("linea", serviceLineas.buscarPorId(codigo_linea));

		model.addAttribute("productos", serviceProductos.buscarTodas());
//		String tituloLinea = "Carteras";
//		String estado = "disponible";
//		int stock = 136;
//		double precio = 34.5;
//
//		model.addAttribute("linea", tituloLinea);
//		model.addAttribute("estado", estado);
//		model.addAttribute("stock", stock);
//		model.addAttribute("precio", precio);
		return "detalle";

	}

	@RequestMapping(value ={"/", "/home", "/index"}, method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		
		
		List<String> listaFechas = Utileria.getNextDays(4);
		// List<String> listaFechas = Utileria.getPastDays(-4);
//		System.out.println(listaFechas);
		// List<Linea> lineas = serviceLineas.buscarTodas();
		// List<Alerta> alertas = getLista2();
		// List<Anuncio> anuncios = getLista3();
		List<Usuario> usuarios = getLista5();
		List<Ceo> ceos = getLista4();
		// lineas.add("Carteras");
		// lineas.add("Mochilas");
		// lineas.add("Neceser");
		// lineas.add("Joyas");
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechabusqueda", dateformat.format(new Date()));
		model.addAttribute("lineas", serviceLineas.buscarTodas());
		// model.addAttribute("alertas", alertas);
		model.addAttribute("alertas", serviceAlertas.buscarTodas());
		// model.addAttribute("anuncios", anuncios);
		model.addAttribute("productos", serviceProductos.buscarTodas());
		model.addAttribute("usuarios", usuarios);
		model.addAttribute("ceos", ceos);
		model.addAttribute("anuncios", serviceAnuncios.buscarTodas());
		model.addAttribute("menus", menuservice.buscarTodas());

		for (int i = 0; i < listaFechas.size(); i++) {
			System.out.println(listaFechas.get(i));
		}
		
		logger.info("Inside HomeController index method - INFO");
		logger.debug("Inside HomeController index method - DEBUG");

		return "page-index-1";
		// return "home";
	}

	@RequestMapping(value = "/demoa")
	public ModelAndView demoa() {
		ModelAndView mv = new ModelAndView("/demo/demo");
		mv.addObject("title", "usuario tipo A");
		mv.addObject("userClickDemoA", true);
		return mv;
	}

	@RequestMapping(value = "/demob")
	public ModelAndView demob() {
		ModelAndView mv = new ModelAndView("/demo/demo");
		mv.addObject("title", "usuario tipo B");
		mv.addObject("userClickDemoB", true);
		return mv;
	}

	@RequestMapping(value = "/democ")
	public ModelAndView democ() {
		ModelAndView mv = new ModelAndView("/demo/demo");
		mv.addObject("title", "usuario tipo C");
		mv.addObject("userClickDemoC", true);
		return mv;
	}

	
	//METODO DE LOGIN
	@RequestMapping(value = "/formLogin" )
	public String mostrarLogin() {
	return "login/formLogin";
	}

	@GetMapping(value = "/registro")
	public String registro(Model model) {
		List<Usuario> usuarios = userService.buscarTodas();
		model.addAttribute("usuarios", usuarios);

		return "/usuarios/formUsuario";
	}

	@PostMapping(value = "/register")
	public String guardar(@ModelAttribute Usuario usuarios, BindingResult result, RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request) {

		System.out.println("Recibiendo objeto Usuarios: " + usuarios);
		// Pendiente: Guardar el objeto noticia en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "page-index-1";
		}

		if (!multiPart.isEmpty()) {
			String nombreImagen = Utileria.guardarImagen(multiPart, request);

			usuarios.setRuta_foto(nombreImagen);
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto Usuarios: " + usuarios);

		System.out.println("Elementos en la lista antes de la insersion: " + userService.buscarTodas().size());

		System.out.println("Elementos en la lista despues de la insersion: " + userService.buscarTodas().size());

		userService.guardar(usuarios);
		attributes.addFlashAttribute("mensaje", "El usuario fue guardado");

		return "redirect:/login/users";
	}

	private List<Ceo> getLista4() {

		List<Ceo> lista = null;

		lista = new LinkedList<Ceo>();
		Ceo ceo1 = new Ceo();
		ceo1.setCodigo_ceo(1);
		ceo1.setNombre_ceo("Allison Jara Salas Nani");
		ceo1.setMensaje("Fundadora Nanifarfalla CEO");

		Ceo ceo2 = new Ceo();
		ceo2.setCodigo_ceo(1);
		ceo2.setNombre_ceo("Joffre Hermosilla");
		ceo2.setMensaje("Fundador hilo rojos");

		lista.add(ceo1);
		lista.add(ceo2);
		return lista;

	}

	private List<Usuario> getLista5() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		List<Usuario> lista = null;

		try {
			lista = new LinkedList<Usuario>();
			Usuario usuario1 = new Usuario();
			usuario1.setCodigo_usuario(1);
			usuario1.setNombre_usuario("Allison");
			usuario1.setApellido_usuario("Jara");

			usuario1.setFoto_usuario("image20.jpg");
			usuario1.setMensaje_usuario("Nos centramos en una cultura de paz");
			usuario1.setVersion(formatter.parse("18-11-2019"));

			Usuario usuario2 = new Usuario();
			usuario2.setCodigo_usuario(2);
			usuario2.setNombre_usuario("Hilo");
			usuario2.setApellido_usuario("Rojo");

			usuario2.setFoto_usuario("image34.jpg");
			usuario2.setMensaje_usuario("VIVE AL MAXIMO");
			usuario2.setVersion(formatter.parse("18-11-2019"));

			Usuario usuario3 = new Usuario();
			usuario3.setCodigo_usuario(3);
			usuario3.setNombre_usuario("Constanza");
			usuario3.setApellido_usuario("Hermosilla");

			usuario3.setFoto_usuario("image22.jpg");
			usuario3.setMensaje_usuario("TRATO JUSTO");
			usuario3.setVersion(formatter.parse("18-11-2019"));

			Usuario usuario4 = new Usuario();
			usuario4.setCodigo_usuario(4);
			usuario4.setNombre_usuario("Nobunaga");
			usuario4.setApellido_usuario("takeshi");

			usuario4.setFoto_usuario("image39.jpg");
			usuario4.setMensaje_usuario("NosASDAS z");
			usuario4.setVersion(formatter.parse("18-11-2019"));

			Usuario usuario5 = new Usuario();
			usuario5.setCodigo_usuario(5);
			usuario5.setNombre_usuario("fang fANG");
			usuario5.setApellido_usuario("XIE");

			usuario5.setFoto_usuario("image23.jpg");
			usuario5.setMensaje_usuario("Nos ceFLJSDLFJAultura de ");
			usuario5.setVersion(formatter.parse("18-11-2019"));

			lista.add(usuario1);
			lista.add(usuario2);
			lista.add(usuario3);
			lista.add(usuario4);
			lista.add(usuario5);

			return lista;

		} catch (ParseException ex) {
			System.out.println("Error: " + ex.getMessage());
			return null;
		}

	}
}
