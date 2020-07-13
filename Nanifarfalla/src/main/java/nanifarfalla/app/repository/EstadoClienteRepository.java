package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.EstadoCliente;


@Repository
public interface EstadoClienteRepository extends JpaRepository<EstadoCliente, Integer> {

}
