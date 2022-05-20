package nanifarfalla.app.service.Impl;

import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Privilege;
import nanifarfalla.app.repository.PrivilegeRepository;
import nanifarfalla.app.service.IPrivelegeService;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		privelege.setVersion(timestamp);
		privilegerepository.save(privelege);

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
	public Page<Privilege> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return privilegerepository.findAll(page);
	}

	@Override
	public List<Privilege> buscarTodas() {
		// TODO Auto-generated method stub
		return privilegerepository.findAll();
	}

	@Override
	public void eliminar(int privelegeId) {
		// TODO Auto-generated method stub
		privilegerepository.findById(privelegeId);

	}

	@Override
	public Optional<Privilege> buscarporId(int id) {
		// TODO Auto-generated method stub
		return privilegerepository.findById(id);
	}

}
