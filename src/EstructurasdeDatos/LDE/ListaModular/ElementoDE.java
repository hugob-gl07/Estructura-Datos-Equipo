package EstructurasdeDatos.LDE.ListaModular;
/**
 * Representa un nodo de una lista doblemente enlazada.
 * Contiene un dato y punteros al elemento anterior y siguiente.
*/
public class ElementoDE<T> {
    T dato;                  // Dato almacenado en el nodo
    ElementoDE<T> siguiente; // Puntero al siguiente nodo
    ElementoDE<T> anterior;  // Puntero al nodo anterior
    /**
     * Constructor con dato.
     * Inicializa siguiente y anterior a null.
    */
    public ElementoDE(T dato) {
        this.dato = dato;
        this.siguiente = null; // El nodo no apunta a ningún siguiente
        this.anterior = null;  // El nodo no apunta a ningún anterior
    }
}