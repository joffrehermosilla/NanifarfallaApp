package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

	@Query(value = "select c.codigo_contrato from contrato c order by codigo_contrato DESC LIMIT 1", nativeQuery = true)
	int lastcode();
	
	
}
