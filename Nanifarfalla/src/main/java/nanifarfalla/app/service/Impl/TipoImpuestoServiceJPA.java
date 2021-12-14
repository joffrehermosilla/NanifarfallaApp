package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.TipoImpuesto;
import nanifarfalla.app.repository.TipoImpuestoRepository;
import nanifarfalla.app.service.ITipoImpuesto;



@Service
public class TipoImpuestoServiceJPA implements ITipoImpuesto {
	
	@Autowired
	TipoImpuestoRepository tipoimpuestorepository;
	
	

	@Override
	public void inserta(TipoImpuesto tipoimpuesto) {
		// TODO Auto-generated method stub
		
		tipoimpuestorepository.save(tipoimpuesto);
		
	}

	@Override
	public void actualiza(TipoImpuesto tipoimpuesto) {
		// TODO Auto-generated method stub
		
	
		
	}

	@Override
	public void elimina(TipoImpuesto tipoimpuesto) {
		// TODO Auto-generated method stub
		
		tipoimpuestorepository.delete(tipoimpuesto);
		
	}

	@Override
	public TipoImpuesto get(int TipoImpuestoId) {
		// TODO Auto-generated method stub
		return tipoimpuestorepository.getOne(TipoImpuestoId);
	}

	@Override
	public List<TipoImpuesto> list() {
		// TODO Auto-generated method stub
		return tipoimpuestorepository.findAll();
	}

	@Override
	public boolean add(TipoImpuesto tipoimpuesto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(TipoImpuesto tipoimpuesto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(TipoImpuesto tipoimpuesto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<TipoImpuesto> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return tipoimpuestorepository.findAll(page);
	}

	@Override
	public List<TipoImpuesto> buscarTodas() {
		// TODO Auto-generated method stub
		return tipoimpuestorepository.findAll();
	}

}
