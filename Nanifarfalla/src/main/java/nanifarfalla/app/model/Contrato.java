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
@Table(name = "contrato")
public class Contrato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int codigo_contrato;
	String descripcion;
	Double monto;
	Date fecha_inicio;
	Date fecha_fin;
	@JoinColumn(name = "fkcodigo_estadoContrato", referencedColumnName = "codigo_estadoContrato")
	@ManyToOne
	EstadoContrato mEstadoContrato;

	// fkcodigo_estadoContrato
	@JoinColumn(name = "fkcodigo_usuario", referencedColumnName = "codigo_usuario")
	@ManyToOne
	Usuario mUsuario;

	// fkcodigo_usuario
	@JoinColumn(name = "fkcodigo_cliente", referencedColumnName = "codigo_cliente")
	@ManyToOne
	Cliente mCliente;

	// fkcodigo_cliente

	@JoinColumn(name = "fkcodigo_user_alerta", referencedColumnName = "codigo_user_alerta")
	@ManyToOne
	UserAlerta mUserAlerta;

	// fkcodigo_user_alerta
	@JoinColumn(name = "fkcodigo_user_anuncio", referencedColumnName = "codigo_user_anuncio")
	@ManyToOne
	UserAnuncios mUserAnuncios;

	// fkcodigo_user_anuncio
	@JoinColumn(name = "fkcodigo_pedido_web", referencedColumnName = "codigo_pedido_web")
	@ManyToOne
	ClienteTienePedido mClienteTienePedido;

	// fkcodigo_pedido_web

	@JoinColumn(name = "fkcodigo_catalogo", referencedColumnName = "codigo_catalogo")
	@ManyToOne
	Catalogo mCatalogo;

	// fkcodigo_catalogo
	Date version;

}
