package nanifarfalla.app.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import nanifarfalla.app.model.Provincia;
import nanifarfalla.app.repository.PaisRepository;
import nanifarfalla.app.repository.ProvinciaRepository;
import nanifarfalla.app.service.IProvinciaService;

@Service
public class ProvinciaServiceJPA implements IProvinciaService {
	@Autowired
	ProvinciaRepository provinciaRepository;

	@Autowired
	PaisRepository paisRepository;

	public ProvinciaServiceJPA(PaisRepository paisRepository, ProvinciaRepository provinciaRepository) {
		this.paisRepository = paisRepository;
		this.provinciaRepository = provinciaRepository;

	}

	@Override
	public List<Provincia> buscarTodas() {
		// TODO Auto-generated method stub
		return provinciaRepository.findAll();
	}

	@Override
	public List<Provincia> findByPaisIdParamsNative(int idPais) {

		return provinciaRepository.findByPaisIdParamsNative(idPais);

	}
	
	@Override
	public List<Provincia> findByFkcodigo_pais(int codigo_pais) {
		// TODO Auto-generated method stub
		return provinciaRepository.findByFkcodigo_pais(codigo_pais);
	}

	@Override
	public List<Provincia> findByCountry(int id) {
		// TODO Auto-generated method stub
		return provinciaRepository.findByCountry(id);
	}

	@Override
	public List<Provincia> BuscaPaisporClase(int id) {
		// TODO Auto-generated method stub
		return provinciaRepository.BuscaPaisporClase(id);
	}

	@Override
	public List<Provincia> BuscarPaisClaseconParam(int codig_pais) {
		// TODO Auto-generated method stub
		return provinciaRepository.BuscarPaisClaseconParam(codig_pais);
	}

}
