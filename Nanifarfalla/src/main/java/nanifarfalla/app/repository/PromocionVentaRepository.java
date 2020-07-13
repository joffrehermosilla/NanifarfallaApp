package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.PromocionVenta;


@Repository
public interface PromocionVentaRepository extends JpaRepository<PromocionVenta, Integer> {

}
