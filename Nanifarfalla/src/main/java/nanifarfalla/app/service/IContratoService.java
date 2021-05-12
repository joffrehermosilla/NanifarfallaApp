package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.Contrato;

public interface IContratoService {

	List<Contrato> buscartodos();
	void guardar(Contrato contrato);
	
	int lastcode();
	
}
