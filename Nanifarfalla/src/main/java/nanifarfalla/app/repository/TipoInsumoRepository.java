package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.TipoInsumo;

@Repository
public interface TipoInsumoRepository extends JpaRepository<TipoInsumo, Integer> {

}
