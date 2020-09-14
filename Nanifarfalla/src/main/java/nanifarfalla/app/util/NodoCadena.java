package nanifarfalla.app.util;

public class NodoCadena {
	  private String dato;
	    private NodoCadena izquierda, derecha;

	    public NodoCadena(String dato) {
	        this.dato = dato;
	        this.izquierda = this.derecha = null;
	    }


	    public String getDato() {
	        return dato;
	    }

	    public NodoCadena getIzquierda() {
	        return izquierda;
	    }

	    public void setIzquierda(NodoCadena izquierda) {
	        this.izquierda = izquierda;
	    }

	    public NodoCadena getDerecha() {
	        return derecha;
	    }

	    public void setDerecha(NodoCadena derecha) {
	        this.derecha = derecha;
	    }

	    public void imprimirDato() {
	        System.out.println(this.getDato());
	    }
}
