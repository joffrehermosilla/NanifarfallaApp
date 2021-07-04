package nanifarfalla.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import nanifarfalla.app.model.NewLocationToken;
import nanifarfalla.app.model.UserLocation;

public interface NewLocationTokenRepository extends JpaRepository<NewLocationToken, Long> {

    NewLocationToken findByToken(String token);

    NewLocationToken findByUserLocation(UserLocation userLocation);

}
