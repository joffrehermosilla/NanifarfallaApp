package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaVendedor;


@Repository
public interface AuditoriaVendedorRepository extends JpaRepository<AuditoriaVendedor, Integer> {

}
