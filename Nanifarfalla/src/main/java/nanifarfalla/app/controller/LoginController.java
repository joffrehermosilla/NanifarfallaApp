package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.model.Pedido;
import nanifarfalla.app.service.Impl.ClienteTienePedidoServiceJPA;

@Controller
@RequestMapping("/admin")
public class LoginController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ClienteTienePedidoServiceJPA clienteTienePedido;

	@GetMapping(value = "/index")
	public String mostrarPrincipalAdmin(Authentication authentication, RedirectAttributes attributes, Model model) {

		boolean sesionactiva = false;
		String sesionPerfil = "";
		ArrayList<String> lista = new ArrayList<String>();
		System.out.println("Usernameb: " + authentication.getName());

		for (GrantedAuthority rol : authentication.getAuthorities()) {
			lista.add("" + authentication.getAuthorities());
			System.out.println("Rol:" + rol.getAuthority());
			LOGGER.info("Usuario: " + authentication.getName() + " ROLES: " + rol.getAuthority());
		}

		ListIterator<String> iterator = lista.listIterator();
		String busqueda = "[ROLE_ADMIN, ROLE_BUYER, ROLE_SELLER]";
		while (iterator.hasNext()) {
			Object obj = iterator.next();

			System.out.println("Value is : " + iterator.next());
			System.out.println("Value is : " + lista.listIterator(0).toString());
			if (obj.equals(busqueda)) {

				sesionPerfil = "/login/console";
				LOGGER.warn(sesionPerfil);
				sesionactiva = true;
				model.addAttribute("sesion", sesionactiva);
				return sesionPerfil;
			} else {
				sesionPerfil = "/login/admin";
				LOGGER.info(sesionPerfil);
				sesionactiva = true;
				model.addAttribute("sesion", sesionactiva);
				LOGGER.info("control de navbarheader: " + sesionactiva);
				List<ClienteTienePedido> listVentas=clienteTienePedido.findPedido(137);
				System.out.println("listVentas Size:"+listVentas.size());
				model.addAttribute("listVentas", listVentas);
				return sesionPerfil;
			}
		}
		attributes.addFlashAttribute("mensajelogeo", "Bienvenido " + authentication.getName());
		LOGGER.info(sesionPerfil);
		LOGGER.info("" + sesionactiva);		
		return "redirect:/" + sesionPerfil;

	}

	@GetMapping(value = "/admin/logout")
	public String logout(HttpServletRequest request, RedirectAttributes attributes, Model model) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);

		boolean sesionactiva = false;

		model.addAttribute("sesion", sesionactiva);
		attributes.addFlashAttribute("mensajelogout", "Sesion Cerrada Correctamente");
		LOGGER.info("LOGOUT CIERRE DE SESIÓN CORRECTA");

		return "redirect:/formLogin";
	}
	
	
	@RequestMapping(value = "/admin/index")
	public String mostrarLogin(Model model) {

		boolean sesionactiva = true;

		model.addAttribute("sesion", sesionactiva);
		return "login/formLogin";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
