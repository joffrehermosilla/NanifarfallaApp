package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.EstadoProducto;
import nanifarfalla.app.repository.EstadoProductoRepository;
import nanifarfalla.app.service.IEstadoProductoService;

@Service
public class EstadoProductoServiceJPA implements IEstadoProductoService{
	
	@Autowired
	EstadoProductoRepository estadoProductoRepository;

	@Override
	public void inserta(EstadoProducto estadoProducto) {
		estadoProductoRepository.save(estadoProducto);
		
	}

	@Override
	public void actualiza(EstadoProducto estadoProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(EstadoProducto estadoProducto) {
		estadoProductoRepository.delete(estadoProducto);
		
	}

	@Override
	public EstadoProducto get(int estadoProductoId) {
		return estadoProductoRepository.getOne(estadoProductoId);
	}

	@Override
	public List<EstadoProducto> list() {
		return estadoProductoRepository.findAll();
	}

	@Override
	public boolean add(EstadoProducto estadoProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EstadoProducto estadoProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(EstadoProducto estadoProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<EstadoProducto> buscarTodas(Pageable page) {
		return estadoProductoRepository.findAll(page);
	}

	@Override
	public List<EstadoProducto> buscarTodas() {
		return estadoProductoRepository.findAll();
	}

}
