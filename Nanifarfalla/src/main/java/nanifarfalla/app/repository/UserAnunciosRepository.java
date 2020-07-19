package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.UserAnuncios;

@Repository
public interface UserAnunciosRepository extends JpaRepository<UserAnuncios, Integer> {

}
