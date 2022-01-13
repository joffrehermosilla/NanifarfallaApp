package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.EstadoUsuario;

@Repository
public interface EstadoUsuarioRepository extends JpaRepository<EstadoUsuario, Integer> {

}
