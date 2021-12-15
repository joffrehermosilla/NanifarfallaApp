package nanifarfalla.app.service.Impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.RegimenCliente;
import nanifarfalla.app.repository.RegimenClienteRepository;
import nanifarfalla.app.service.IRegimenCliente;


@Service
public class RegimenClienteServiceJPA implements IRegimenCliente{

	@Autowired
    RegimenClienteRepository regimenclienterepository;
	
	
	@Override
	public void inserta(RegimenCliente regimencliente) {
		// TODO Auto-generated method stub
		
		regimenclienterepository.save(regimencliente);
		
	}

	@Override
	public void actualiza(RegimenCliente regimencliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(RegimenCliente regimencliente) {
		// TODO Auto-generated method stub
		regimenclienterepository.delete(regimencliente);
		
	}

	@Override
	public RegimenCliente get(int regimenclienteId) {
		// TODO Auto-generated method stub
		return regimenclienterepository.getOne(regimenclienteId);
	}

	@Override
	public List<RegimenCliente> list() {
		// TODO Auto-generated method stub
		return regimenclienterepository.findAll();
	}

	@Override
	public boolean add(RegimenCliente regimencliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(RegimenCliente regimencliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(RegimenCliente regimencliente) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<RegimenCliente> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return regimenclienterepository.findAll(page);
	}

	@Override
	public List<RegimenCliente> buscarTodas() {
		// TODO Auto-generated method stub
		return regimenclienterepository.findAll();
	}

}
