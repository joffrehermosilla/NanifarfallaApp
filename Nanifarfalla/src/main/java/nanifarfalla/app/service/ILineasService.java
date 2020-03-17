package nanifarfalla.app.service;

import java.util.List;



import nanifarfalla.app.model.Linea;

public interface ILineasService  {
	
	List<Linea> buscarTodas();
	
	Linea buscarPorId(int idLinea);

}
