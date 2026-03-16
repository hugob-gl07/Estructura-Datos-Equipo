package EstructurasdeDatos.LDE.Listarrays;

/**
 * Representa una lista doblemente enlazada genérica.
*/
public class Lista<T> {
    private Nodo<T> cabeza; // Puntero al primer nodo de la lista
    private Nodo<T> cola;   // Puntero al último nodo de la lista
    private int tamano;     // Contador de elementos de la lista
    /** Constructor por defecto. Inicializa la lista vacía con tamaño 0.*/
    public Lista() {
        this.tamano = 0;
    }
    /** Devuelve true si la lista está vacía, false si no.*/
    public boolean esVacia() {
        return this.cabeza == null; // Si la cabeza es null la lista está vacía
    }
    /** Devuelve el número de elementos de la lista.*/
    public int longitud() {
        return this.tamano; // Devolvemos el contador de elementos
    }
    /** Inserta un elemento al inicio de la lista.*/
    public void insertarPrincipio(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento); // Creamos un nuevo nodo con el elemento
        if (this.cabeza == null) {
            this.cabeza = nuevoNodo; // Si la lista está vacía el nuevo nodo es cabeza y cola
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(this.cabeza); // El nuevo nodo apunta al que era la cabeza
            cabeza.setAnterior(nuevoNodo);        // La cabeza apunta hacia atrás al nuevo nodo
            this.cabeza = nuevoNodo;              // El nuevo nodo pasa a ser la cabeza
        }
        this.tamano++; // Incrementamos el tamaño
    }
    /** Inserta un elemento al final de la lista.*/
    public void insertarFinal(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento); // Creamos un nuevo nodo con el elemento
        if (cabeza == null) {
            this.cabeza = nuevoNodo; // Si la lista está vacía el nuevo nodo es cabeza y cola
            this.cola = nuevoNodo;
        } else {
            nuevoNodo.setAnterior(this.cola); // El nuevo nodo apunta hacia atrás al que era la cola
            cola.setSiguiente(nuevoNodo);     // La cola apunta al nuevo nodo
            this.cola = nuevoNodo;            // El nuevo nodo pasa a ser la cola
        }
        this.tamano++; // Incrementamos el tamaño
    }
    /** Recorre e imprime la lista de inicio a fin.*/
    public void imprimirAdelante() {
        Nodo<T> actual = cabeza; // Empezamos desde la cabeza
        while (actual != null) {
            System.out.println(actual.getDato()); // Imprimimos el dato del nodo actual
            actual = actual.getSiguiente();        // Avanzamos al siguiente nodo
        }
    }
    /** Recorre e imprime la lista de fin a inicio.*/
    public void imprimirAtras() {
        Nodo<T> actual = cola; // Empezamos desde la cola
        while (actual != null) {
            System.out.println(actual.getDato()); // Imprimimos el dato del nodo actual
            actual = actual.getAnterior();         // Avanzamos hacia atrás
        }
    }
    /** Busca un elemento en la lista y devuelve true si existe, false si no.*/
    public boolean buscar(T elemento) {
        Nodo<T> find = cabeza; // Empezamos desde la cabeza
        while (find != null) {
            if (find.getDato().equals(elemento)) {
                return true; // Si encontramos el elemento devolvemos true
            }
            find = find.getSiguiente(); // Avanzamos al siguiente nodo
        }
        return false; // Si no encontramos el elemento devolvemos false
    }
    /** Elimina el primer elemento de la lista.*/
    public void eliminarPrimero() {
        if (cabeza == null) {
            return; // Si la lista está vacía no hacemos nada
        }
        if (tamano == 1) {
            this.cabeza = null; // Si solo hay un elemento vaciamos la lista
            this.cola = null;
        } else {
            cabeza = cabeza.getSiguiente(); // El segundo elemento pasa a ser la cabeza
            cabeza.setAnterior(null);        // La nueva cabeza no tiene anterior
            tamano--;                        // Decrementamos el tamaño
        }
    }
    /** Elimina el último elemento de la lista.*/
    public void eliminarUltimo() {
        if (cola == null) {
            return; // Si la lista está vacía no hacemos nada
        }
        if (tamano == 1) {
            this.cabeza = null; // Si solo hay un elemento vaciamos la lista
            this.cola = null;
        } else {
            cola = cola.getAnterior(); // El penúltimo elemento pasa a ser la cola
            cola.setSiguiente(null);   // La nueva cola no tiene siguiente
            tamano--;                  // Decrementamos el tamaño
        }
    }
    /** Busca y elimina un elemento por valor.*/
    public void eliminar(T elemento) {
        Nodo<T> buscador = cabeza; // Empezamos desde la cabeza
        while (buscador != null) {
            if (buscador.getDato().equals(elemento)) {
                if (buscador == cabeza) {
                    eliminarPrimero(); // Si es la cabeza reutilizamos eliminarPrimero
                    return;
                } else if (buscador == cola) {
                    eliminarUltimo(); // Si es la cola reutilizamos eliminarUltimo
                    return;
                } else {
                    // Si está en medio hacemos un salto entre anterior y siguiente
                    buscador.getAnterior().setSiguiente(buscador.getSiguiente());
                    buscador.getSiguiente().setAnterior(buscador.getAnterior());
                    tamano--; // Decrementamos el tamaño
                    return;
                }
            } else {
                buscador = buscador.getSiguiente(); // Avanzamos al siguiente nodo
            }
        }
    }
}