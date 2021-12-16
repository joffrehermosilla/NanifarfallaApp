package nanifarfalla.app.service;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.EstadoClienteTienePedido;



public interface IEstadoClienteTienePedidoService {
	void inserta(EstadoClienteTienePedido estadoclientetienepedido);
	void actualiza(EstadoClienteTienePedido estadoclientetienepedido);
	void elimina(EstadoClienteTienePedido estadoclientetienepedido);
	
	
	EstadoClienteTienePedido get(int estadoclientetienepedidoId);
	List<EstadoClienteTienePedido> list();	
	boolean add(EstadoClienteTienePedido estadoclientetienepedido);
	boolean update(EstadoClienteTienePedido estadoclientetienepedido);
	boolean delete(EstadoClienteTienePedido estadoclientetienepedido);
		
	//Siempre agregar la paginación
	Page<EstadoClienteTienePedido> buscarTodas(Pageable page);
	List<EstadoClienteTienePedido> buscarTodas();
}
