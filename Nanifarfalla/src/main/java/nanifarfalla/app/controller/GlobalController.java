package nanifarfalla.app.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import nanifarfalla.app.model.ClienteTienePedido;
import nanifarfalla.app.model.ProductoxPedido;
import nanifarfalla.app.model.UserModel;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.service.UserService;

@ControllerAdvice
public class GlobalController {
	private final static Logger LOGGER = LoggerFactory.getLogger(GlobalController.class);
	@Autowired
	private UserService userDAO;

	@Autowired
	private HttpSession session;

	private UserModel userModel = null;
	private Usuario user = null;
	private ClienteTienePedido clienteTienePedido = null;
	private ProductoxPedido productoxPedido = null;

	@ModelAttribute("userModelx")
	public UserModel getUserModel() {
		if (session.getAttribute("userModelx") == null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			LOGGER.info("AUTENTICAION DESDE GLOBAL CONTROLLER USERMODEL: " + authentication);
			if (!authentication.getPrincipal().equals("anonymousUser")) {
				// get the user from the database
				user = userDAO.findUserByEmail(authentication.getName());

				if (user != null) {
					// create a new model
					userModel = new UserModel();
					// set the name and the id
					userModel.setId(user.getCodigo_usuario());
					userModel.setFullName(user.getNombre_usuario() + " " + user.getApellido_usuario());
					userModel.setRole(user.getRoles());
					LOGGER.info("ROLES DE USUARIO CONFIRMADO: " + user.getRoles());

					if (user.getRoles().equals("ROLE_BUYER")) {
						LOGGER.info("ROLES BUYERS Y ADMIN " + user.getRoles());

						clienteTienePedido.setmUsuario(user);
						productoxPedido.setmClientetienepedido(clienteTienePedido);

						userModel.setCart(productoxPedido);
					}

					session.setAttribute("userModel", userModel);
					return userModel;
				}
			}
		}

		return (UserModel) session.getAttribute("userModel");
	}

}