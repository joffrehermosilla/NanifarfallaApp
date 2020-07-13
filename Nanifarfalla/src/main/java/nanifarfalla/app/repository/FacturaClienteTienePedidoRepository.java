package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.FacturaClienteTienePedido;

@Repository
public interface FacturaClienteTienePedidoRepository extends JpaRepository<FacturaClienteTienePedido, Integer> {

}
