package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaLinea;
@Repository
public interface AuditoriaLineaRepository extends JpaRepository<AuditoriaLinea, Integer> {

}
