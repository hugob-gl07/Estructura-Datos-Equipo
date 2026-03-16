package EstructurasdeDatos.LSE.Listarrays;

import Interfaces.ListaTAD;

/**
 * Representa una lista simplemente enlazada genérica con operaciones avanzadas.
 * @param <T> tipo de dato que contiene la lista
 */
public class Lista<T> implements ListaTAD<T> {

    private Nodo<T> cabeza; // Puntero al primer nodo de la lista
    private int tamano;     // Contador de elementos de la lista
    /** Constructor por defecto. Inicializa la lista vacía.*/
    public Lista() {}
    /** Devuelve true si la lista está vacía, false si no.*/
    @Override
    public boolean esVacia() {
        return false; // Si la cabeza es null la lista está vacía
    }
    /** Devuelve el número de elementos de la lista.*/
    @Override
    public int longitud() {
        return 0; // Devolvemos el contador de elementos
    }
    /** Inserta un elemento al final de la lista usando recursividad.*/
    @Override
    public void insertarFinal(T elemento) {
        if (this.cabeza == null) {
            this.cabeza = new Nodo<>(elemento); // Si la lista está vacía el nuevo nodo es la cabeza
            tamano++;
        } else {
            insertarFinalRecursividad(this.cabeza, elemento); // Delegamos en el método recursivo
        }
    }
    /** Busca un elemento en la lista y devuelve true si existe, false si no.*/
    @Override
    public boolean buscar(T elemento) {
        return false; // Delegamos en el método recursivo
    }
    /** Compara dos listas y devuelve el número de coincidencias en la misma posición.*/
    @Override
    public int aciertos_exactos(ListaTAD<T> otraLista) {
        Lista<T> otraListaReal = (Lista<T>) otraLista; // Casteamos la lista a nuestra implementación
        Nodo<T> cabezaOtra = otraListaReal.cabeza;     // Obtenemos la cabeza de la otra lista
        return aciertos_exactosRec(this.cabeza, cabezaOtra); // Delegamos en el método recursivo
    }
    /**
     * Método recursivo que compara dos listas nodo a nodo.
     * Devuelve 1 si los datos coinciden y 0 si no, sumando el resultado de la llamada recursiva.
     */
    private int aciertos_exactosRec(Nodo<T> actualMia, Nodo<T> actualOtra) {
        if (actualMia == null || actualOtra == null) {
            return 0; // Si alguna lista se acaba devolvemos 0
        }
        if (actualMia.getDato().equals(actualOtra.getDato())) {
            return 1 + aciertos_exactosRec(actualMia.getSiguiente(), actualOtra.getSiguiente()); // Coinciden sumamos 1
        } else {
            return 0 + aciertos_exactosRec(actualMia.getSiguiente(), actualOtra.getSiguiente()); // No coinciden sumamos 0
        }
    }
    /**
     * Método recursivo que inserta un elemento al final de la lista.
     * Avanza hasta el último nodo y conecta el nuevo elemento.
     */
    private void insertarFinalRecursividad(Nodo<T> actual, T elemento) {
        if (actual.getSiguiente() == null) {
            actual.setSiguiente(new Nodo<>(elemento)); // Conectamos el nuevo nodo al final
            tamano++;
        } else {
            insertarFinalRecursividad(actual.getSiguiente(), elemento); // Avanzamos al siguiente nodo
        }
    }
    /** Método recursivo auxiliar para buscar un elemento en la lista.*/
    private boolean buscarRec(Nodo<T> actual, T elemento) {
        return false; // Delegamos en el método recursivo
    }

    /** Elimina un elemento por valor usando recursividad.*/
    public void eliminar(T elemento) {
        this.cabeza = eliminarRec(this.cabeza, elemento); // Delegamos en el método recursivo
    }

