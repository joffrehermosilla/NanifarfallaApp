package nanifarfalla.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuConsolaController {
	private final static Logger LOGGER = LoggerFactory.getLogger(MenuConsolaController.class);
	
	@RequestMapping(value = "/estadousuarioconsole")
	public ModelAndView estadousuario() {
		ModelAndView mv = new ModelAndView("login/plainpage");
		mv.addObject("title", "Estado Usuario");
		mv.addObject("userClickEstadoUsuario", true);
		LOGGER.info("ruta del mv"+ mv);
		return mv;
	}
	
	
	@RequestMapping(value = "/elaboracionproductoconsole")
	public ModelAndView elaboracionproducto() {
		ModelAndView mv = new ModelAndView("/estadousuario/indexPaginate?page=0");
		mv.addObject("title", "Elaboracion Producto");
		mv.addObject("userClickElaboracionProducto", true);
		return mv;
	}
	
	@RequestMapping(value = "/plainpage")
	public ModelAndView cargarplainpage() {
		ModelAndView mv = new ModelAndView("login/plainpage");
		mv.addObject("title", "Elaboracion Producto");
		mv.addObject("userClickElaboracionProducto", true);
		return mv;
	}
}
