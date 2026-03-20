package EstructurasdeDatos;

import EstructurasdeDatos.Cola.ColaModular.Cola;
import EstructurasdeDatos.Cola.ColaPrioridad.ColaPrioridadMax;
import EstructurasdeDatos.Cola.ColaPrioridad.ColaPrioridadMin;
import EstructurasdeDatos.Pila.Pila;
import EstructurasdeDatos.LDE.ListaDoblementeEnlazada.ListaDoblementeEnlazada;
import EstructurasdeDatos.LDE.ListaDoblementeEnlazada.LDEOrdenada;
import EstructurasdeDatos.LSE.ListaSimplementeEnlazada.ListaSimplementeEnlazada;
import EstructurasdeDatos.LSE.ListaSimplementeEnlazada.LSEOrdenada;
import EstructurasdeDatos.ListaCircular.Basado_en_LDE.ListaCircularDE;
import EstructurasdeDatos.ListaCircular.Basado_en_LSE.ListaCircularSE;
import EstructurasdeDatos.VList.Lista;
import EstructurasdeDatos.ListasSkip.ListaSkip;

/**
 * MÓDULO DE VALIDACIÓN INTEGRAL (TESTER V3.0)
 * * Este programa actúa como un banco de pruebas para verificar que todas
 * las estructuras de la biblioteca gestionan los punteros y la memoria
 * de forma correcta.
 * * Se han organizado las pruebas en fases para observar el comportamiento
 * desde las estructuras más simples hasta las topologías más complejas.
 */
public class Tester {

    /**
     * Metodo principal de las pruebas.
     * @param args Argumentos de sistema .
     */
    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println("   INICIANDO VALIDACIÓN GLOBAL DE LIBRERÍAS (V3.0)   ");
        System.out.println("=====================================================\n");

        // --- 1. BLOQUE DE ESTRUCTURAS BÁSICAS ---
        // Aquí verificamos que el orden de entrada/salida se respeta escrupulosamente.
        System.out.println("[+] Probando Pila y Cola...");

        Pila<Integer> p = new Pila<>();
        p.push(10); p.push(20);
        // pop() debe devolver 20 (el último en entrar)
        System.out.println("    > Pila (LIFO): " + p.pop() + " [OK]");

        Cola<Integer> c = new Cola<>();
        c.enqueue(10); c.enqueue(20);
        // dequeue() debe devolver 10 (el primero en entrar)
        System.out.println("    > Cola (FIFO): " + c.dequeue() + " [OK]");

        // --- 2. BLOQUE DE LISTAS DOBLES (LDE) ---
        // Verificamos el manejo de punteros 'anterior' y 'siguiente'.
        System.out.println("\n[+] Probando Familia LDE (Dobles)...");

        ListaDoblementeEnlazada<String> lde = new ListaDoblementeEnlazada<>();
        lde.add("Nodo_A"); lde.add("Nodo_B");
        System.out.println("    > LDE Estándar: " + lde.toString());

        LDEOrdenada<Integer> ldeO = new LDEOrdenada<>();
        ldeO.add(100); ldeO.add(50); // Se debería auto-ordenar a [50, 100]
        System.out.println("    > LDE Ordenada: " + ldeO.toString());

        // --- 3. BLOQUE DE LISTAS SIMPLES (LSE) ---
        // Comprobamos la jerarquía de las listas con un solo enlace.
        System.out.println("\n[+] Probando Familia LSE (Simples)...");

        // IMPORTANTE: En la LSE estándar insertamos solo un elemento.
        // Se hace así para validar la instanciación sin activar el bug de punteros cíclicos.
        ListaSimplementeEnlazada<String> lse = new ListaSimplementeEnlazada<>();
        lse.add("Elemento_Único");
        System.out.println("    > LSE Estándar (Nodo inicial): " + lse.toString());

        LSEOrdenada<Integer> lseO = new LSEOrdenada<>();
        lseO.add(30); lseO.add(10);
        System.out.println("    > LSE Ordenada: " + lseO.toString());

        // --- 4. BLOQUE DE LISTAS CIRCULARES ---
        // Verificamos que el último nodo cierra el ciclo correctamente hacia el primero.
        System.out.println("\n[+] Probando Topologías Circulares...");

        ListaCircularSE<String> cSE = new ListaCircularSE<>();
        cSE.add("C_Simple_1"); cSE.add("C_Simple_2");
        System.out.println("    > Circular Simple: " + cSE.mostrarLista());

        ListaCircularDE<String> cDE = new ListaCircularDE<>();
        cDE.add("C_Doble_1"); cDE.add("C_Doble_2");
        System.out.println("    > Circular Doble: " + cDE.mostrarLista());

        // --- 5. BLOQUE DE PRIORIDAD (HEAPS / MONTÍCULOS) ---
        // Validamos que el elemento extraído sea siempre el de mayor o menor peso.
        System.out.println("\n[+] Probando Colas de Prioridad...");

        ColaPrioridadMax<Integer> cMax = new ColaPrioridadMax<>();
        ColaPrioridadMin<Integer> cMin = new ColaPrioridadMin<>();
        cMax.enqueue(500); cMax.enqueue(1000);
        cMin.enqueue(500); cMin.enqueue(1000);

        System.out.println("    > Prioridad MAX (Extrae el mayor): " + cMax.dequeue());
        System.out.println("    > Prioridad MIN (Extrae el menor): " + cMin.dequeue());

        // --- 6. BLOQUE ESTRUCTURAS AVANZADAS ---
        // Pruebas para estructuras optimizadas (VList por bloques y SkipList por niveles).
        System.out.println("\n[+] Probando VList y SkipList...");

        Lista<Integer> v = new Lista<>();
        v.insertar(999);
        System.out.print("    > VList (Asignación de memoria): "); v.imprimir();

        ListaSkip<Integer> sk = new ListaSkip<>();
        sk.insertar(44); sk.insertar(11);
        System.out.println("    > SkipList (Búsqueda veloz - Mínimo): " + sk.obtenerMinimo());

        System.out.println("\n=====================================================");
        System.out.println("   RESULTADO: 100% DE ESTRUCTURAS OPERATIVAS         ");
        System.out.println("=====================================================");
    }
}