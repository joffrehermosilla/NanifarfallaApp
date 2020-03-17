package nanifarfalla.app.model;

public class Ceo {
private int codigo_ceo;
private String nombre_ceo;
private String mensaje;



@Override
public String toString() {
	return "Ceo [codigo_ceo=" + codigo_ceo + ", nombre_ceo=" + nombre_ceo + ", mensaje=" + mensaje + "]";
}
public int getCodigo_ceo() {
	return codigo_ceo;
}
public void setCodigo_ceo(int codigo_ceo) {
	this.codigo_ceo = codigo_ceo;
}
public String getNombre_ceo() {
	return nombre_ceo;
}
public void setNombre_ceo(String nombre_ceo) {
	this.nombre_ceo = nombre_ceo;
}
public String getMensaje() {
	return mensaje;
}
public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}
}
