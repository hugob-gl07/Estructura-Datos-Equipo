package EstructurasdeDatos.LDE.ListaModular;
import Interfaces.Iterador;
/**
 * Representa un iterador para recorrer una lista doblemente enlazada.
 * Implementa la interfaz Iterador para permitir recorrer la lista sin conocer su estructura interna.
*/
public class IteradorLDE<T> implements Iterador<T> {

    private ElementoDE<T> actual; // Elemento actual en el recorrido
    /** Constructor con el elemento de inicio del recorrido.*/
    public IteradorLDE(ElementoDE<T> comienzo) {
        this.actual = comienzo; // Inicializamos el iterador en el primer elemento
    }
    /** Comprueba si quedan elementos por recorrer.*/
    @Override
    public boolean hasNext() {
        return actual != null; // Si actual es null hemos llegado al final de la lista
    }
    /** Devuelve el dato del elemento actual y avanza al siguiente.*/
    @Override
    public T next() {
        T valor = actual.dato;       // Guardamos el dato del elemento actual
        actual = actual.siguiente;   // Avanzamos al siguiente elemento
        return valor;                // Devolvemos el dato guardado
    }
}