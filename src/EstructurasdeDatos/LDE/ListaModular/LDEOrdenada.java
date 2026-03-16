package EstructurasdeDatos.LDE.ListaModular;
/**
 * Representa una lista doblemente enlazada que mantiene los elementos ordenados.
 * Extiende ListaDoblementeEnlazada sobrescribiendo el metodo add para insertar en orden ascendente.
*/
public class LDEOrdenada<T extends Comparable<T>> extends ListaDoblementeEnlazada<T> {
    /**
     * Inserta un dato en la posición correcta para mantener el orden ascendente.
     * Sobrescribe el metodo add de ListaDoblementeEnlazada.
    */
    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato); // Creamos un nuevo elemento con el dato

        if (isEmpty()) {
            primero = ultimo = nuevo; // Si la lista está vacía el nuevo elemento es primero y último
        }
        // Caso 1: el dato es menor que el primero, insertamos al inicio
        else if (dato.compareTo(primero.dato) < 0) {
            nuevo.siguiente = primero;   // El nuevo apunta al que era el primero
            primero.anterior = nuevo;    // El que era el primero apunta hacia atrás al nuevo
            primero = nuevo;             // El nuevo pasa a ser el primero
        }
        // Caso 2: el dato es mayor o igual que el último, insertamos al final
        else if (dato.compareTo(ultimo.dato) >= 0) {
            ultimo.siguiente = nuevo;    // El último apunta al nuevo elemento
            nuevo.anterior = ultimo;     // El nuevo apunta hacia atrás al último
            ultimo = nuevo;              // El nuevo pasa a ser el último
        }
        // Caso 3: el dato va en una posición intermedia
        else {
            ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
            while (aux != null && dato.compareTo(aux.dato) > 0) {
                aux = aux.siguiente; // Avanzamos hasta encontrar el primer elemento mayor al dato
            }
            // Insertamos el nuevo elemento justo antes de aux
            nuevo.siguiente = aux;          // El nuevo apunta al elemento actual
            nuevo.anterior = aux.anterior;  // El nuevo apunta hacia atrás al anterior del actual
            aux.anterior.siguiente = nuevo; // El anterior al actual apunta al nuevo
            aux.anterior = nuevo;           // El actual apunta hacia atrás al nuevo
        }
        tamaño++; // Incrementamos el contador heredado de ListaDoblementeEnlazada
    }
}