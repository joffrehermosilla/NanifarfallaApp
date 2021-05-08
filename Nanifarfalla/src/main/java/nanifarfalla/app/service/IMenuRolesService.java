package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.MenuRoles;

public interface IMenuRolesService {
	
	List<MenuRoles> buscartodas();
	
	void guardar(MenuRoles menuroles);

}
