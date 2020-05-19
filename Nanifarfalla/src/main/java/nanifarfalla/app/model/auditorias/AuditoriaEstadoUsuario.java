package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_estadousuario")
public class AuditoriaEstadoUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_estadousuario;
	String usuario;
    Date fecha_cambio;
    String nombre_estadousuario_old;
    Date version_old;
    String nombre_estadousuario_new;
    Date version_new;
    
	
    public AuditoriaEstadoUsuario() {
	
	}
	public int getCodigo_audi_estadousuario() {
		return codigo_audi_estadousuario;
	}
	public void setCodigo_audi_estadousuario(int codigo_audi_estadousuario) {
		this.codigo_audi_estadousuario = codigo_audi_estadousuario;
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
	public String getNombre_estadousuario_old() {
		return nombre_estadousuario_old;
	}
	public void setNombre_estadousuario_old(String nombre_estadousuario_old) {
		this.nombre_estadousuario_old = nombre_estadousuario_old;
	}
	public Date getVersion_old() {
		return version_old;
	}
	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}
	public String getNombre_estadousuario_new() {
		return nombre_estadousuario_new;
	}
	public void setNombre_estadousuario_new(String nombre_estadousuario_new) {
		this.nombre_estadousuario_new = nombre_estadousuario_new;
	}
	public Date getVersion_new() {
		return version_new;
	}
	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

    
}
