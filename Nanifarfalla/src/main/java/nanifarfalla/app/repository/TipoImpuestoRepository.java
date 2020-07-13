package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.TipoImpuesto;


@Repository
public interface TipoImpuestoRepository  extends JpaRepository<TipoImpuesto, Integer>{

}
