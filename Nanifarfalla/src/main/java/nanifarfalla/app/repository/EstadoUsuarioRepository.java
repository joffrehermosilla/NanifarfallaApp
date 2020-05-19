package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import nanifarfalla.app.model.EstadoUsuario;

public interface EstadoUsuarioRepository extends JpaRepository<EstadoUsuario, Integer> {

}
