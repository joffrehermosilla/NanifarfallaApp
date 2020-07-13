package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Linea;

@Repository
public interface LineaRepository extends JpaRepository<Linea, Integer> {

}
