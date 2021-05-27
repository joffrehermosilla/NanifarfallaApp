package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.MenuV1;

@Repository
public interface MenuV1Repository extends JpaRepository<MenuV1, Integer> {
	@Query(value = "select m.id from menu_v1 m order by id DESC LIMIT 1", nativeQuery = true)
	int lastcode();


	@Modifying
	@Query("update MenuV1 m set m.nombre=:name  where m.id=:id")
	void updatemenu(@Param("name")String name, @Param("id")int id);
	
	
}
