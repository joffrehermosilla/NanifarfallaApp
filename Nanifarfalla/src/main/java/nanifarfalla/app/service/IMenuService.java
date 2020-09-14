package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.MenuV1;

public interface IMenuService {
	void inserta(MenuV1 menuv1);

	List<MenuV1> buscarTodas();

	void guardar(MenuV1 menuv1);

	MenuV1 buscarporId(int idMenuV1);

	boolean hasChilds();

	void loadChilds();

	void arbolHijos();

	void JpaHijos();

	MenuV1 buscarPorId(int idMenuV1);
	
	
	

}
