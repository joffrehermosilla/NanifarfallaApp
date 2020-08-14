package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.auditorias.AuditoriaProductoxPedido;



@Repository
public interface AuditoriaProductoxPedidoRepository extends JpaRepository<AuditoriaProductoxPedido, Integer> {

}
