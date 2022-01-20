package nanifarfalla.app.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class LoginController {
	private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@GetMapping(value = "/index")
	public String mostrarPrincipalAdmin(Authentication authentication) {
		String sesionPerfil = "";
		ArrayList<String> lista = new ArrayList<String>();
		System.out.println("Username: " + authentication.getName());
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
				return sesionPerfil;
			} else {
				sesionPerfil = "/login/admin";
				LOGGER.warn(sesionPerfil);
				return sesionPerfil;
			}
		}

		LOGGER.info(sesionPerfil);
		return sesionPerfil;

	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request, RedirectAttributes attributes) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);

		attributes.addFlashAttribute("mensajelogout", "Sesion Cerrada Correctamente");
		LOGGER.info("LOGOUT CIERRE DE SESIÓN CORRECTA");

		return "redirect:/formLogin";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
