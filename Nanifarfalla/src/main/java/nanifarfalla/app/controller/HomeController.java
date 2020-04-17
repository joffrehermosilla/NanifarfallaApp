package nanifarfalla.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import nanifarfalla.app.model.Ceo;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.service.IAlertaService;
import nanifarfalla.app.service.IAnunciosService;
import nanifarfalla.app.service.ILineasService;
import nanifarfalla.app.service.IProductoService;
import nanifarfalla.app.util.Utileria;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {
	@Autowired
	private ILineasService serviceLineas;
	@Autowired
	private IAlertaService serviceAlertas;
	@Autowired
	private IAnunciosService serviceAnuncios;
	
	@Autowired
	private IProductoService serviceProductos;
	
	private SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {

		List<String> listaFechas = Utileria.getNextDays(4);

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas = Utileria.getNextDays(4);
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
		return "page-index-1";
		// return "home";
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
			usuario1.setPaterno_usuario("Jara");
			usuario1.setMaterno_usuario("Salas");
			usuario1.setFoto_usuario("image20.jpg");
			usuario1.setMensaje_usuario("Nos centramos en una cultura de paz");
			usuario1.setFechacreacion(formatter.parse("18-11-2019"));

			Usuario usuario2 = new Usuario();
			usuario2.setCodigo_usuario(2);
			usuario2.setNombre_usuario("Hilo");
			usuario2.setPaterno_usuario("Rojo");
			usuario2.setMaterno_usuario("Barranco");
			usuario2.setFoto_usuario("image34.jpg");
			usuario2.setMensaje_usuario("VIVE AL MAXIMO");
			usuario2.setFechacreacion(formatter.parse("18-11-2019"));

			Usuario usuario3 = new Usuario();
			usuario3.setCodigo_usuario(3);
			usuario3.setNombre_usuario("Constanza");
			usuario3.setPaterno_usuario("Hermosilla");
			usuario3.setMaterno_usuario("Salas");
			usuario3.setFoto_usuario("image22.jpg");
			usuario3.setMensaje_usuario("TRATO JUSTO");
			usuario3.setFechacreacion(formatter.parse("18-11-2019"));

			Usuario usuario4 = new Usuario();
			usuario4.setCodigo_usuario(4);
			usuario4.setNombre_usuario("Nobunaga");
			usuario4.setPaterno_usuario("takeshi");
			usuario4.setMaterno_usuario("Salas");
			usuario4.setFoto_usuario("image39.jpg");
			usuario4.setMensaje_usuario("NosASDAS z");
			usuario4.setFechacreacion(formatter.parse("18-11-2019"));

			Usuario usuario5 = new Usuario();
			usuario5.setCodigo_usuario(5);
			usuario5.setNombre_usuario("fang fANG");
			usuario5.setPaterno_usuario("XIE");
			usuario5.setMaterno_usuario("Salas");
			usuario5.setFoto_usuario("image23.jpg");
			usuario5.setMensaje_usuario("Nos ceFLJSDLFJAultura de ");
			usuario5.setFechacreacion(formatter.parse("18-11-2019"));

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
