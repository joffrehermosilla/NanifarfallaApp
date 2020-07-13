package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.PresentacionInsumo;
@Repository
public interface PresentacionInsumoRepository extends JpaRepository<PresentacionInsumo, Integer> {

}
