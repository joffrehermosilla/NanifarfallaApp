package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaTipoInsumo;

@Repository
public interface AuditoriaTipoInsumoRepository extends JpaRepository<AuditoriaTipoInsumo, Integer> {

}
