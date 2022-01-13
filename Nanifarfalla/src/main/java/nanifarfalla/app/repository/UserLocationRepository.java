package nanifarfalla.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.UserLocation;
import nanifarfalla.app.model.Usuario;
@Repository
public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, Usuario user);

}
