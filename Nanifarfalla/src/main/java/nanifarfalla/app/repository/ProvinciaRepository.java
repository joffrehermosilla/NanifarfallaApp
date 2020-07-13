package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {

}
