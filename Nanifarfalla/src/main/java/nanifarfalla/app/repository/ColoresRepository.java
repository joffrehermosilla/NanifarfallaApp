package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Colores;
@Repository
public interface ColoresRepository extends JpaRepository<Colores, Integer> {

}
