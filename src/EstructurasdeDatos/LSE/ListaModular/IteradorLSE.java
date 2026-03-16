package EstructurasdeDatos.LSE.ListaModular;

import Interfaces.Iterador;

public class IteradorLSE<T> implements Iterador<T> {
    private ElementoSE<T> actual;

    // El constructor recibe el comienzo de la lista
    public IteradorLSE(ElementoSE<T> comienzo) {
        this.actual = comienzo;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T dato = actual.dato;
        actual = actual.siguiente;
        return dato;
    }
}
