package EstructurasdeDatos.LDE.Listarrays;

/**
 * Representa un nodo de una lista doblemente enlazada.
 * Contiene un dato y punteros al nodo anterior y siguiente.
*/
public class Nodo<T> {
    private T dato;          // Dato almacenado en el nodo
    private Nodo<T> siguiente; // Puntero al siguiente nodo
    private Nodo<T> anterior;  // Puntero al nodo anterior
    /**
     * Constructor con dato.
     * Inicializa siguiente y anterior a null.
    */
    public Nodo(T dato) {
        this.dato = dato; // Almacenamos el dato en el nodo
    }
    /** Devuelve el dato del nodo.*/
    public T getDato() {
        return dato; // Devolvemos el dato almacenado
    }
    /** Modifica el dato del nodo.*/
    public void setDato(T dato) {
        this.dato = dato; // Reemplazamos el dato almacenado
    }
    /** Devuelve el siguiente nodo.*/
    public Nodo<T> getSiguiente() {
        return this.siguiente; // Devolvemos el puntero al siguiente nodo
    }
    /** Modifica el puntero al siguiente nodo.*/
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente; // Actualizamos el puntero al siguiente nodo
    }
    /** Devuelve el nodo anterior.*/
    public Nodo<T> getAnterior() {
        return this.anterior; // Devolvemos el puntero al nodo anterior
    }
    /** Modifica el puntero al nodo anterior.*/
    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior; // Actualizamos el puntero al nodo anterior
    }
}