package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.EstadoInsumo;
@Repository
public interface EstadoInsumoRepository extends JpaRepository<EstadoInsumo, Integer> {

}
