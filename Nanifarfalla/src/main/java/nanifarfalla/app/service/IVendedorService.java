package nanifarfalla.app.service;

import java.util.List;

import nanifarfalla.app.model.Vendedor;

public interface IVendedorService {

	List<Vendedor> buscarTodas();
	void guardar(Vendedor vendedor);
	
}
