package EstructurasdeDatos.VList;

/**
 * Representa un bloque de memoria contigua dentro de una estructura VList.
 * A diferencia de un nodo tradicional que guarda un solo dato, este nodo
 * almacena un array de elementos, mejorando el rendimiento de la caché del procesador.
 */
public class Nodo<T> {
    private T[] elementos;
    private int elementosUsados;
    private Nodo<T> siguiente;

    /**
     * Construye un nuevo bloque con una capacidad específica.
     * @param capacidad El número máximo de elementos que podrá almacenar este bloque.
     */
    @SuppressWarnings("unchecked")
    public Nodo(int capacidad) {
        this.elementos = (T[]) new Object[capacidad];
        this.elementosUsados = 0;
        this.siguiente = null;
    }

    /**
     * Obtiene el array interno que contiene los datos del bloque.
     * @return El array de elementos.
     */
    public T[] getElementos() {
        return elementos;
    }

    /**
     * Obtiene la cantidad de espacios que ya han sido ocupados en este bloque.
     * @return El número de elementos almacenados actualmente.
     */
    public int getElementosUsados() {
        return elementosUsados;
    }

    /**
     * Actualiza el contador de elementos que están ocupando espacio en el bloque.
     * @param cant La nueva cantidad de elementos usados.
     */
    public void setElementosUsados(int cant) {
        this.elementosUsados = cant;
    }

    /**
     * Obtiene el siguiente bloque de la estructura.
     * @return El nodo enlazado a continuación, o null si es el final de la lista.
     */
    public Nodo<T> getSiguiente() {
        return siguiente;
    }
    /**
     * Establece la conexión hacia el siguiente bloque de la estructura.
     * @param sig El nodo que se enlazará a continuación.
     */
    public void setSiguiente(Nodo<T> sig) {
        this.siguiente = sig;
    }
}
