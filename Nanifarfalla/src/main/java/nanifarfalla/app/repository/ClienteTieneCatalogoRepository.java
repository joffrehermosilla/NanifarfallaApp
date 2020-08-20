package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.ClienteTieneCatalogo;

@Repository
public interface ClienteTieneCatalogoRepository extends JpaRepository<ClienteTieneCatalogo, Integer> {

}
