package nanifarfalla.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_tiene_catalogo")
public class ClienteTieneCatalogo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_cliente_tiene_catalogo;
	@JoinColumn(name = "fkcodigo_cliente", referencedColumnName = "codigo_cliente")
	@ManyToOne
	Cliente mCliente;
//fkcodigo_cliente	

	@JoinColumn(name = "fkcodigo_catalogo", referencedColumnName = "codigo_catalogo")
	@ManyToOne
	Catalogo mCatalogo;
//fkcodigo_catalogo	
	Date fecha_inicio;
	Date fecha_fin;
	Double precio;
	String claveApi;
	Date version;

	public ClienteTieneCatalogo() {

	}

	public int getCodigo_cliente_tiene_catalogo() {
		return codigo_cliente_tiene_catalogo;
	}

	public void setCodigo_cliente_tiene_catalogo(int codigo_cliente_tiene_catalogo) {
		this.codigo_cliente_tiene_catalogo = codigo_cliente_tiene_catalogo;
	}

	public Cliente getmCliente() {
		return mCliente;
	}

	public void setmCliente(Cliente mCliente) {
		this.mCliente = mCliente;
	}

	public Catalogo getmCatalogo() {
		return mCatalogo;
	}

	public void setmCatalogo(Catalogo mCatalogo) {
		this.mCatalogo = mCatalogo;
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

	public String getClaveApi() {
		return claveApi;
	}

	public void setClaveApi(String claveApi) {
		this.claveApi = claveApi;
	}

	public Date getVersion() {
		return version;
	}

	public void setVersion(Date version) {
		this.version = version;
	}

}
