package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.FacturaClienteTienePedido;

public interface IFacturaCTienePedidoService {

	void inserta(FacturaClienteTienePedido facturaClienteTienePedido);
	void actualiza(FacturaClienteTienePedido facturaClienteTienePedido);
	void elimina(FacturaClienteTienePedido facturaClienteTienePedido);
		
	FacturaClienteTienePedido get(int facturaClienteTienePedidoId);
	List<FacturaClienteTienePedido> list();	
	boolean add(FacturaClienteTienePedido facturaClienteTienePedido);
	boolean update(FacturaClienteTienePedido facturaClienteTienePedido);
	boolean delete(FacturaClienteTienePedido facturaClienteTienePedido);
		
	Page<FacturaClienteTienePedido> buscarTodas(Pageable page);
	List<FacturaClienteTienePedido> buscarTodas();
}
