package EstructurasdeDatos.ListasSkip;

/**
 * Representa un nodo individual dentro de una estructura Skip List.
 * A diferencia de un nodo tradicional que solo enlaza con el elemento adyacente,
 * este nodo contiene un array de enlaces. Esto le permite conectarse con múltiples
 * nodos a diferentes "alturas", facilitando los saltos rápidos durante las búsquedas.
 */
public class NodoSkip<T extends Comparable<T>> {
    private T dato;
    private NodoSkip<T>[] siguiente;

    /**
     * Crea un nuevo nodo preparándolo para participar en múltiples niveles.
     * Inicializa el array de enlaces con el tamaño exacto para cubrir desde
     * el nivel base (0) hasta el nivel máximo asignado a este nodo.
     * @param dato El valor o información que va a almacenar este nodo.
     * @param nivel La altura máxima o número de vías rápidas a las que este nodo tendrá acceso.
     */
    @SuppressWarnings("unchecked")
    public NodoSkip(T dato, int nivel) {
        this.dato = dato;
        this.siguiente = new NodoSkip[nivel + 1];
    }

    /**
     * Obtiene el elemento almacenado internamente en este nodo.
     * @return El dato de tipo genérico T.
     */
    public T getDato() {
        return dato;
    }

    /**
     * Actualiza o reemplaza el elemento almacenado en este nodo.
     * @param dato El nuevo dato que se desea guardar.
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * Obtiene el nodo conectado a este, viajando por un nivel específico.
     * @param nivel El nivel o "vía" por la que queremos mirar (0 es el nivel base).
     * @return El nodo enlazado en ese nivel, o null si no hay conexión.
     */
    public NodoSkip<T> getSiguiente(int nivel) {
        return this.siguiente[nivel];
    }

    /**
     * Establece la conexión hacia otro nodo en un nivel específico.
     * @param nivel El nivel o "vía" donde queremos crear el enlace.
     * @param nodo El nodo destino al que apuntaremos en dicho nivel.
     */
    public void setSiguiente(int nivel, NodoSkip<T> nodo) {
        this.siguiente[nivel] = nodo;
    }
}