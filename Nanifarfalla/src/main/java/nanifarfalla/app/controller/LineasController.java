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
import org.springframework.security.core.Authentication;
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

import nanifarfalla.app.model.Linea;
import nanifarfalla.app.model.SeguridadResponse;
import nanifarfalla.app.model.SesionRequest;
import nanifarfalla.app.model.SesionResponse;
import nanifarfalla.app.service.ILineasService;
import nanifarfalla.app.service.INiubizService;
import nanifarfalla.app.service.IProductoService;
import nanifarfalla.app.util.Utileria;
import nanifarfalla.app.web.dto.LineaDto;

@Controller
@RequestMapping("/lineas")
public class LineasController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LineasController.class);
	@Autowired
	private ILineasService serviceLineas;

	@Autowired
	private INiubizService niubiz;

	@Autowired
	private IProductoService productoService;

	@GetMapping("/index")
	public String mostrarIndex(@ModelAttribute("InstanciaLinea") Linea lineas, Model model, BindingResult result) {
		List<Linea> linea = serviceLineas.buscarTodas();
		model.addAttribute("lineay", linea);
		LOGGER.info("CARGANDO LINEA CONTROLLER");
		return "lineas/listLineas";
	}

	@GetMapping(value = "/create")
	public String crear(@ModelAttribute("InstanciaLinea") Linea lineas, Model model, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "lineas/formLinea";
		}
		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		List<Linea> linea = serviceLineas.buscarTodas();
		model.addAttribute("lineaz", linea);
		LOGGER.info("FORM LINEA PARA CREAR UNA NUEVA LINEA");
		return "lineas/formLinea";
	}

	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @RequestParam("codigo_linea") int codigo_linea,
			@RequestParam("fecha") String fecha) {
		List<String> listaFechas = Utileria.getNextDays(4);
		System.out.println("Buscamos las lineas : " + codigo_linea);

		System.out.println("***1. API de Seguridad***");
		Double montoTotal = 20.0;
		SeguridadResponse seguridadResponse = niubiz.seguridadPagoNiubiz();
		model.addAttribute(seguridadResponse.getAccessToken());
		System.out.println("***2. API de Sesion para JS***");
		SesionRequest sesionRequest = new SesionRequest();
		sesionRequest.setChannel("web");
		sesionRequest.setAmount(montoTotal + "");
		sesionRequest.setAccessToken(seguridadResponse.getAccessToken());
		SesionResponse sesionResponse = niubiz.sesionPagoNiubiz(sesionRequest);
		model.addAttribute("sessionKey", sesionResponse.getSessionKey());
		model.addAttribute("canalSesion", "web");
		model.addAttribute("codigoComercio", "456879852");
		model.addAttribute("montoTotal", montoTotal);

		System.out.println("creadas en las fechas : " + fecha);
		model.addAttribute("linea", serviceLineas.buscarPorId(codigo_linea));

		model.addAttribute("productos", productoService.buscarTodas());
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechabusqueda", fecha);
//		String tituloLinea = "Carteras";
//		String estado = "disponible";
//		int stock = 136;
//		double precio = 34.5;
//
//		model.addAttribute("linea", tituloLinea);
//		model.addAttribute("estado", estado);
//		model.addAttribute("stock", stock);
//		model.addAttribute("precio", precio);
		return "lineas/detalle";

	}

	@PostMapping(value = "/save")
	public String guardar(@ModelAttribute("InstanciaLinea") Linea linea, BindingResult result,
			@RequestParam("archivoImagen1") MultipartFile multiPart1,
			@RequestParam("archivoImagen2") MultipartFile multiPart2, RedirectAttributes attributes,
			HttpServletRequest request) {

		Authentication authentication;

		System.out.println("Recibiendo objeto LINEAS: " + linea);
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "lineas/formLinea";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto LINEA: " + linea);
		System.out.println("Elementos en la lista antes de la insersion: " + serviceLineas.buscarTodas().size());

		// serviceLineas.inserta(linea);

		LineaDto lineaDto = new LineaDto();

		lineaDto.setCodigo_linea(linea.getCodigo_linea());
		lineaDto.setNombre_linea(linea.getNombre_linea());

		serviceLineas.registroLineaString(lineaDto, 1, multiPart1, multiPart2, request);

		System.out.println("Elementos en la lista despues de la insersion: " + serviceLineas.buscarTodas().size());

		attributes.addFlashAttribute("mensaje", "LA LINEA fue guardado");
		return "redirect:/lineas/index";
	}

	@GetMapping(value = "/update/{id}")
	public String editar(@PathVariable("id") int idLinea, Model model) {
		Optional<Linea> linea = serviceLineas.buscarporId(idLinea);
		model.addAttribute("InstanciaLinea", linea);
		LOGGER.warn("LINEA FUE ACTUALIZADO");

		return "lineas/formLinea";
	}

	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idLinea, @ModelAttribute("InstanciaLinea") Linea linea,
			BindingResult result, Model model, RedirectAttributes attributes, HttpServletRequest request) {

		System.out.println("Recibiendo objeto LINEA: " + linea);

		// Pendiente: Guardar el objeto producto en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "lineas/formLinea";
		}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Eliminando objeto LINEA: " + linea);

		System.out.println("Elementos en la lista antes de la eliminación: " + serviceLineas.buscarTodas().size());
		serviceLineas.eliminar(idLinea);
		System.out.println("Elementos en la lista despues de la eliminación: " + serviceLineas.buscarTodas().size());

		attributes.addFlashAttribute("mensajedelete", "La Linea fue eliminada satisfactoriamente");
		LOGGER.warn("LA LINEA FUE ELIMINADA");
		return "redirect:/lineas/index";
	}

	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Linea> lista = serviceLineas.buscarTodas(page);
		model.addAttribute("lineax", lista);
		return "lineas/listLineas";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
