package nanifarfalla.app.util;

public class ArbolCadenas {
	private NodoCadena raiz;

	public ArbolCadenas() {

	}

	public boolean existe(String busqueda) {
		return existe(this.raiz, busqueda);
	}

	private boolean existe(NodoCadena n, String busqueda) {
		if (n == null) {
			return false;
		}
		if (n.getDato().equals(busqueda)) {
			return true;
		} else if (busqueda.compareTo(n.getDato()) < 0) {
			return existe(n.getIzquierda(), busqueda);
		} else {
			return existe(n.getDerecha(), busqueda);
		}

	}

	public void insertar(String dato) {
		if (this.raiz == null) {
			this.raiz = new NodoCadena(dato);
		} else {
			this.insertar(this.raiz, dato);
		}
	}

	private void insertar(NodoCadena padre, String dato) {
		if (dato.compareTo(padre.getDato()) > 0) {
			if (padre.getDerecha() == null) {
				padre.setDerecha(new NodoCadena(dato));
			} else {
				this.insertar(padre.getDerecha(), dato);
			}
		} else {
			if (padre.getIzquierda() == null) {
				padre.setIzquierda(new NodoCadena(dato));
			} else {
				this.insertar(padre.getIzquierda(), dato);
			}
		}
	}

	private void preorden(NodoCadena n) {
		if (n != null) {
			n.imprimirDato();
			preorden(n.getIzquierda());
			preorden(n.getDerecha());
		}
	}

	private void inorden(NodoCadena n) {
		if (n != null) {
			inorden(n.getIzquierda());
			n.imprimirDato();
			inorden(n.getDerecha());
		}
	}

	private void postorden(NodoCadena n) {
		if (n != null) {
			postorden(n.getIzquierda());
			postorden(n.getDerecha());
			n.imprimirDato();
		}
	}

	public void preorden() {
		this.preorden(this.raiz);
	}

	public void inorden() {
		this.inorden(this.raiz);
	}

	public void postorden() {
		this.postorden(this.raiz);
	}
}
