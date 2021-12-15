package nanifarfalla.app.service.Impl;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.EstadoClienteTienePedido;
import nanifarfalla.app.repository.EstadoClienteTienePedidoRepository;
import nanifarfalla.app.service.IEstadoClienteTienePedido;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class EstadoClienteTienePedidoServiceJPA implements IEstadoClienteTienePedido {

	@Autowired
	EstadoClienteTienePedidoRepository estadoclienttienepedidorepository;
	
	
	
	@Override
	public void inserta(EstadoClienteTienePedido estadoclientetienepedido) {
		// TODO Auto-generated method stub
		estadoclienttienepedidorepository.save(estadoclientetienepedido);
		
		
	}

	@Override
	public void actualiza(EstadoClienteTienePedido estadoclientetienepedido) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(EstadoClienteTienePedido estadoclientetienepedido) {
		// TODO Auto-generated method stub
		
		estadoclienttienepedidorepository.delete(estadoclientetienepedido);
		
	}

	@Override
	public EstadoClienteTienePedido get(int estadoclientetienepedidoId) {
		// TODO Auto-generated method stub
		return estadoclienttienepedidorepository.getOne(estadoclientetienepedidoId);
	}

	@Override
	public List<EstadoClienteTienePedido> list() {
		// TODO Auto-generated method stub
		return estadoclienttienepedidorepository.findAll();
	}

	@Override
	public boolean add(EstadoClienteTienePedido estadoclientetienepedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EstadoClienteTienePedido estadoclientetienepedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EstadoClienteTienePedido estadoclientetienepedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<EstadoClienteTienePedido> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return estadoclienttienepedidorepository.findAll(page);
	}

	@Override
	public List<EstadoClienteTienePedido> buscarTodas() {
		// TODO Auto-generated method stub
		return estadoclienttienepedidorepository.findAll();
	}

}
