package nanifarfalla.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.PasswordRessetToken;


@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordRessetToken, Integer> {

}
