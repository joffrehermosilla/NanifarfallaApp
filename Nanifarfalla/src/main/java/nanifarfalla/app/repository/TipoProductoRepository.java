package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.TipoProducto;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProducto, Integer> {

}
