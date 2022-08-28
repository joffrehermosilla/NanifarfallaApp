package nanifarfalla.app.service.Impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import nanifarfalla.app.model.Role;
import nanifarfalla.app.repository.RoleRepository;
import nanifarfalla.app.service.IRoleService;

@Service
public class RoleServiceJPA implements IRoleService {

	@Autowired
	RoleRepository rolerepository;

	@Override
	public void inserta(Role role) {
		// TODO Auto-generated method stub
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		role.setVersion(timestamp);
		Long id = (long) 0;
		role.setId(id);
		rolerepository.save(role);
	}

	@Override
	public void actualiza(Role role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void elimina(Role role) {
		// TODO Auto-generated method stub
		rolerepository.delete(role);
	}

	@Override
	public Role get(int roleId) {
		// TODO Auto-generated method stub
		return rolerepository.getOne(roleId);
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return rolerepository.findAll();
	}

	@Override
	public boolean add(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Role role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Page<Role> buscarTodas(Pageable page) {
		// TODO Auto-generated method stub
		return rolerepository.findAll(page);
	}

	@Override
	public List<Role> buscarTodas() {
		// TODO Auto-generated method stub
		return rolerepository.findAll();
	}

	@Override
	public void eliminar(int idRole) {
		// TODO Auto-generated method stub
		rolerepository.deleteById(idRole);
	}

	@Override
	public Optional<Role> buscarporId(int id) {
		// TODO Auto-generated method stub
		return rolerepository.findById(id);
	}

}
