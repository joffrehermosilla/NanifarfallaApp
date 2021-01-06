package nanifarfalla.app.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Pais;
import nanifarfalla.app.model.Provincia;

import nanifarfalla.app.repository.ProvinciaRepository;
import nanifarfalla.app.service.IPaisService;
import nanifarfalla.app.service.IProvinciaService;

@Service
public class ProvinciaServiceJPA implements IProvinciaService {
	@Autowired
	ProvinciaRepository provinciaRepository;

	@Autowired
	private IPaisService paisService;

	@Override
	public List<Provincia> buscarTodas() {
		// TODO Auto-generated method stub
		return provinciaRepository.findAll();
	}

	@Override
	public List<Provincia> findByPais(int idPais) {
	
		Provincia provincia = new Provincia();
       List <Provincia> provinciaxpais=provinciaRepository.findAll();
		if (provincia.getmPais().getCodigo_pais() == idPais) {
			for (int i = 0; i < paisService.buscarTodas().size(); i++) {
				provinciaxpais.get(i).setNombre_provincia(provincia.getNombre_provincia());
			}
		}

		return provinciaxpais;
	

	}

}
