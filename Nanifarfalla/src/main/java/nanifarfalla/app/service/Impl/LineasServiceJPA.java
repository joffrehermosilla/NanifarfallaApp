package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Linea;
import nanifarfalla.app.model.Producto;
import nanifarfalla.app.repository.LineaRepository;
import nanifarfalla.app.service.ILineasService;

@Service
public class LineasServiceJPA implements ILineasService {

	@Autowired
	private LineaRepository linearepository;
	
	@Override
	public List<Linea> buscarTodas() {
		// TODO Auto-generated method stub
		return linearepository.findAll();
	}

	@Override
	public Linea buscarPorId(int idLinea) {
		// TODO Auto-generated method stub
		return  null;
	}

	@Override
	public void inserta(Linea linea) {
	
		linearepository.save(linea);
	}

	@Override
	public Linea get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Linea> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Linea category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Linea category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Linea category) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Producto> findProductobyLineaIdParamsNative(int idLinea) {
		// TODO Auto-generated method stub
		return linearepository.findProductobyLineaIdParamsNative(idLinea);
	}

	@Override
	public List<Linea> findBycodigo_linea(int codigo_linea) {
		// TODO Auto-generated method stub
		return linearepository.findBycodigo_linea(codigo_linea);
	}

	@Override
	public List<Linea> findByid_linea(int id) {
		// TODO Auto-generated method stub
		return linearepository.findByid_linea(id);
	}

}