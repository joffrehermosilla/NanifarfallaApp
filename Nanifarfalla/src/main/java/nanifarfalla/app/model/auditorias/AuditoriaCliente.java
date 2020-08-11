package nanifarfalla.app.model.auditorias;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auditoria_cliente")
public class AuditoriaCliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_audi_cliente;
	String usuario;
	Date fecha_cambio;
	String razonsocial_cliente_old;
	String mensaje_cliente_old;
	int fkcodigo_usuario_old;
	int fkcodigo_regimen_cliente_old;
	int fkcodigo_estado_cliente_old;
	Double latitud_cliente_old;
	Double longitud_cliente_old;
	String type_cliente_old;
	String foto_ubicacion_cliente_old;
	String ruc_cliente_old;
	String dni_cliente_old;
	Date fecha_empadronamiento_cliente_old;
	String claveApi_old;
	Date version_old;
	String razonsocial_cliente_new;
	String mensaje_cliente_new;
	int fkcodigo_usuario_new;
	int fkcodigo_regimen_cliente_new;
	int fkcodigo_estado_cliente_new;
	Double latitud_cliente_new;
	Double longitud_cliente_new;
	String type_cliente_new;
	String foto_ubicacion_cliente_new;
	String ruc_cliente_new;
	String dni_cliente_new;
	Date fecha_empadronamiento_cliente_new;
	String claveApi_new;
	Date version_new;

	public AuditoriaCliente() {

	}

	public int getCodigo_audi_cliente() {
		return codigo_audi_cliente;
	}

	public void setCodigo_audi_cliente(int codigo_audi_cliente) {
		this.codigo_audi_cliente = codigo_audi_cliente;
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

	public String getRazonsocial_cliente_old() {
		return razonsocial_cliente_old;
	}

	public void setRazonsocial_cliente_old(String razonsocial_cliente_old) {
		this.razonsocial_cliente_old = razonsocial_cliente_old;
	}

	public String getMensaje_cliente_old() {
		return mensaje_cliente_old;
	}

	public void setMensaje_cliente_old(String mensaje_cliente_old) {
		this.mensaje_cliente_old = mensaje_cliente_old;
	}

	public int getFkcodigo_usuario_old() {
		return fkcodigo_usuario_old;
	}

	public void setFkcodigo_usuario_old(int fkcodigo_usuario_old) {
		this.fkcodigo_usuario_old = fkcodigo_usuario_old;
	}

	public int getFkcodigo_regimen_cliente_old() {
		return fkcodigo_regimen_cliente_old;
	}

	public void setFkcodigo_regimen_cliente_old(int fkcodigo_regimen_cliente_old) {
		this.fkcodigo_regimen_cliente_old = fkcodigo_regimen_cliente_old;
	}

	public int getFkcodigo_estado_cliente_old() {
		return fkcodigo_estado_cliente_old;
	}

	public void setFkcodigo_estado_cliente_old(int fkcodigo_estado_cliente_old) {
		this.fkcodigo_estado_cliente_old = fkcodigo_estado_cliente_old;
	}

	public Double getLatitud_cliente_old() {
		return latitud_cliente_old;
	}

	public void setLatitud_cliente_old(Double latitud_cliente_old) {
		this.latitud_cliente_old = latitud_cliente_old;
	}

	public Double getLongitud_cliente_old() {
		return longitud_cliente_old;
	}

	public void setLongitud_cliente_old(Double longitud_cliente_old) {
		this.longitud_cliente_old = longitud_cliente_old;
	}

	public String getType_cliente_old() {
		return type_cliente_old;
	}

	public void setType_cliente_old(String type_cliente_old) {
		this.type_cliente_old = type_cliente_old;
	}

	public String getFoto_ubicacion_cliente_old() {
		return foto_ubicacion_cliente_old;
	}

	public void setFoto_ubicacion_cliente_old(String foto_ubicacion_cliente_old) {
		this.foto_ubicacion_cliente_old = foto_ubicacion_cliente_old;
	}

	public String getRuc_cliente_old() {
		return ruc_cliente_old;
	}

	public void setRuc_cliente_old(String ruc_cliente_old) {
		this.ruc_cliente_old = ruc_cliente_old;
	}

	public String getDni_cliente_old() {
		return dni_cliente_old;
	}

	public void setDni_cliente_old(String dni_cliente_old) {
		this.dni_cliente_old = dni_cliente_old;
	}

	public Date getFecha_empadronamiento_cliente_old() {
		return fecha_empadronamiento_cliente_old;
	}

	public void setFecha_empadronamiento_cliente_old(Date fecha_empadronamiento_cliente_old) {
		this.fecha_empadronamiento_cliente_old = fecha_empadronamiento_cliente_old;
	}

	public String getClaveApi_old() {
		return claveApi_old;
	}

	public void setClaveApi_old(String claveApi_old) {
		this.claveApi_old = claveApi_old;
	}

	public Date getVersion_old() {
		return version_old;
	}

	public void setVersion_old(Date version_old) {
		this.version_old = version_old;
	}

	public String getRazonsocial_cliente_new() {
		return razonsocial_cliente_new;
	}

	public void setRazonsocial_cliente_new(String razonsocial_cliente_new) {
		this.razonsocial_cliente_new = razonsocial_cliente_new;
	}

	public String getMensaje_cliente_new() {
		return mensaje_cliente_new;
	}

	public void setMensaje_cliente_new(String mensaje_cliente_new) {
		this.mensaje_cliente_new = mensaje_cliente_new;
	}

	public int getFkcodigo_usuario_new() {
		return fkcodigo_usuario_new;
	}

	public void setFkcodigo_usuario_new(int fkcodigo_usuario_new) {
		this.fkcodigo_usuario_new = fkcodigo_usuario_new;
	}

	public int getFkcodigo_regimen_cliente_new() {
		return fkcodigo_regimen_cliente_new;
	}

	public void setFkcodigo_regimen_cliente_new(int fkcodigo_regimen_cliente_new) {
		this.fkcodigo_regimen_cliente_new = fkcodigo_regimen_cliente_new;
	}

	public int getFkcodigo_estado_cliente_new() {
		return fkcodigo_estado_cliente_new;
	}

	public void setFkcodigo_estado_cliente_new(int fkcodigo_estado_cliente_new) {
		this.fkcodigo_estado_cliente_new = fkcodigo_estado_cliente_new;
	}

	public Double getLatitud_cliente_new() {
		return latitud_cliente_new;
	}

	public void setLatitud_cliente_new(Double latitud_cliente_new) {
		this.latitud_cliente_new = latitud_cliente_new;
	}

	public Double getLongitud_cliente_new() {
		return longitud_cliente_new;
	}

	public void setLongitud_cliente_new(Double longitud_cliente_new) {
		this.longitud_cliente_new = longitud_cliente_new;
	}

	public String getType_cliente_new() {
		return type_cliente_new;
	}

	public void setType_cliente_new(String type_cliente_new) {
		this.type_cliente_new = type_cliente_new;
	}

	public String getFoto_ubicacion_cliente_new() {
		return foto_ubicacion_cliente_new;
	}

	public void setFoto_ubicacion_cliente_new(String foto_ubicacion_cliente_new) {
		this.foto_ubicacion_cliente_new = foto_ubicacion_cliente_new;
	}

	public String getRuc_cliente_new() {
		return ruc_cliente_new;
	}

	public void setRuc_cliente_new(String ruc_cliente_new) {
		this.ruc_cliente_new = ruc_cliente_new;
	}

	public String getDni_cliente_new() {
		return dni_cliente_new;
	}

	public void setDni_cliente_new(String dni_cliente_new) {
		this.dni_cliente_new = dni_cliente_new;
	}

	public Date getFecha_empadronamiento_cliente_new() {
		return fecha_empadronamiento_cliente_new;
	}

	public void setFecha_empadronamiento_cliente_new(Date fecha_empadronamiento_cliente_new) {
		this.fecha_empadronamiento_cliente_new = fecha_empadronamiento_cliente_new;
	}

	public String getClaveApi_new() {
		return claveApi_new;
	}

	public void setClaveApi_new(String claveApi_new) {
		this.claveApi_new = claveApi_new;
	}

	public Date getVersion_new() {
		return version_new;
	}

	public void setVersion_new(Date version_new) {
		this.version_new = version_new;
	}

}
