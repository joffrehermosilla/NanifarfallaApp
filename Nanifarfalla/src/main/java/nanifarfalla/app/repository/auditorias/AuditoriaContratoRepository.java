package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaContrato;

@Repository
public interface AuditoriaContratoRepository extends JpaRepository<AuditoriaContrato, Integer> {

}
