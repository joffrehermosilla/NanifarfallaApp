package nanifarfalla.app.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;

public class Vendedor {

	
	@OneToMany(mappedBy = "mVendedor", fetch = FetchType.EAGER)
	private Collection<ClienteTienePedido> clientetienepedidos = new ArrayList<>();
}
