package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.RecetaProductoTieneInsumo;


@Repository
public interface RecetaProductoTieneInsumoRepository extends JpaRepository<RecetaProductoTieneInsumo, Integer> {

}
