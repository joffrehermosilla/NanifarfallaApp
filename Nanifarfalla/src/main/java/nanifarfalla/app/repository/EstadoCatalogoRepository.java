package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.EstadoCatalogo;
@Repository
public interface EstadoCatalogoRepository extends JpaRepository<EstadoCatalogo, Integer> {

}
