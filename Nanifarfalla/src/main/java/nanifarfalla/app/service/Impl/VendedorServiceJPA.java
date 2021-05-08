package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Vendedor;
import nanifarfalla.app.repository.VendedorRepository;
import nanifarfalla.app.service.IVendedorService;

@Service
public class VendedorServiceJPA implements IVendedorService {

	@Autowired
	VendedorRepository vendedorRepository;

	@Override
	public List<Vendedor> buscarTodas() {

		return vendedorRepository.findAll();
	}

	@Override
	public void guardar(Vendedor vendedor) {

		vendedorRepository.save(vendedor);
	}

}
