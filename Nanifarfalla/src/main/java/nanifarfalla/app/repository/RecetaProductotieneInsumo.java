package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaProductotieneInsumo extends JpaRepository<RecetaProductotieneInsumo, Integer> {

}
