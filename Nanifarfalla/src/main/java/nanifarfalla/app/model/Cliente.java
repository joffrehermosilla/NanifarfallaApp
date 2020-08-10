package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Cliente {

	
	

	@OneToMany(mappedBy = "mCliente", fetch = FetchType.EAGER)
	private Collection<ClienteTienePedido> clientetienepedidos = new ArrayList<>();
}
