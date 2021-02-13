package nanifarfalla.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import nanifarfalla.app.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {
	Usuario findByEmail(String email);

	@Override
	void delete(Usuario user);
	
	@Query(value = "select * from usuario u where u.email = ?1", nativeQuery = true)
	 List<Usuario>  findByCorreo(String email);
	
	
	@Query("select u from Usuario u where u.email like :email")
	 List<Usuario>  BuscarEmailParam(@Param("email") String email);

}
