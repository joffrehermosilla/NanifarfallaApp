package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.TipoProducto;
import nanifarfalla.app.repository.TipoProductoRepository;
import nanifarfalla.app.service.ITipoProductoService;

@Service
public class TipoProductoServiceJPA implements ITipoProductoService{

	@Autowired
	TipoProductoRepository tipoProductoRepository;
	
	@Override
	public void inserta(TipoProducto tipoProducto) {
		tipoProductoRepository.save(tipoProducto);
		
	}

	@Override
	public void actualiza(TipoProducto tipoProducto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(TipoProducto tipoProducto) {
		tipoProductoRepository.delete(tipoProducto);
		
	}

	@Override
	public TipoProducto get(int tipoProductoId) {
		return tipoProductoRepository.getOne(tipoProductoId);
	}

	@Override
	public List<TipoProducto> list() {
		return tipoProductoRepository.findAll();
	}

	@Override
	public boolean add(TipoProducto tipoProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TipoProducto tipoProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TipoProducto tipoProducto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<TipoProducto> buscarTodas(Pageable page) {
		return tipoProductoRepository.findAll(page);
	}

	@Override
	public List<TipoProducto> buscarTodas() {
		return tipoProductoRepository.findAll();
	}

}
