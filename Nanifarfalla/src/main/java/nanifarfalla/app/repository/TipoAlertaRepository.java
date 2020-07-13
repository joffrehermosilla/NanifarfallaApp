package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.TipoAlerta;

@Repository
public interface TipoAlertaRepository extends JpaRepository<TipoAlerta, Integer> {

}
