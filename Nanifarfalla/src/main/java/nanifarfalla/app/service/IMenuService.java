package nanifarfalla.app.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.SetMultimap;

import nanifarfalla.app.model.MenuV1;
import nanifarfalla.app.util.ArbolCadenas;

public interface IMenuService {
	void inserta(MenuV1 menuv1);

	List<MenuV1> buscarTodas();
	
	Map<String, List<MenuV1>> menusByNombre();
	
	Map<MenuV1, List<MenuV1>> postsPerPadreAndhijos();
	
	Map<String, List<MenuV1>> menusxNombre();
	
	Map<String, List<MenuV1>> menusporNombre();
	
	Map<String, Map<String, List<MenuV1>>> mapa();
	
	Map<String, Map<Integer, List<MenuV1>>> map();
	
	ConcurrentMap<String, List<MenuV1>> Concurrentenombre();
	
	SetMultimap<String, MenuV1> MenuxNombrerMap();
	
	int lascode();
	
	void updatemenu(String name, int id);
	
	void guardar(MenuV1 menuv1);

	MenuV1 buscarporId(int idMenuV1);

	boolean hasChilds();

	void loadChilds();

	void arbolHijos();

	void JpaHijos();

	MenuV1 buscarPorId(int idMenuV1);
	
	
	

}
