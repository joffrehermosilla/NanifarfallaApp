package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.Anuncio;


@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

}
