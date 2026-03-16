package Interfaces;
/** Interfaz que define el comportamiento básico de una lista TAD.*/
public interface ListaTAD<T> {
    /** Comprueba si la lista está vacía.*/
    boolean esVacia();
    /** Devuelve el número de elementos de la lista.*/
    int longitud();
    /** Inserta un elemento al final de la lista.*/
    void insertarFinal(T elementeo);
    /** Busca un elemento en la lista y devuelve true si existe, false si no.*/
    boolean buscar(T elemento);
    /** Compara dos listas y devuelve el número de coincidencias en la misma posición.*/
    int aciertos_exactos(ListaTAD<T> otraLista);
}