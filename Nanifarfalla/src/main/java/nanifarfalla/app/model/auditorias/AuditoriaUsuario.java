package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_usuario")
public class AuditoriaUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_usuario;
	String usuario;
	Date fecha_cambio;
	String nombre_usuario_old;
	String apellido_usuario_old;
	Date fecha_nacimiento_usuario_old;
	String direccion_usuario_old;
	String nombre_logeo_usuario_old;
	String password_usuario_old;
	String email_old;
	String ruta_foto_old;
	int enabled_old;
	int isUsing2FA_old;
	int fkcodigo_distrito_old;
	int fkcodigo_tipousuario_old;
	int fkcodigo_estadousuario_old;
	Date version_old;
	String nombre_usuario_new;
	String apellido_usuario_new;
	Date fecha_nacimiento_usuario_new;
	String direccion_usuario_new;
	String nombre_logeo_usuario_new;
	String password_usuario_new;
	String email_new;
	String ruta_foto_new;
	int enabled_new;
	int isUsing2FA_new;
	int fkcodigo_distrito_new;
	int fkcodigo_tipousuario_new;
	int fkcodigo_estadousuario_new;
	Date version_new;

	public AuditoriaUsuario() {

	}

	public int getCodigo_audi_usuario() {
		return codigo_audi_usuario;
	}

	public void setCodigo_audi_usuario(int codigo_audi_usuario) {
		this.codigo_audi_usuario = codigo_audi_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFecha_cambio() {
		return fecha_cambio;
	}

	public void setFecha_cambio(Date fecha_cambio) {
		this.fecha_cambio = fecha_cambio;
	}

	public String getNombre_usuario_old() {
		return nombre_usuario_old;
	}

	public void setNombre_usuario_old(String nombre_usuario_old) {
		this.nombre_usuario_old = nombre_usuario_old;
	}

	public String getApellido_usuario_old() {
		return apellido_usuario_old;
	}

	public void setApellido_usuario_old(String apellido_usuario_old) {
		this.apellido_usuario_old = apellido_usuario_old;
	}

	public Date getFecha_nacimiento_usuario_old() {
		return fecha_nacimiento_usuario_old;
	}

	public void setFecha_nacimiento_usuario_old(Date fecha_nacimiento_usuario_old) {
		this.fecha_nacimiento_usuario_old = fecha_nacimiento_usuario_old;
	}

	public String getDireccion_usuario_old() {
		return direccion_usuario_old;
	}

	public void setDireccion_usuario_old(String direccion_usuario_old) {
		this.direccion_usuario_old = direccion_usuario_old;
	}

	public String getNombre_logeo_usuario_old() {
		return nombre_logeo_usuario_old;
	}

	public void setNombre_logeo_usuario_old(String nombre_logeo_usuario_old) {
		this.nombre_logeo_usuario_old = nombre_logeo_usuario_old;
	}

	public String getPassword_usuario_old() {
		return password_usuario_old;
	}

	public void setPassword_usuario_old(String password_usuario_old) {
		this.password_usuario_old = password_usuario_old;
	}

	public String getEmail_old() {
		return email_old;
	}

	public void setEmail_old(String email_old) {
		this.email_old = email_old;
	}

	public String getRuta_foto_old() {
		return ruta_foto_old;
	}

	public void setRuta_foto_old(String ruta_foto_old) {
		this.ruta_foto_old = ruta_foto_old;
	}

	public int getEnabled_old() {
		return enabled_old;
	}

	public void setEnabled_old(int enabled_old) {
		this.enabled_old = enabled_old;
	}

	public int getIsUsing2FA_old() {
		return isUsing2FA_old;
	}

	public void setIsUsing2FA_old(int isUsing2FA_old) {
		this.isUsing2FA_old = isUsing2FA_old;
	}

	public int getFkcodigo_distrito_old() {
		return fkcodigo_distrito_old;
	}

	public void setFkcodigo_distrito_old(int fkcodigo_distrito_old) {
		this.fkcodigo_distrito_old = fkcodigo_distrito_old;
	}

	public int getFkcodigo_tipousuario_old() {
		return fkcodigo_tipousuario_old;
	}

	public void setFkcodigo_tipousuario_old(int fkcodigo_tipousuario_old) {
		this.fkcodigo_tipousuario_old = fkcodigo_tipousuario_old;
	}

	public int getFkcodigo_estadousuario_old() {
		return fkcodigo_estadousuario_old;
	}

	public void setFkcodigo_estadousuario_old(int fkcodigo_estadousuario_old) {
		this.fkcodigo_estadousuario_old = fkcodigo_estadousuario_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getNombre_usuario_new() {
		return nombre_usuario_new;
	}

	public void setNombre_usuario_new(String nombre_usuario_new) {
		this.nombre_usuario_new = nombre_usuario_new;
	}

	public String getApellido_usuario_new() {
		return apellido_usuario_new;
	}

	public void setApellido_usuario_new(String apellido_usuario_new) {
		this.apellido_usuario_new = apellido_usuario_new;
	}

	public Date getFecha_nacimiento_usuario_new() {
		return fecha_nacimiento_usuario_new;
	}

	public void setFecha_nacimiento_usuario_new(Date fecha_nacimiento_usuario_new) {
		this.fecha_nacimiento_usuario_new = fecha_nacimiento_usuario_new;
	}

	public String getDireccion_usuario_new() {
		return direccion_usuario_new;
	}

	public void setDireccion_usuario_new(String direccion_usuario_new) {
		this.direccion_usuario_new = direccion_usuario_new;
	}

	public String getNombre_logeo_usuario_new() {
		return nombre_logeo_usuario_new;
	}

	public void setNombre_logeo_usuario_new(String nombre_logeo_usuario_new) {
		this.nombre_logeo_usuario_new = nombre_logeo_usuario_new;
	}

	public String getPassword_usuario_new() {
		return password_usuario_new;
	}

	public void setPassword_usuario_new(String password_usuario_new) {
		this.password_usuario_new = password_usuario_new;
	}

	public String getEmail_new() {
		return email_new;
	}

	public void setEmail_new(String email_new) {
		this.email_new = email_new;
	}

	public String getRuta_foto_new() {
		return ruta_foto_new;
	}

	public void setRuta_foto_new(String ruta_foto_new) {
		this.ruta_foto_new = ruta_foto_new;
	}

	public int getEnabled_new() {
		return enabled_new;
	}

	public void setEnabled_new(int enabled_new) {
		this.enabled_new = enabled_new;
	}

	public int getIsUsing2FA_new() {
		return isUsing2FA_new;
	}

	public void setIsUsing2FA_new(int isUsing2FA_new) {
		this.isUsing2FA_new = isUsing2FA_new;
	}

	public int getFkcodigo_distrito_new() {
		return fkcodigo_distrito_new;
	}

	public void setFkcodigo_distrito_new(int fkcodigo_distrito_new) {
		this.fkcodigo_distrito_new = fkcodigo_distrito_new;
	}

	public int getFkcodigo_tipousuario_new() {
		return fkcodigo_tipousuario_new;
	}

	public void setFkcodigo_tipousuario_new(int fkcodigo_tipousuario_new) {
		this.fkcodigo_tipousuario_new = fkcodigo_tipousuario_new;
	}

	public int getFkcodigo_estadousuario_new() {
		return fkcodigo_estadousuario_new;
	}

	public void setFkcodigo_estadousuario_new(int fkcodigo_estadousuario_new) {
		this.fkcodigo_estadousuario_new = fkcodigo_estadousuario_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
