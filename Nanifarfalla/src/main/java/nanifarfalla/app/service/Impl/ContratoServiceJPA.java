package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Contrato;
import nanifarfalla.app.repository.ContratoRepository;
import nanifarfalla.app.service.IContratoService;

@Service
public class ContratoServiceJPA implements IContratoService {

	@Autowired
	ContratoRepository contratoRepositor;

	@Override
	public void guardar(Contrato contrato) {

		contratoRepositor.save(contrato);

	}

	@Override
	public List<Contrato> buscartodos() {

		return contratoRepositor.findAll();
	}

}
