package EstructurasdeDatos.LSE.ListaModular;
import Interfaces.Lista;
import Interfaces.Iterador;
/**Representa una lista simplemente enlazada genérica y ordenable.*/
public class ListaSimplementeEnlazada<T extends Comparable<T>> implements Lista<T> {

    protected ElementoSE<T> primero; // Puntero al primer elemento de la lista
    protected int tamaño;            // Contador de elementos de la lista

    /** Constructor por defecto. Inicializa la lista vacía con primero a null y tamaño a 0.*/
    public ListaSimplementeEnlazada() {
        this.primero = null;
        this.tamaño = 0;
    }
    /** Inserta un dato al final de la lista.*/
    @Override
    public void add(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato); // Creamos un nuevo elemento con el dato
        if (isEmpty()) {
            primero = nuevo; // Si la lista está vacía el nuevo elemento pasa a ser el primero
        } else {
            ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
            while (aux.siguiente != null) {
                aux = aux.siguiente; // Avanzamos hasta llegar al último elemento
            }
            aux.siguiente = nuevo; // Conectamos el nuevo elemento después del último
        }
        tamaño++; // Incrementamos el tamaño
    }
    /** Busca y devuelve un dato por valor.*/
    @Override
    public T get(T dato) {
        ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
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
        if (primero.dato.equals(dato)) {
            // Si el dato a eliminar es el primero
            T valor = primero.dato;          // Guardamos el dato para devolverlo
            primero = primero.siguiente;     // El segundo elemento pasa a ser el primero
            tamaño--;                        // Decrementamos el tamaño
            return valor;                    // Devolvemos el dato eliminado
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
        return new IteradorLSE<>(primero); // Creamos un iterador comenzando desde el primero
    }
    /** Vacía la lista eliminando todos sus elementos.*/
    @Override
    public void vaciar() {
        this.primero = null; // El primer elemento ya no apunta a nada
        this.tamaño = 0;     // Reiniciamos el contador
        System.out.println("La lista se ha vaciado.");
    }
    /** Comprueba si un elemento existe en la lista recorriendo desde el primero.*/
    @Override
    public boolean existe(T dato) {
        ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
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
            System.out.println("Error: Esa posición no existe"); // La posición está fuera del rango válido
            return null;
        }
        ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente; // Avanzamos hasta la posición indicada
        }
        return aux.dato; // Devolvemos el dato en esa posición
    }
    /** Reemplaza el dato en la posición indicada por un nuevo dato sin crear un nuevo nodo.*/
    @Override
    public void cambiarEnPosicion(int puesto, T nuevoDato) {
        if (puesto < 0 || puesto >= tamaño) {
            System.out.println("Error: No puedo cambiar nada ahí"); // La posición está fuera del rango válido
            return;
        }
        ElementoSE<T> aux = primero; // Empezamos desde el primer elemento
        for (int i = 0; i < puesto; i++) {
            aux = aux.siguiente; // Avanzamos hasta la posición indicada
        }
        aux.dato = nuevoDato; // Reemplazamos el dato sin crear un nuevo nodo
    }
    /** Devuelve una representación en texto de la lista.*/
    @Override
    public String mostrarLista() {
        if (isEmpty()) {
            return "Lista vacía"; // Si la lista está vacía devolvemos mensaje
        }
        String resultado = "Elementos: "; // Indicamos el inicio de la lista
        ElementoSE<T> aux = primero;      // Empezamos desde el primer elemento
        while (aux != null) {
            resultado = resultado + aux.dato; // Añadimos el dato al resultado
            if (aux.siguiente != null) {
                resultado = resultado + " -> "; // Conectamos cada elemento con flecha
            }
            aux = aux.siguiente; // Avanzamos al siguiente elemento
        }
        return resultado;
    }
}