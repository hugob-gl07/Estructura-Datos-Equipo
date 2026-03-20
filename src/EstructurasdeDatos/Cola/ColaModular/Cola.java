package EstructurasdeDatos.Cola.ColaModular;
/**
 * Representa una cola (FIFO) genérica.
 * El primer elemento en entrar es el primero en salir.
 */
public class Cola<T> {
    private ElementoDE<T> frente; // El primero de la cola
    private ElementoDE<T> fin;    // El último de la cola
    private int tamaño; // Contador de elementos en la cola
    /** Constructor por defecto.*/
    public Cola() {
        this.frente = null;
        this.fin = null;
        this.tamaño = 0;
    }
    /** Inserta un dato al final de la cola manteniendo el orden FIFO.*/
    public void enqueue(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato); // Creamos un nuevo elemento con el dato
        if (isEmpty()) {
            frente = nuevo; // Si la cola está vacía el nuevo elemento es tanto el frente como el fin
            fin = nuevo;
        } else {
            fin.siguiente = nuevo;  // El último apunta al nuevo elemento
            nuevo.anterior = fin;   // El nuevo elemento apunta hacia atrás al último
            fin = nuevo;            // El nuevo elemento pasa a ser el fin
        }
        tamaño++; // Incrementamos el tamaño
    }
    /** Elimina y devuelve el primer elemento de la cola (FIFO).*/
    public T dequeue() {
        if (isEmpty()) {
            return null; // Si la cola está vacía devolvemos null
        }
        T valor = frente.dato;          // Guardamos el dato del frente para devolverlo
        frente = frente.siguiente;      // El segundo elemento pasa a ser el nuevo frente
        if (frente != null) {
            frente.anterior = null;     // El nuevo frente no tiene anterior
        } else {
            fin = null;                 // Si la cola quedó vacía vaciamos también el fin
        }
        tamaño--; // Decrementamos el tamaño
        return valor; // Devolvemos el dato eliminado
    }
    /** Devuelve el primer elemento de la cola sin eliminarlo.*/
    public T front() {
        if (isEmpty()) return null; // Si la cola está vacía devolvemos null
        return frente.dato; // Devolvemos el dato del frente sin eliminarlo
    }
    /** Devuelve true si la cola está vacía, false si no.*/
    public boolean isEmpty() {
        return frente == null; // Si el frente es null la cola está vacía
    }
    /** Devuelve el número de elementos de la cola.*/
    public int getSize() {
        return tamaño; // Devolvemos el contador de elementos
    }
}
