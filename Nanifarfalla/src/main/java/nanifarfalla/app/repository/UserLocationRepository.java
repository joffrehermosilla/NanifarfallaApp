package nanifarfalla.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import nanifarfalla.app.model.UserLocation;
import nanifarfalla.app.model.Usuario;

public interface UserLocationRepository extends JpaRepository<UserLocation, Long> {
    UserLocation findByCountryAndUser(String country, Usuario user);

}
