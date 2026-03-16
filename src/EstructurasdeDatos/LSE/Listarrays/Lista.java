package EstructurasdeDatos.LSE.Listarrays;

import Interfaces.ListaTAD;

public class Lista<T> implements ListaTAD<T> {
    private Nodo<T> cabeza;
    private int tamano;
    public Lista(){}
    @Override
    public boolean esVacia(){
        return false;
    }
    @Override
    public int longitud(){
        return 0;
    }
    @Override
    public void insertarFinal(T elemento){
        if(this.cabeza == null){
            this.cabeza = new Nodo<>(elemento);
            tamano++;
        }
        else{
            insertarFinalRecursividad(this.cabeza, elemento);
        }


    }
    @Override
    public boolean buscar(T elemento){
        return false;
    }
    @Override
    public int aciertos_exactos(ListaTAD<T> otraLista){
        Lista<T> otraListaReal = (Lista<T>) otraLista;
        Nodo<T> cabezaOtra = otraListaReal.cabeza;
        return aciertos_exactosRec(this.cabeza, cabezaOtra);}
        private int aciertos_exactosRec(Nodo<T> actualMia, Nodo<T> actualOtra) {
            if (actualMia == null || actualOtra == null) {
                return 0;
            }
            if (actualMia.getDato().equals(actualOtra.getDato())) {
                return 1 + aciertos_exactosRec(actualMia.getSiguiente(), actualOtra.getSiguiente());
            }
            else {
                return 0 + aciertos_exactosRec(actualMia.getSiguiente(), actualOtra.getSiguiente());
            }
        }

    private void insertarFinalRecursividad(Nodo<T> actual, T elemento){
        if(actual.getSiguiente() == null){
            actual.setSiguiente(new Nodo<>(elemento));
            tamano++;}
        else {insertarFinalRecursividad(actual.getSiguiente(), elemento);}

    }
    private boolean buscarRec(Nodo<T> actual, T elemento){
        return false;
    }
    public void eliminar(T elemento) {
        this.cabeza = eliminarRec(this.cabeza, elemento);
    }


    private Nodo<T> eliminarRec(Nodo<T> actual, T elemento) {


        if (actual == null) {
            return null; // Devolvemos la nada
        }


        if (actual.getDato().equals(elemento)) {
            tamano--; // Restamos 1 al contador de tamaño

            return actual.getSiguiente();
        }


        actual.setSiguiente(eliminarRec(actual.getSiguiente(), elemento));

        return actual;
    }
    public void invertir(){
        if(cabeza == null){
            cabeza=null;
        }
        Nodo<T> anterior = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente = null;
        while(actual!=null){
            actual = cabeza.getSiguiente();
            actual.setSiguiente(anterior);
            anterior = actual;
            actual = siguiente;
        }
        this.cabeza = anterior;
    }
    public T obtenerCentral(){
        if(this.cabeza == null){
            return null;
        }
        Nodo<T> medio=this.cabeza;
        Nodo<T> fin=this.cabeza;
        while (fin != null && fin.getSiguiente()!=null){
            medio = medio.getSiguiente();
            fin = fin.getSiguiente().getSiguiente();
        }
        return medio.getDato();

    }
    public void EliminarRepetidos(){
        if(this.cabeza == null) {
            return;
        }
        Nodo<T> actual = this.cabeza;
        while(actual != null){
            Nodo<T> detector = actual;
            while(detector.getSiguiente()!=null) {
                if (detector.getSiguiente().getDato().equals(actual.getDato())) {
                    detector.setSiguiente(detector.getSiguiente().getSiguiente());
                    tamano--;
                } else {
                    detector = detector.getSiguiente();
                }
            }
            actual = actual.getSiguiente();
        }

    }
    public boolean detectorCiclo(){//misma idea que en el de buscar el centro
        if(this.cabeza == null){
            return false;
        }
        Nodo<T> medio = this.cabeza;
        Nodo<T> fin = this.cabeza;
        while(fin.getSiguiente()!=null){
            medio=medio.getSiguiente();
            fin=fin.getSiguiente().getSiguiente();
            if(medio==fin){
                return true;
            }


        }
        return false;

    }
    public void EliminarPorElFinal(int n){//hay q contar desde atras para eliminar
        if(this.cabeza == null || n<0){
            return;
        }
        Nodo<T> localizar = this.cabeza;
        Nodo<T> eliminador = this.cabeza;
        for(int i=0;i<n;i++  ){
            if(localizar ==null) return;
            localizar = localizar.getSiguiente();
        }
        if(localizar == null){
            this.cabeza = this.cabeza.getSiguiente();
            tamano --;
            return;
        }
        while(localizar.getSiguiente()!=null){
            localizar =localizar.getSiguiente();
            eliminador=eliminador.getSiguiente();
        }
        eliminador.setSiguiente(eliminador.getSiguiente().getSiguiente());
        tamano--;

    }
    public void intercalar(ListaTAD<T> otraLista) {//intercala listas
        if (!(otraLista instanceof Lista<?>)) return;//mira esa Lista<?> sin importar q clase dew dato haya dentro

        @SuppressWarnings("unchecked")
        Lista<T> otraListaReal = (Lista<T>) otraLista;

        Nodo<T> miActual = this.cabeza;
        Nodo<T> otroActual = otraListaReal.cabeza;
        Nodo<T> miSiguiente;//preparamos dos variables para usarlas dsps
        Nodo<T> otroSiguiente;

        while (miActual != null && otroActual != null) {//vamos intercalando las listas haciendo como una trenza que se combierte en una sola para luego poder imprimirlas en el orden que se desee
            miSiguiente = miActual.getSiguiente();
            otroSiguiente = otroActual.getSiguiente();

            miActual.setSiguiente(otroActual);
            otroActual.setSiguiente(miSiguiente);

            miActual = miSiguiente;
            otroActual = otroSiguiente;
        }

        this.tamano += otraListaReal.tamano;
        otraListaReal.cabeza = null;
        otraListaReal.tamano = 0;
    }
}
