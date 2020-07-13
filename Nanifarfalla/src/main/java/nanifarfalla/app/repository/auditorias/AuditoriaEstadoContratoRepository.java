package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaEstadoContrato;
@Repository
public interface AuditoriaEstadoContratoRepository extends JpaRepository<AuditoriaEstadoContrato, Integer> {

}
