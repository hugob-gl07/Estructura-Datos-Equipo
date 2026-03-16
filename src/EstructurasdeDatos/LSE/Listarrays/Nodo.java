package EstructurasdeDatos.LSE.Listarrays;

/**
 * Representa un nodo de una lista simplemente enlazada.
 * Contiene un dato y un puntero al siguiente nodo.
*/
public class Nodo<T> {
    private T dato;            // Dato almacenado en el nodo
    private Nodo<T> siguiente; // Puntero al siguiente nodo
    /**
     * Constructor con dato.
     * Inicializa siguiente a null.
     */
    public Nodo(T dato) {
        this.dato = dato; // Almacenamos el dato en el nodo
    }
    /** Constructor con dato y siguiente.*/
    public Nodo(T dato, Nodo<T> siguiente) {
        this.siguiente = siguiente; // Apuntamos al nodo siguiente
        this.dato = dato;           // Almacenamos el dato en el nodo
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
        return siguiente; // Devolvemos el puntero al siguiente nodo
    }
    /** Modifica el puntero al siguiente nodo.*/
    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente; // Actualizamos el puntero al siguiente nodo
    }
}