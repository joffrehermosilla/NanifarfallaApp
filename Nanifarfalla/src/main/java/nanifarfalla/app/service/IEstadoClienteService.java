package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.EstadoCliente;

public interface IEstadoClienteService {

	void inserta(EstadoCliente estadoCliente);
	void actualiza(EstadoCliente estadoCliente);
	void elimina(EstadoCliente estadoCliente);
		
	EstadoCliente get(int estadoClienteId);
	List<EstadoCliente> list();	
	boolean add(EstadoCliente estadoCliente);
	boolean update(EstadoCliente estadoCliente);
	boolean delete(EstadoCliente estadoCliente);
		
	Page<EstadoCliente> buscarTodas(Pageable page);
	List<EstadoCliente> buscarTodas();
}
