package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Pais;
import nanifarfalla.app.repository.PaisRepository;
import nanifarfalla.app.service.IPaisService;

@Service
public class PaisServiceJPA implements IPaisService {
	@Autowired
	PaisRepository paisrepository;

	@Override
	public List<Pais> buscarTodas() {
		// TODO Auto-generated method stub
		return paisrepository.findAll();
	}

}
