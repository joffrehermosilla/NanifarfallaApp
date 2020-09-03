package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaMenuV1;

@Repository
public interface AuditoriaMenuV1Repository extends JpaRepository<AuditoriaMenuV1, Integer> {

}
