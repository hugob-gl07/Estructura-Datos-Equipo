package EstructurasdeDatos.LSE.ListaModular;

/**
 * Representa un nodo de una lista simplemente enlazada.
 * Contiene un dato y un puntero al elemento siguiente.
*/
public class ElementoSE<T> {
    public T dato;                   // Dato almacenado en el nodo
    public ElementoSE<T> siguiente;  // Puntero al siguiente nodo
    /**
     * Constructor con dato.
     * Inicializa siguiente a null ya que al crearse no apunta a ningún nodo.
    */
    public ElementoSE(T valor) {
        this.dato = valor;      // Guardamos el dato en el nodo
        this.siguiente = null;  // Al principio no hay siguiente elemento
    }
}