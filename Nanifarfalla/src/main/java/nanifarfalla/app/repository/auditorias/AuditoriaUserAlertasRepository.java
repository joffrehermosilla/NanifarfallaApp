package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaUserAlertas;

@Repository
public interface AuditoriaUserAlertasRepository extends JpaRepository<AuditoriaUserAlertas, Integer> {

}
