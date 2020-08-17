package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_alertas")
public class UserAlerta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_user_alerta;

	@JoinColumn(name = "fkcodigo_alerta", referencedColumnName = "codigo_alerta")
	@ManyToOne
	Alerta mAlerta;

	// fkcodigo_alerta
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;

	// fkcodigo_usuario
	@JoinColumn(name = "fkcodigo_tipoalerta", referencedColumnName = "codigo_tipoalerta")
	@ManyToOne
	TipoAlerta mTipoAlerta;

	// int fkcodigo_tipoalerta;

	Date fecha_inicio;
	Date fecha_fin;
	Double precio;
	Date version;

	@OneToMany(mappedBy = "mUserAlerta")
	private Collection<Contrato> contratos = new ArrayList<>();

	public UserAlerta() {

	}

	public int getCodigo_user_alerta() {
		return codigo_user_alerta;
	}

	public void setCodigo_user_alerta(int codigo_user_alerta) {
		this.codigo_user_alerta = codigo_user_alerta;
	}

	public Alerta getmAlerta() {
		return mAlerta;
	}

	public void setmAlerta(Alerta mAlerta) {
		this.mAlerta = mAlerta;
	}

	public Usuario getmUsuario() {
		return mUsuario;
	}

	public void setmUsuario(Usuario mUsuario) {
		this.mUsuario = mUsuario;
	}

	public TipoAlerta getmTipoAlerta() {
		return mTipoAlerta;
	}

	public void setmTipoAlerta(TipoAlerta mTipoAlerta) {
		this.mTipoAlerta = mTipoAlerta;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

	public Collection<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(Collection<Contrato> contratos) {
		this.contratos = contratos;
	}

}
