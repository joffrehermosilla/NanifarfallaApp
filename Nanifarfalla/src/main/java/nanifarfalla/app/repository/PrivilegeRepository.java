package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Privilege;


@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege, Integer> {
	Privilege findByName(String name);

	@Override
	void delete(Privilege privilege);
}
