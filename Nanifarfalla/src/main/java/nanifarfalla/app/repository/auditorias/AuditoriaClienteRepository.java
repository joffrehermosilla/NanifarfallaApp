package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaCliente;


@Repository
public interface AuditoriaClienteRepository extends JpaRepository<AuditoriaCliente, Integer> {

}
