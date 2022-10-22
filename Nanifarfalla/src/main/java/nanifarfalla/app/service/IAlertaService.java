package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.Alerta;


public interface IAlertaService {

	void inserta(Alerta alerta);

	List<Alerta> buscarTodas();

	void guardar(Alerta alerta);

	Alerta buscarporId(int idAlerta);
	
	
}