    /**
     * Método recursivo que elimina un elemento por valor.
     * Devuelve el siguiente nodo si el actual es el que se quiere eliminar.
     */
    private Nodo<T> eliminarRec(Nodo<T> actual, T elemento) {
        if (actual == null) {
            return null; // Si llegamos al final sin encontrar el elemento devolvemos null
        }
        if (actual.getDato().equals(elemento)) {
            tamano--;                    // Decrementamos el tamaño
            return actual.getSiguiente(); // Saltamos el nodo eliminado
        }
        actual.setSiguiente(eliminarRec(actual.getSiguiente(), elemento)); // Avanzamos recursivamente
        return actual;
    }
    /** Invierte el orden de los elementos de la lista.*/
    public void invertir() {
        if (cabeza == null) {
            cabeza = null; // Si la lista está vacía no hacemos nada
        }
        Nodo<T> anterior = null;  // Puntero al nodo anterior
        Nodo<T> actual = cabeza;  // Puntero al nodo actual
        Nodo<T> siguiente = null; // Puntero al nodo siguiente
        while (actual != null) {
            actual = cabeza.getSiguiente();  // Guardamos el siguiente nodo
            actual.setSiguiente(anterior);   // Invertimos el puntero del nodo actual
            anterior = actual;               // Avanzamos el puntero anterior
            actual = siguiente;              // Avanzamos el puntero actual
        }
        this.cabeza = anterior; // La cabeza pasa a ser el último nodo
    }
    /**
     * Devuelve el elemento central de la lista.
     * Usa dos punteros: uno avanza de uno en uno y otro de dos en dos.
     * Cuando el rápido llega al final el lento está en el centro.
     */
    public T obtenerCentral() {
        if (this.cabeza == null) {
            return null; // Si la lista está vacía devolvemos null
        }
        Nodo<T> medio = this.cabeza; // Puntero lento que avanza de uno en uno
        Nodo<T> fin = this.cabeza;   // Puntero rápido que avanza de dos en dos
        while (fin != null && fin.getSiguiente() != null) {
            medio = medio.getSiguiente();              // Avanzamos el puntero lento un paso
            fin = fin.getSiguiente().getSiguiente();   // Avanzamos el puntero rápido dos pasos
        }
        return medio.getDato(); // Devolvemos el dato del nodo central
    }
    /** Elimina los elementos duplicados de la lista.*/
    public void EliminarRepetidos() {
        if (this.cabeza == null) {
            return; // Si la lista está vacía no hacemos nada
        }
        Nodo<T> actual = this.cabeza; // Empezamos desde la cabeza
        while (actual != null) {
            Nodo<T> detector = actual; // Puntero para detectar duplicados
            while (detector.getSiguiente() != null) {
                if (detector.getSiguiente().getDato().equals(actual.getDato())) {
                    detector.setSiguiente(detector.getSiguiente().getSiguiente()); // Saltamos el duplicado
                    tamano--; // Decrementamos el tamaño
                } else {
                    detector = detector.getSiguiente(); // Avanzamos al siguiente nodo
                }
            }
            actual = actual.getSiguiente(); // Avanzamos al siguiente nodo
        }
    }
    /**
     * Detecta si hay un ciclo en la lista.
     * Usa dos punteros: uno lento y uno rápido.
     * Si se encuentran es que hay un ciclo.
     */
    public boolean detectorCiclo() {
        if (this.cabeza == null) {
            return false; // Si la lista está vacía no hay ciclo
        }
        Nodo<T> medio = this.cabeza; // Puntero lento que avanza de uno en uno
        Nodo<T> fin = this.cabeza;   // Puntero rápido que avanza de dos en dos
        while (fin.getSiguiente() != null) {
            medio = medio.getSiguiente();            // Avanzamos el puntero lento un paso
            fin = fin.getSiguiente().getSiguiente(); // Avanzamos el puntero rápido dos pasos
            if (medio == fin) {
                return true; // Si se encuentran hay un ciclo
            }
        }
        return false; // Si llegamos al final sin encontrarse no hay ciclo
    }
    /**
     * Elimina el n-ésimo elemento contando desde el final.
     * Usa dos punteros separados n posiciones para localizar el elemento.
     */
    public void EliminarPorElFinal(int n) {
        if (this.cabeza == null || n < 0) {
            return; // Si la lista está vacía o n es negativo no hacemos nada
        }
        Nodo<T> localizar = this.cabeza;  // Puntero que avanza n posiciones por delante
        Nodo<T> eliminador = this.cabeza; // Puntero que apunta al nodo a eliminar
        for (int i = 0; i < n; i++) {
            if (localizar == null) return; // Si llegamos al final antes de n no hacemos nada
            localizar = localizar.getSiguiente(); // Avanzamos el puntero localizar
        }
        if (localizar == null) {
            this.cabeza = this.cabeza.getSiguiente(); // Si localizar es null eliminamos la cabeza
            tamano--;
            return;
        }
        while (localizar.getSiguiente() != null) {
            localizar = localizar.getSiguiente();   // Avanzamos ambos punteros hasta el final
            eliminador = eliminador.getSiguiente();
        }
        eliminador.setSiguiente(eliminador.getSiguiente().getSiguiente()); // Saltamos el nodo a eliminar
        tamano--; // Decrementamos el tamaño
    }
    /**
     * Intercala dos listas alternando sus elementos.
     * Los elementos de la otra lista se insertan entre los de esta lista.
     * La otra lista queda vacía tras la operación.
     */
    public void intercalar(ListaTAD<T> otraLista) {
        if (!(otraLista instanceof Lista<?>)) return; // Comprobamos que la otra lista es de nuestro tipo
        @SuppressWarnings("unchecked")
        Lista<T> otraListaReal = (Lista<T>) otraLista; // Casteamos la lista a nuestra implementación

        Nodo<T> miActual = this.cabeza;          // Puntero al nodo actual de esta lista
        Nodo<T> otroActual = otraListaReal.cabeza; // Puntero al nodo actual de la otra lista
        Nodo<T> miSiguiente;   // Variable auxiliar para guardar el siguiente nodo de esta lista
        Nodo<T> otroSiguiente; // Variable auxiliar para guardar el siguiente nodo de la otra lista

        while (miActual != null && otroActual != null) {
            miSiguiente = miActual.getSiguiente();     // Guardamos el siguiente de esta lista
            otroSiguiente = otroActual.getSiguiente(); // Guardamos el siguiente de la otra lista

            miActual.setSiguiente(otroActual);   // Conectamos el nodo actual con el de la otra lista
            otroActual.setSiguiente(miSiguiente); // Conectamos el nodo de la otra lista con el siguiente de esta

            miActual = miSiguiente;     // Avanzamos al siguiente nodo de esta lista
            otroActual = otroSiguiente; // Avanzamos al siguiente nodo de la otra lista
        }

        this.tamano += otraListaReal.tamano; // Actualizamos el tamaño sumando el de la otra lista
        otraListaReal.cabeza = null;         // Vaciamos la otra lista
        otraListaReal.tamano = 0;            // Reiniciamos el tamaño de la otra lista
    }
}