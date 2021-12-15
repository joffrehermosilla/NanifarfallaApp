package nanifarfalla.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import nanifarfalla.app.model.RegimenCliente;




public interface IRegimenCliente {

	
	void inserta(RegimenCliente regimencliente);
	void actualiza(RegimenCliente regimencliente);
	void elimina(RegimenCliente regimencliente);
	
	
	RegimenCliente get(int regimenclienteId);
	List<RegimenCliente> list();	
	boolean add(RegimenCliente regimencliente);
	boolean update(RegimenCliente regimencliente);
	boolean delete(RegimenCliente regimencliente);
		
	//Siempre agregar la paginación
	Page<RegimenCliente> buscarTodas(Pageable page);
	List<RegimenCliente> buscarTodas();
	
}
