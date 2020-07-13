package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_alerta")
public class TipoAlerta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_tipoalerta;

	public int getCodigo_tipoalerta() {
		return codigo_tipoalerta;
	}

	public void setCodigo_tipoalerta(int codigo_tipoalerta) {
		this.codigo_tipoalerta = codigo_tipoalerta;
	}

	public String getNombre_tipoalerta() {
		return nombre_tipoalerta;
	}

	public void setNombre_tipoalerta(String nombre_tipoalerta) {
		this.nombre_tipoalerta = nombre_tipoalerta;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	String nombre_tipoalerta;
	Date version;

	public TipoAlerta() {

	}

}
