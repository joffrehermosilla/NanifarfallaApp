package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.ClienteTienePreferencia;

@Repository
public interface ClienteTienePreferenciaRepository extends JpaRepository<ClienteTienePreferencia, Integer> {

}
