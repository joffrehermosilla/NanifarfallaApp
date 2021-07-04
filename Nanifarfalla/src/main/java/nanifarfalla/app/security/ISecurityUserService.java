package nanifarfalla.app.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);
    
    String validatePasswordResetToken(String token);

}
