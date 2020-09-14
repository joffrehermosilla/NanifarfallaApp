package nanifarfalla.app.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.MenuV1;
import nanifarfalla.app.repository.MenuV1Repository;
import nanifarfalla.app.service.IMenuService;

@Service
public class MenuServiceJPA implements IMenuService {

	@Autowired
	private MenuV1Repository menuV1Repository;

	@Override
	public void inserta(MenuV1 menuv1) {
		HashMap<Integer, List<MenuV1>> hashMap = new HashMap<Integer, List<MenuV1>>();
		if (!hashMap.containsKey(menuv1.getId())) {
		    List<MenuV1> list = new ArrayList<MenuV1>();
		    list.add(menuv1);

		    hashMap.put(menuv1.getId(), list);
		} else {
		    hashMap.get(menuv1.getId()).add(menuv1);
		}
		
		/*
		 * if you want all the student with particular location details then you can use
		 * this:
		 * 
		 * hashMap.get(locationId);
		 */
	}

	@Override
	public List<MenuV1> buscarTodas() {
		// TODO Auto-generated method stub
		return menuV1Repository.findAll();
	}

	@Override
	public void guardar(MenuV1 menuv1) {
		// TODO Auto-generated method stub

	}

	@Override
	public MenuV1 buscarporId(int idMenuV1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChilds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void loadChilds() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		Map<String, List<MenuV1>> menusuByNombre = new HashMap<String, List<MenuV1>>();
		for (MenuV1 menus : menulista) {
			if (menusuByNombre.containsKey(menus.getNombre())) {
				// Add to existing list
				menusuByNombre.get(menus.getNombre()).add(menus);

			} else {
				// Create new list
				List<MenuV1> menux = new ArrayList<MenuV1>(1);
				menux.add(menus);
				menusuByNombre.put(menus.getNombre(), menux);
			}
		}

	}

	@Override
	public void arbolHijos() {
		List<MenuV1> menulista = menuV1Repository.findAll();

		Map<String, List<MenuV1>> menusByNombre = new HashMap<>();

		for (MenuV1 menux : menulista) {
			menusByNombre.computeIfAbsent(menux.getNombre(), k -> new ArrayList<>()).add(menux);
		}

	}

	@Override
	public void JpaHijos() {
		List<MenuV1> menulista = menuV1Repository.findAll();
		Map<String, List<MenuV1>> menusByNombre = menulista.stream().collect(Collectors.groupingBy(MenuV1::getNombre));

		//Group<MenuV1> usersByCountry = group(menulista, by(on(MenuV1.class).getNombre()));
		
		
	}

	@Override
	public MenuV1 buscarPorId(int idMenuV1) {
		// TODO Auto-generated method stub
		return null;
	}

}
