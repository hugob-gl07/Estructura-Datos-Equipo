package EstructurasdeDatos.LDE.ListaModular;

import Interfaces.Iterador;

public class IteradorLDE<T> implements Iterador<T> {
    private ElementoDE<T> actual;

    public IteradorLDE(ElementoDE<T> comienzo) {
        this.actual = comienzo;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        T valor = actual.dato;
        actual = actual.siguiente;
        return valor;
    }
}
