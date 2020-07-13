package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.ElaboracionProducto;
@Repository
public interface ElaboracionProductoRepository extends JpaRepository<ElaboracionProducto, Integer> {

}
