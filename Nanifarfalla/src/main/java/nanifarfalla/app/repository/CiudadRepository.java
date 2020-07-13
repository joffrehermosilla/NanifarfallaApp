package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Ciudad;


@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

}
