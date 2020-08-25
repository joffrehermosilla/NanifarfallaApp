package nanifarfalla.app.repository;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nanifarfalla.app.model.PasswordRessetToken;
import nanifarfalla.app.model.Usuario;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordRessetToken, Integer> {
	PasswordRessetToken findByToken(String token);

	PasswordRessetToken findByUser(Usuario user);

	Stream<PasswordRessetToken> findAllByExpiryDateLessThan(Date now);

	void deleteByExpiryDateLessThan(Date now);

	@Modifying
	@Query("delete from PasswordRessetToken t where t.expiryDate <= ?1")
	void deleteAllExpiredSince(Date now);
}
