package EstructurasdeDatos.Cola.ColaModular;
/**
 * Representa un nodo de una lista doblemente enlazada.
 * Reutilizado para la cola.
 */
public class ElementoDE<T> {
    T dato;                  // Dato almacenado en el nodo
    ElementoDE<T> siguiente; // Puntero al siguiente nodo
    ElementoDE<T> anterior;  // Puntero al nodo anterior
    /** Constructor con dato.*/
    public ElementoDE(T dato) {
        this.dato = dato;
        this.siguiente = null; // El nodo no apunta a ningún siguiente
        this.anterior = null;  // El nodo no apunta a ningún anterior
    }
}