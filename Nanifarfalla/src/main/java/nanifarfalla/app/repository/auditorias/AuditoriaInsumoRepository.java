package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaInsumo;

@Repository
public interface AuditoriaInsumoRepository extends JpaRepository<AuditoriaInsumo, Integer> {

}
