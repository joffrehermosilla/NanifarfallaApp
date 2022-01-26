package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Pais;
import nanifarfalla.app.repository.PaisRepository;
import nanifarfalla.app.service.IPaisService;

@Service
public class PaisServiceJPA implements IPaisService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(PaisServiceJPA.class);
	
	@Autowired
	PaisRepository paisrepository;

	@Override
	public void inserta(Pais pais) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		pais.setVersion(timestamp);
		
		paisrepository.save(pais);
	}

	@Override
	public void actualiza(Pais pais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(Pais pais) {
		paisrepository.delete(pais);
	}

	@Override
	public Pais get(int paisId) {
		return paisrepository.getOne(paisId);
	}

	@Override
	public List<Pais> list() {
		return paisrepository.findAll();
	}

	@Override
	public boolean add(Pais pais) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Pais pais) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Pais pais) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Pais> buscarTodas(Pageable page) {
		return paisrepository.findAll(page);
	}

	@Override
	public List<Pais> buscarTodas() {
		return paisrepository.findAll();
	}

	@Override
	public void eliminar(int idPais) {
		paisrepository.deleteById(idPais);		
	}

	@Override
	public Optional<Pais> buscarporId(int id) {		
		return paisrepository.findById(id);
	}




}
