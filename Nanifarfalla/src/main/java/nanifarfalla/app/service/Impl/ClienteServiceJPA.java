package nanifarfalla.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nanifarfalla.app.model.Cliente;
import nanifarfalla.app.repository.ClienteRepository;
import nanifarfalla.app.service.IClienteService;

@Service
public class ClienteServiceJPA implements IClienteService {
 
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		
		return clienteRepository.findAll();
	}



	@Override
	public void inserta(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

}
