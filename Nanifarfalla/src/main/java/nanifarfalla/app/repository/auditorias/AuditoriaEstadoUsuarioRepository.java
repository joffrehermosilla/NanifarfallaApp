package nanifarfalla.app.repository.auditorias;

import org.springframework.data.jpa.repository.JpaRepository;

import nanifarfalla.app.model.auditorias.AuditoriaEstadoUsuario;

public interface AuditoriaEstadoUsuarioRepository extends JpaRepository<AuditoriaEstadoUsuario, Integer> {

}
