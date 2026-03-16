package EstructurasdeDatos.LDE.ListaModular;
import Interfaces.Lista;
import Interfaces.Iterador;

/** Representa una lista doblemente enlazada genérica y ordenable.*/
public class ListaDoblementeEnlazada<T extends Comparable<T>> implements Lista<T> {
    protected ElementoDE<T> primero;
    protected ElementoDE<T> ultimo;
    protected int tamaño;
    /** Constructor por defecto. Inicializa la lista vacía con primero y ultimo a null y tamaño a 0.*/
    public ListaDoblementeEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }
    /** Inserta un dato al final de la lista.*/
    @Override
    public void add(T dato) {
        ElementoDE<T> nuevo = new ElementoDE<>(dato); // Creamos un nuevo elemento con el dato
        if (isEmpty()) {
            primero = ultimo = nuevo; // Si la lista está vacía el nuevo elemento es primero y último
        } else {
            ultimo.siguiente = nuevo; // El último apunta al nuevo elemento
            nuevo.anterior = ultimo;  // El nuevo elemento apunta hacia atrás al último
            ultimo = nuevo;           // El nuevo elemento pasa a ser el último
        }
        tamaño++; // Incrementamos el tamaño
    }
    /** Busca y devuelve un dato por valor.*/
    @Override
    public T get(T dato) {
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        while (aux != null) { // Recorremos hasta el final
            if (aux.dato.equals(dato)) return aux.dato; // Si el dato coincide lo devolvemos
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        return null; // Si no encontramos el dato devolvemos null
    }
    /** Busca y elimina un dato por valor.*/
    @Override
    public T del(T dato) {
        if (isEmpty()) return null; // Si la lista está vacía devolvemos null
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        while (aux != null) {
            if (aux.dato.equals(dato)) {
                if (aux == primero) {
                    // Si es el primero el segundo elemento pasa a ser el primero
                    primero = primero.siguiente;
                    if (primero != null) primero.anterior = null; // El nuevo primero no tiene anterior
                    else ultimo = null; // Si la lista queda vacía también vaciamos el último
                }
                else if (aux == ultimo) {
                    // Si es el último el penúltimo pasa a ser el último
                    ultimo = ultimo.anterior;
                    ultimo.siguiente = null; // El nuevo último no tiene siguiente
                }
                else {
                    // Si está en medio hacemos un salto entre anterior y siguiente
                    aux.anterior.siguiente = aux.siguiente;
                    aux.siguiente.anterior = aux.anterior;
                }
                tamaño--; // Decrementamos el tamaño
                return aux.dato; // Devolvemos el dato eliminado
            }
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        return null; // Si no encontramos el dato devolvemos null
    }
    /** Devuelve true si la lista está vacía, false si no.*/
    @Override
    public boolean isEmpty() { return primero == null; } // Si el primero es null la lista está vacía
    /** Devuelve el número de elementos de la lista.*/
    @Override
    public int getSize() { return tamaño; } // Devolvemos el contador de elementos
    /** Devuelve un iterador para recorrer la lista.*/
    @Override
    public Iterador<T> getIterador() {
        return new IteradorLDE<>(primero); // Creamos un iterador comenzando desde el primero
    }
    /** Vacía la lista eliminando todos sus elementos.*/
    @Override
    public void vaciar() {
        this.primero = null; // El primer elemento ya no apunta a nada
        this.ultimo = null;  // El último elemento ya no apunta a nada
        this.tamaño = 0;     // Reiniciamos el contador
        System.out.println("Lista doble vaciada.");
    }
    /** Comprueba si un elemento existe en la lista recorriendo desde el primero.*/
    @Override
    public boolean existe(T dato) {
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        while (aux != null) { // Recorremos hasta el final
            if (aux.dato.equals(dato)) {
                return true; // Si encontramos el dato devolvemos true
            }
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        return false; // Si no encontramos el dato devolvemos false
    }
    /** Devuelve el elemento en la posición indicada recorriendo desde el primero.*/
    @Override
    public T obtenerPorPosicion(int puesto) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: Posición fuera de los límites"); // La posición está fuera del rango válido
            return null;
        }
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente; // Avanzamos hasta la posición indicada
        }
        return aux.dato; // Devolvemos el dato en esa posición
    }
    /** Reemplaza el dato en la posición indicada por un nuevo dato sin crear un nuevo nodo.*/
    @Override
    public void cambiarEnPosicion(int puesto, T nuevoDato) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: No se puede cambiar esa posición"); // La posición está fuera del rango válido
            return;
        }
        ElementoDE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente; // Avanzamos hasta la posición indicada
        }
        aux.dato = nuevoDato; // Reemplazamos el dato sin crear un nuevo nodo
    }
    /** Devuelve una representación en texto de la lista con flechas dobles.*/
    @Override
    public String mostrarLista() {
        if (isEmpty()) return "Lista doble vacía"; // Si la lista está vacía devolvemos mensaje
        String resultado = "null <-> "; // Indicamos el inicio de la lista
        ElementoDE<T> aux = primero;    // Empezamos desde el primer elemento
        while (aux != null) {
            resultado = resultado + aux.dato; // Añadimos el dato al resultado
            if (aux.siguiente != null) {
                resultado = resultado + " <=> "; // Conectamos cada elemento con flecha doble
            }
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        resultado = resultado + " -> null"; // Indicamos el fin de la lista
        return resultado;
    }
    /** Devuelve una representación en texto de la lista recorrida al revés.*/
    public String mostrarAlReves() {
        if (isEmpty()) return "Vacía"; // Si la lista está vacía devolvemos mensaje
        String resultado = "Al revés: null <- "; // Indicamos el inicio del recorrido al revés
        ElementoDE<T> aux = ultimo; // Empezamos desde el último elemento
        while (aux != null) {
            resultado = resultado + aux.dato; // Añadimos el dato al resultado
            if (aux.anterior != null) {
                resultado = resultado + " <=> "; // Conectamos cada elemento con flecha doble
            }
            aux = aux.anterior; // Avanzamos hacia atrás
        }
        return resultado;
    }
}