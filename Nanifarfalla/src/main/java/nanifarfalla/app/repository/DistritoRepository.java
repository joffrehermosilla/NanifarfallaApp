package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Distrito;


@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Integer> {

}
