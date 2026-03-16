package EstructurasdeDatos.LSE.ListaModular;
/**
 * Representa una lista simplemente enlazada que mantiene los elementos ordenados.
 * Extiende ListaSimplementeEnlazada sobrescribiendo el metodo add para insertar en orden ascendente.
*/
public class LSEOrdenada<T extends Comparable<T>> extends ListaSimplementeEnlazada<T> {
    /**
     * Inserta un dato en la posición correcta para mantener el orden ascendente.
     * Sobrescribe el metodo add de ListaSimplementeEnlazada.
    */
    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato); // Creamos un nuevo elemento con el dato
        // Caso 1: Lista vacía o el dato es menor que el primero, insertamos al inicio
        if (isEmpty() || dato.compareTo(primero.dato) < 0) {
            nuevo.siguiente = primero; // El nuevo apunta al que era el primero
            primero = nuevo;           // El nuevo pasa a ser el primero
        }
        // Caso 2: Buscamos la posición correcta en medio o al final
        else {
            ElementoSE<T> ant = primero;         // Empezamos con anterior apuntando al primero
            ElementoSE<T> act = primero.siguiente; // Actual apunta al segundo elemento

            // Avanzamos mientras haya siguiente y el siguiente sea menor al dato nuevo
            while (act != null && dato.compareTo(act.dato) > 0) {
                ant = act;           // Anterior avanza al actual
                act = act.siguiente; // Actual avanza al siguiente
            }
            // Insertamos el nuevo elemento entre anterior y actual
            nuevo.siguiente = act; // El nuevo apunta al elemento actual
            ant.siguiente = nuevo; // El anterior apunta al nuevo elemento
        }
        tamaño++; // Incrementamos el contador heredado de ListaSimplementeEnlazada
    }
}