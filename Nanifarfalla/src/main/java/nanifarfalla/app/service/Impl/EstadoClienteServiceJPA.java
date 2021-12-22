package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.EstadoCliente;
import nanifarfalla.app.repository.EstadoClienteRepository;
import nanifarfalla.app.service.IEstadoClienteService;

@Service
public class EstadoClienteServiceJPA implements IEstadoClienteService{

	@Autowired
	EstadoClienteRepository estadoClienteRepository;
	
	@Override
	public void inserta(EstadoCliente estadoCliente) {
		estadoClienteRepository.save(estadoCliente);
		
	}

	@Override
	public void actualiza(EstadoCliente estadoCliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(EstadoCliente estadoCliente) {
		estadoClienteRepository.delete(estadoCliente);
		
	}

	@Override
	public EstadoCliente get(int estadoClienteId) {
		return estadoClienteRepository.getOne(estadoClienteId);
	}

	@Override
	public List<EstadoCliente> list() {
		return estadoClienteRepository.findAll();
	}

	@Override
	public boolean add(EstadoCliente estadoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EstadoCliente estadoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EstadoCliente estadoCliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<EstadoCliente> buscarTodas(Pageable page) {
		return estadoClienteRepository.findAll(page);
	}

	@Override
	public List<EstadoCliente> buscarTodas() {
		return estadoClienteRepository.findAll();
	}

}
