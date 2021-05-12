package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query(value = "select c.codigo_cliente from cliente c order by codigo_cliente DESC LIMIT 1", nativeQuery = true)
	int lastcode();
}
