package ListaCircular.Basado_en_LSE;
public class TestListaCircular {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE TURNOS DE JUGADORES ===\n");

        ListaCircularSE<String> jugadores = new ListaCircularSE<>(); // Creamos la lista circular de jugadores

        // -------------------------------------------------------
        // Añadimos jugadores a la partida
        // -------------------------------------------------------
        System.out.println("--- Añadiendo jugadores ---");
        jugadores.add("Alice");  // Añadimos Alice al final de la lista
        jugadores.add("Bob");    // Añadimos Bob al final de la lista
        jugadores.add("Carlos"); // Añadimos Carlos al final de la lista
        jugadores.add("Diana");  // Añadimos Diana al final de la lista
        jugadores.add("Elena");  // Añadimos Elena al final de la lista
        System.out.println(jugadores.mostrarLista()); // Imprimimos la lista con formato circular
        System.out.println("Número de jugadores: " + jugadores.getSize()); // Imprimimos el número de jugadores

        // -------------------------------------------------------
        // Consultamos jugadores por posición
        // -------------------------------------------------------
        System.out.println("\n--- Consultando jugadores por posición ---");
        System.out.println("Jugador en posición 0: " + jugadores.obtenerPorPosicion(0));  // Imprimimos el jugador en posición 0
        System.out.println("Jugador en posición 2: " + jugadores.obtenerPorPosicion(2));  // Imprimimos el jugador en posición 2
        System.out.println("Jugador en posición 10: " + jugadores.obtenerPorPosicion(10)); // Intentamos obtener un jugador fuera de rango

        // -------------------------------------------------------
        // Comprobamos si un jugador existe
        // -------------------------------------------------------
        System.out.println("\n--- Comprobando jugadores ---");
        System.out.println("¿Existe Alice? " + jugadores.existe("Alice")); // Comprobamos si Alice existe en la lista
        System.out.println("¿Existe Pedro? " + jugadores.existe("Pedro")); // Comprobamos si Pedro existe en la lista

        // -------------------------------------------------------
        // Buscamos un jugador por valor
        // -------------------------------------------------------
        System.out.println("\n--- Buscando jugadores ---");
        System.out.println("Buscando Bob: " + jugadores.get("Bob"));     // Buscamos a Bob por valor
        System.out.println("Buscando Pedro: " + jugadores.get("Pedro")); // Buscamos a Pedro que no existe

        // -------------------------------------------------------
        // Simulamos una ronda de turnos con el iterador
        // -------------------------------------------------------
        System.out.println("\n--- Simulando ronda de turnos ---");
        MiIterador<String> iterador = jugadores.getIterador(); // Creamos un iterador para recorrer la lista una vuelta
        while (iterador.hasNext()) {
            System.out.println("Turno de: " + iterador.next()); // Imprimimos el turno de cada jugador
        }

        // -------------------------------------------------------
        // Un jugador abandona la partida
        // -------------------------------------------------------
        System.out.println("\n--- Jugador abandona la partida ---");
        System.out.println("Carlos abandona: " + jugadores.del("Carlos")); // Eliminamos a Carlos y devolvemos su dato
        System.out.println(jugadores.mostrarLista()); // Imprimimos la lista tras la eliminación

        // -------------------------------------------------------
        // Cambiamos el nombre de un jugador por posición
        // -------------------------------------------------------
        System.out.println("\n--- Cambiando nombre de jugador en posición 1 ---");
        jugadores.cambiarEnPosicion(1, "Roberto"); // Cambiamos el nombre del jugador en posición 1 a Roberto
        System.out.println(jugadores.mostrarLista()); // Imprimimos la lista tras el cambio

        // -------------------------------------------------------
        // Simulamos otra ronda de turnos tras los cambios
        // -------------------------------------------------------
        System.out.println("\n--- Segunda ronda de turnos ---");
        MiIterador<String> iterador2 = jugadores.getIterador(); // Creamos un nuevo iterador para la segunda ronda
        while (iterador2.hasNext()) {
            System.out.println("Turno de: " + iterador2.next()); // Imprimimos el turno de cada jugador
        }

        // -------------------------------------------------------
        // Vaciamos la lista al terminar la partida
        // -------------------------------------------------------
        System.out.println("\n--- Terminando partida ---");
        jugadores.vaciar(); // Vaciamos la lista eliminando todos los jugadores
        System.out.println("¿Lista vacía? " + jugadores.isEmpty()); // Comprobamos si la lista está vacía
    }
}