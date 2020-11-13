package nanifarfalla.app.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import nanifarfalla.app.web.dto.UserDto;
import nanifarfalla.app.web.error.UserAlreadyExistException;

import nanifarfalla.app.model.PasswordRessetToken;
import nanifarfalla.app.model.Usuario;
import nanifarfalla.app.model.VerificationToken;


public interface IUserService {

    Usuario registerNewUserAccount(UserDto accountDto) throws UserAlreadyExistException;

    Usuario getUser(String verificationToken);

    void saveRegisteredUser(Usuario user);

    void deleteUser(Usuario user);

    void createVerificationTokenForUser(Usuario user, String token);

    VerificationToken getVerificationToken(String VerificationToken);

    VerificationToken generateNewVerificationToken(String token);

    void createPasswordResetTokenForUser(Usuario user, String token);

    Usuario findUserByEmail(String email);

    PasswordRessetToken getPasswordResetToken(String token);

    Usuario getUserByPasswordResetToken(String token);

    Optional<Usuario> getUserByID(int id);

    void changeUserPassword(Usuario user, String password);

    boolean checkIfValidOldPassword(Usuario user, String password);

    String validateVerificationToken(String token);

    String generateQRUrl(Usuario user) throws UnsupportedEncodingException;

    Usuario updateUser2FA(boolean use2FA);

    List<String> getUsersFromSessionRegistry();
    
	List<Usuario> buscarTodas();
	
	void guardar(Usuario usuario);

}
