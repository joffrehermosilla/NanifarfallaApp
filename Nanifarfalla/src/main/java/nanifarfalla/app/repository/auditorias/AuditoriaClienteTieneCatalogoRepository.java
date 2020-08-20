package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaClienteTieneCatalogo;

@Repository
public interface AuditoriaClienteTieneCatalogoRepository extends JpaRepository<AuditoriaClienteTieneCatalogo, Integer> {

}
