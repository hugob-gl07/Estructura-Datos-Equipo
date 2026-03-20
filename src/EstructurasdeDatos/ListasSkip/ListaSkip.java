package EstructurasdeDatos.ListasSkip;

import java.util.Random;

/**
 * Estructura de datos que almacena elementos de forma ordenada.
 * Utiliza múltiples niveles de enlaces para permitir búsquedas, inserciones
 * y eliminaciones mucho más rápidas que una lista tradicional, ya que es capaz
 * de saltar grupos de elementos en lugar de revisarlos uno por uno.
 */
public class ListaSkip<T extends Comparable<T>> {
    private static final int MAX_NIVEL = 16;
    private NodoSkip<T> cabeza;
    private int nivelActual;
    private Random random;
    private int tamano;

    /**
     * Inicializa una lista vacía preparándola para almacenar datos.
     * Crea un punto de inicio (cabeza) y configura el generador de aleatoriedad
     * que mantendrá la estructura balanceada.
     */
    public ListaSkip() {
        this.cabeza = new NodoSkip<>(null, MAX_NIVEL);
        this.nivelActual = 0;
        this.random = new Random();
        this.tamano = 0;
    }

    /**
     * Genera un nivel aleatorio para un nuevo elemento que se va a insertar.
     * Determina en cuántos "niveles de salto rápido" participará el dato,
     * lo cual es clave para mantener la velocidad de la estructura.
     * @return El número de niveles asignado.
     */
    private int lanzarMoneda() {
        int nivel = 0;
        while (nivel < MAX_NIVEL && random.nextBoolean()) {
            nivel++;
        }
        return nivel;
    }

    /**
     * Devuelve la cantidad de elementos almacenados actualmente.
     * @return El tamaño de la lista.
     */
    public int getTamaño() {
        return tamano;
    }

    /**
     * Comprueba si la estructura no contiene ningún dato.
     * @return true si la lista está vacía, false en caso contrario.
     */
    public boolean estaVacia() {
        return tamano == 0;
    }

    /**
     * Añade un nuevo elemento a la lista manteniendo automáticamente el orden
     * de menor a mayor. Ajusta las conexiones internas para que el dato sea
     * fácilmente localizable en el futuro.
     * @param elemento El dato o valor que se va a guardar.
     */
    public void insertar(T elemento) {
        @SuppressWarnings("unchecked")
        NodoSkip<T>[] actualizacion = new NodoSkip[MAX_NIVEL + 1];
        NodoSkip<T> actual = this.cabeza;

        for (int i = nivelActual; i >= 0; i--) {
            while (actual.getSiguiente(i) != null && actual.getSiguiente(i).getDato().compareTo(elemento) < 0) {
                actual = actual.getSiguiente(i);
            }
            actualizacion[i] = actual;
        }

        int nuevoNivel = lanzarMoneda();
        if (nuevoNivel > nivelActual) {
            for (int i = nivelActual + 1; i <= nuevoNivel; i++) {
                actualizacion[i] = cabeza;
            }
            nivelActual = nuevoNivel;
        }

        NodoSkip<T> nuevoNodo = new NodoSkip<>(elemento, nuevoNivel);

        // Empalme de punteros para insertar el elemento
        for (int i = 0; i <= nuevoNivel; i++) {
            nuevoNodo.setSiguiente(i, actualizacion[i].getSiguiente(i));
            actualizacion[i].setSiguiente(i, nuevoNodo);
        }
        this.tamano++;
    }

    /**
     * Comprueba de forma eficiente si un elemento específico ya existe.
     * Aprovecha los niveles de salto para descartar grandes bloques de datos
     * rápidamente y encontrar el resultado en el menor tiempo posible.
     * @param elemento El dato que se desea buscar.
     * @return true si el elemento está guardado en la estructura, false si no se encuentra.
     */
    public boolean buscar(T elemento) {
        NodoSkip<T> actual = this.cabeza;
        for (int i = nivelActual; i >= 0; i--) {
            while (actual.getSiguiente(i) != null && actual.getSiguiente(i).getDato().compareTo(elemento) < 0) {
                actual = actual.getSiguiente(i);
            }
        }
        actual = actual.getSiguiente(0);
        return actual != null && actual.getDato().equals(elemento);
    }

    /**
     * Busca y elimina un elemento, reorganizando automáticamente las conexiones
     * internas para que la estructura siga funcionando correctamente y no queden huecos.
     * @param elemento El dato que se desea eliminar.
     * @return true si el elemento se encontró y se eliminó con éxito, false si no existía.
     */
    public boolean eliminar(T elemento) {
        @SuppressWarnings("unchecked")
        NodoSkip<T>[] actualizacion = new NodoSkip[MAX_NIVEL + 1];
        NodoSkip<T> actual = this.cabeza;

        for (int i = nivelActual; i >= 0; i--) {
            while (actual.getSiguiente(i) != null && actual.getSiguiente(i).getDato().compareTo(elemento) < 0) {
                actual = actual.getSiguiente(i);
            }
            actualizacion[i] = actual;
        }

        actual = actual.getSiguiente(0);

        if (actual != null && actual.getDato().equals(elemento)) {
            for (int i = 0; i <= nivelActual; i++) {
                if (actualizacion[i].getSiguiente(i) != actual) break;
                actualizacion[i].setSiguiente(i, actual.getSiguiente(i));
            }

            // Reducción de la altura máxima si los niveles superiores quedan vacíos
            while (nivelActual > 0 && cabeza.getSiguiente(nivelActual) == null) {
                nivelActual--;
            }
            this.tamano--;
            return true;
        }
        return false;
    }

    /**
     * Muestra por consola el contenido completo de la estructura, nivel por nivel.
     * Útil para visualizar cómo están distribuidos los datos internamente.
     */
    public void imprimir() {
        for (int i = nivelActual; i >= 0; i--) {
            NodoSkip<T> actual = cabeza.getSiguiente(i);
            System.out.print("Nivel " + i + ": ");
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguiente(i);
            }
            System.out.println("null");
        }
    }

    /**
     * Obtiene el elemento con el valor más bajo almacenado.
     * Al estar la lista ordenada internamente, la recuperación de este dato es inmediata.
     * @return El dato menor, o null si la lista está vacía.
     */
    public T obtenerMinimo() {
        if (estaVacia()) {
            return null;
        } else {
            return cabeza.getSiguiente(0).getDato();
        }
    }

    /**
     * Obtiene el elemento con el valor más alto almacenado.
     * Utiliza la ruta más rápida posible para desplazarse hasta el final de los datos.
     * @return El dato mayor, o null si la lista está vacía.
     */
    public T obtenerMaximo() {
        if (estaVacia()) {
            return null;
        }

        NodoSkip<T> actual = this.cabeza;
        for (int i = nivelActual; i >= 0; i--) {
            while (actual.getSiguiente(i) != null) {
                actual = actual.getSiguiente(i);
            }
        }
        return actual.getDato();
    }

    /**
     * Elimina todos los elementos de la estructura y la devuelve a su estado inicial.
     */
    public void vaciar() {
        this.cabeza = new NodoSkip<>(null, MAX_NIVEL);
        this.nivelActual = 0;
        this.tamano = 0;
    }
}
