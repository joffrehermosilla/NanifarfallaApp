package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nanifarfalla.app.model.EstadoCatalogo;

public interface EstadoCatalogoRepository extends JpaRepository<EstadoCatalogo, Integer> {

}
