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
	@Transactional(readOnly = true)
	public List<Provincia> findByPaisIdParamsNative(int idPais) {

		return provinciaRepository.findByPaisIdParamsNative(idPais);

	}

}
