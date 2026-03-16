package Interfaces;

public interface ListaTAD<T> {
    boolean esVacia();

    int longitud();

    void insertarFinal(T elementeo);

    boolean buscar(T elemento);

    int aciertos_exactos(ListaTAD<T> otraLista);
}





