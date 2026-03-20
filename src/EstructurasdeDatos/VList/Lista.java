package EstructurasdeDatos.VList;

/**
 * Estructura de datos VList (Lista V).
 * Combina la flexibilidad de crecimiento dinámico de las listas enlazadas
 * con la eficiencia de acceso a memoria de los arrays. Crece asignando
 * bloques de memoria cada vez más grandes de forma geométrica.
 */
public class Lista<T> {
    private Nodo<T> cabeza;

    /**
     * Inicializa una nueva estructura VList.
     * Comienza creando un bloque base inicial con capacidad para un solo elemento.
     */
    public Lista() {
        this.cabeza = new Nodo<>(1);
    }

    /**
     * Añade un nuevo elemento a la estructura.
     * Si el bloque actual está lleno, genera automáticamente un nuevo bloque
     * con el doble de capacidad que el anterior y lo enlaza como la nueva cabeza,
     * garantizando un coste de inserción muy eficiente.
     * @param elemento El dato que se desea almacenar.
     */
    public void insertar(T elemento) {
        if (this.cabeza.getElementosUsados() == this.cabeza.getElementos().length) {
            Nodo<T> nuevoBloque = new Nodo<>(this.cabeza.getElementos().length * 2);
            nuevoBloque.setSiguiente(this.cabeza);
            this.cabeza = nuevoBloque;
        }

        int pos = this.cabeza.getElementosUsados();
        this.cabeza.getElementos()[pos] = elemento;
        this.cabeza.setElementosUsados(pos + 1);
    }

    /**
     * Busca de manera secuencial si un elemento existe dentro de la estructura.
     * Recorre los bloques y examina sus arrays internos, aprovechando la localidad
     * de referencia para realizar lecturas rápidas.
     * @param elemento El dato que se desea localizar.
     * @return true si el elemento se encuentra en algún bloque, false si no existe.
     */
    public boolean buscar(T elemento) {
        Nodo<T> actual = this.cabeza;

        while (actual != null) {
            for (int i = 0; i < actual.getElementosUsados(); i++) {
                if (actual.getElementos()[i].equals(elemento)) {
                    return true;
                }
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Muestra por consola el estado actual de la estructura de memoria.
     * Imprime cada bloque detallando su capacidad máxima y los elementos
     * que contiene actualmente ordenados por inserción.
     */
    public void imprimir() {
        Nodo<T> actual = this.cabeza;
        while (actual != null) {
            System.out.print("Bloque (Capacidad 2^n = " + actual.getElementos().length + "): [");
            for (int i = 0; i < actual.getElementosUsados(); i++) {
                System.out.print(actual.getElementos()[i] + (i < actual.getElementosUsados() - 1 ? ", " : ""));
            }
            System.out.println("] -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("null");
    }
}
