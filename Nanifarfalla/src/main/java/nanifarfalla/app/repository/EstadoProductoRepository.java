package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.EstadoProducto;
@Repository
public interface EstadoProductoRepository extends JpaRepository<EstadoProducto, Integer>{

}
