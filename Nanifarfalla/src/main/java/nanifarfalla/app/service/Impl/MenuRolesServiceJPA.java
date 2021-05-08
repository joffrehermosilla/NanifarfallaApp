package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.MenuRoles;
import nanifarfalla.app.repository.MenuRolesRepository;
import nanifarfalla.app.service.IMenuRolesService;

@Service
public class MenuRolesServiceJPA implements IMenuRolesService {

	@Autowired
	MenuRolesRepository menurolesRepository;

	@Override
	public List<MenuRoles> buscartodas() {
		// TODO Auto-generated method stub
		return menurolesRepository.findAll();
	}

	@Override
	public void guardar(MenuRoles menuroles) {
		// TODO Auto-generated method stub
		menurolesRepository.save(menuroles);
	}

}
