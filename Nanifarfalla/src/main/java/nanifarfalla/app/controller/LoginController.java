package nanifarfalla.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.service.IUserService;
import nanifarfalla.app.web.dto.UserDto;

@Controller
@RequestMapping("/admin")
public class LoginController {

	@Autowired
	private IUserService userService;
	
	@GetMapping(value = "/index")
	public String mostrarPrincipalAdmin(Authentication authentication) {
		System.out.println("Username: " + authentication.getName());
		for(GrantedAuthority rol: authentication.getAuthorities()) {
			System.out.println("Rol:" + rol.getAuthority());
		}
			
		
		return "/login/admin";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(request, null, null);
		return "redirect:/login";
	}
	
	@GetMapping(value = "/registro")
	public String registro(HttpServletRequest request) {
	
		return "redirect:/usuarios/formUsuario";
	}

	@PostMapping(value = "/register")
	public String guardar(@ModelAttribute Usuario usuarios, BindingResult result, RedirectAttributes attributes,
		 HttpServletRequest request) {

		System.out.println("Recibiendo objeto Usuarios: " + usuarios);
		// Pendiente: Guardar el objeto noticia en la BD
		if (result.hasErrors()) {
			System.out.println("Existen errores");
			return "page-index-1";
		}

		//if (!multiPart.isEmpty()) {
		//	String nombreImagen = Utileria.guardarImagen(multiPart, request);

			// lineas.setFoto_linea(nombreImagen);
	//	}

		for (ObjectError error : result.getAllErrors()) {
			System.out.println(error.getDefaultMessage() + " ");
		}

		System.out.println("Recibiendo objeto Usuarios: " + usuarios);

		System.out.println("Elementos en la lista antes de la insersion: " + userService.buscarTodas().size());
	
		System.out.println("Elementos en la lista despues de la insersion: " + userService.buscarTodas().size());
	UserDto userDto = new UserDto();
		userService.registerNewUserAccount(userDto);
		attributes.addFlashAttribute("mensaje", "El usuario fue guardado");

		return "redirect:/login";
	}
	
	
}
