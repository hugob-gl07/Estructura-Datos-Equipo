package EstructurasdeDatos.LDE.Listarrays;

public class Lista<T> {


    private Nodo<T> cabeza;
    private Nodo<T> cola;
    private int tamano;


    public Lista() {
        this.tamano = 0;
    }
    public boolean esVacia() {
        return this.cabeza == null;
    }

    public int longitud() {
        return this.tamano;
    }
    public void insertarPrncipio(T elemento){
         Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (this.cabeza == null){
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        }
        else{
            nuevoNodo.setSiguiente(this.cabeza);
            cabeza.setAnterior(nuevoNodo);
            this.cabeza=nuevoNodo;

        }
        this.tamano++;




    }
    public void insertarFinal(T elemento){
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if(cabeza==null){
            this.cabeza = nuevoNodo;
            this.cola = nuevoNodo;
        }
        else{
            nuevoNodo.setAnterior(this.cola);
            cola.setSiguiente(nuevoNodo);
            this.cola = nuevoNodo;
        }
        this.tamano++;
    }
    public void  imprimirAdelante(){
        Nodo<T> actual = cabeza;
        while(actual != null){
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }

    }
  public void imprimirAtras() {
        Nodo<T> actual = cola;
        while(actual!= null){
            System.out.println(actual.getDato());
            actual=actual.getAnterior();
        }
  }
  public boolean buscar(T elemento){
        Nodo<T> find = cabeza;
        while(find!=null){

            if(find.getDato().equals(elemento)){
                return true;
            }

            find=find.getSiguiente();

        }
        return false;
  }
    public void eliminarPrimero(){

        if(cabeza == null){
            return ;
        }
        if(tamano == 1){
            this.cabeza = null;
            this.cola = null;
        }
        else{cabeza = cabeza.getSiguiente();
            cabeza.setAnterior(null);
            tamano --;}
    }
    public void eliminarUltimo(){

        if(cola == null){
            return ;
        }
        if(tamano == 1){
            this.cabeza = null;
            this.cola = null;
        }
        else{cola = cola.getAnterior();
            cola.setSiguiente(null);
        tamano --;}
    }
    public void eliminar(T elemento){
        Nodo<T> buscador = cabeza;
        while(buscador != null){
            if(buscador.getDato().equals(elemento)) {
                if (buscador == cabeza) {
                    eliminarPrimero();
                    return;
                }
                else if (buscador == cola) {
                    eliminarUltimo();
                    return;
                }
                else{
                    buscador.getAnterior().setSiguiente(buscador.getSiguiente());
                    buscador.getSiguiente().setAnterior(buscador.getAnterior());
                    tamano--;
                    return;
                }

            }
            else{
                    buscador = buscador.getSiguiente();
                }



        }
    }

}
