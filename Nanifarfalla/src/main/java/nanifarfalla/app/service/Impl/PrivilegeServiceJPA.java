package nanifarfalla.app.service.Impl;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Privilege;
import nanifarfalla.app.repository.PrivilegeRepository;
import nanifarfalla.app.service.IPrivelegeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



@Service
public class PrivilegeServiceJPA implements IPrivelegeService {

	@Autowired
	PrivilegeRepository privilegerepository;
	
	
	@Override
	public void inserta(Privilege privelege) {
		// TODO Auto-generated method stub
		
		privilegerepository.save(privelege);
		
	}

	@Override
	public void actualiza(Privilege privelege) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void elimina(Privilege privelege) {
		// TODO Auto-generated method stub
		
		privilegerepository.delete(privelege);
		
	}

	@Override
	public Privilege get(int privelegeId) {
		// TODO Auto-generated method stub
		return privilegerepository.getOne(privelegeId);
	}

	@Override
	public List<Privilege> list() {
		// TODO Auto-generated method stub
		return privilegerepository.findAll();
	}

	@Override
	public boolean add(Privilege privelege) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Privilege privelege) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Privilege privelege) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Privilege> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return privilegerepository.findAll(page);
	}

	@Override
	public List<Privilege> buscarTodas() {
		// TODO Auto-generated method stub
		return privilegerepository.findAll();
	}

}
