package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

}
