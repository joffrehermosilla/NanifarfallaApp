package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaClienteTienePedido;

@Repository
public interface AuditoriaClienteTienePedidoRepository extends JpaRepository<AuditoriaClienteTienePedido, Integer> {

}
