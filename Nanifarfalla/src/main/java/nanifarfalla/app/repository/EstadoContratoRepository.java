package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.EstadoContrato;



@Repository
public interface EstadoContratoRepository extends JpaRepository<EstadoContrato, Integer> {

}
