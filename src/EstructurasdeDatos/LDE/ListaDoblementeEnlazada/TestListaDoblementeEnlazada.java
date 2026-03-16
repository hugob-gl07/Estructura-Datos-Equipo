package EstructurasdeDatos.LDE.ListaDoblementeEnlazada;
public class TestListaDoblementeEnlazada {
    public static void main(String[] args) {

        System.out.println("=== LISTA DE REPRODUCCIÓN MUSICAL ===\n");

        // -------------------------------------------------------
        // TEST LISTA DOBLEMENTE ENLAZADA
        // Las canciones se guardan en orden de inserción
        // -------------------------------------------------------
        System.out.println("--- LISTA DE REPRODUCCIÓN NORMAL (orden de inserción) ---");
        ListaDoblementeEnlazada<String> playlist = new ListaDoblementeEnlazada<>(); // Creamos la lista de reproducción

        // Añadimos canciones al final de la lista
        System.out.println("Añadiendo canciones...");
        playlist.add("Bohemian Rhapsody"); // Añadimos Bohemian Rhapsody al final
        playlist.add("Stairway to Heaven"); // Añadimos Stairway to Heaven al final
        playlist.add("Hotel California"); // Añadimos Hotel California al final
        playlist.add("Imagine"); // Añadimos Imagine al final
        playlist.add("Smells Like Teen Spirit"); // Añadimos Smells Like Teen Spirit al final
        System.out.println("Playlist actual: " + playlist); // Imprimimos la playlist usando toString()
        System.out.println("Número de canciones: " + playlist.getSize()); // Imprimimos el número de canciones

        // Consultamos la primera y última canción
        System.out.println("\n--- Consultando canciones ---");
        System.out.println("Primera canción: " + playlist.getFirst()); // Imprimimos la primera canción sin eliminarla
        System.out.println("Última canción: " + playlist.getLast()); // Imprimimos la última canción sin eliminarla

        // Añadimos una canción al inicio
        System.out.println("\n--- Añadiendo canción al inicio ---");
        playlist.addFirst("Back in Black"); // Añadimos Back in Black al inicio de la lista
        System.out.println("Playlist tras añadir al inicio: " + playlist); // Imprimimos la playlist actualizada

        // Obtenemos una canción por posición
        System.out.println("\n--- Obteniendo canciones por posición ---");
        System.out.println("Canción en posición 0: " + playlist.getAt(0)); // Imprimimos la canción en posición 0
        System.out.println("Canción en posición 3: " + playlist.getAt(3)); // Imprimimos la canción en posición 3

        // Insertamos una canción en una posición concreta
        System.out.println("\n--- Insertando canción en posición 2 ---");
        playlist.insertAt(2, "Purple Haze"); // Insertamos Purple Haze en la posición 2
        System.out.println("Playlist tras insertar en posición 2: " + playlist); // Imprimimos la playlist actualizada

        // Buscamos una canción por valor
        System.out.println("\n--- Buscando canciones ---");
        System.out.println("Buscando Imagine: " + playlist.get("Imagine")); // Buscamos Imagine por valor
        System.out.println("Buscando Thriller: " + playlist.get("Thriller")); // Buscamos Thriller que no existe

        // Eliminamos una canción por valor
        System.out.println("\n--- Eliminando canción por valor ---");
        System.out.println("Eliminando Hotel California: " + playlist.del("Hotel California")); // Eliminamos Hotel California por valor
        System.out.println("Playlist tras eliminar: " + playlist); // Imprimimos la playlist actualizada

        // Eliminamos canciones por posición
        System.out.println("\n--- Eliminando canciones por posición ---");
        System.out.println("Eliminando posición 0: " + playlist.removeAt(0)); // Eliminamos la canción en posición 0
        System.out.println("Playlist tras eliminar posición 0: " + playlist); // Imprimimos la playlist actualizada

        // Eliminamos la primera y última canción
        System.out.println("\n--- Eliminando primera y última canción ---");
        System.out.println("Eliminando primera canción: " + playlist.removeFirst()); // Eliminamos y devolvemos la primera canción
        System.out.println("Eliminando última canción: " + playlist.removeLast()); // Eliminamos y devolvemos la última canción
        System.out.println("Playlist tras eliminar primera y última: " + playlist); // Imprimimos la playlist actualizada

        // Vaciamos la playlist
        System.out.println("\n--- Vaciando playlist ---");
        playlist.clear(); // Vaciamos la lista eliminando todos los elementos
        System.out.println("¿Playlist vacía? " + playlist.isEmpty()); // Comprobamos si la lista está vacía

        // -------------------------------------------------------
        // TEST LISTA DOBLEMENTE ENLAZADA ORDENADA
        // Las canciones se guardan en orden alfabético
        // -------------------------------------------------------
        System.out.println("\n--- LISTA DE REPRODUCCIÓN ORDENADA (orden alfabético) ---");
        LDEOrdenada<String> playlistOrdenada = new LDEOrdenada<>(); // Creamos la lista de reproducción ordenada

        // Añadimos canciones en desorden
        System.out.println("Añadiendo canciones en desorden...");
        playlistOrdenada.add("Stairway to Heaven"); // Se insertará en su posición alfabética
        playlistOrdenada.add("Bohemian Rhapsody"); // Se insertará en su posición alfabética
        playlistOrdenada.add("Imagine"); // Se insertará en su posición alfabética
        playlistOrdenada.add("Hotel California"); // Se insertará en su posición alfabética
        playlistOrdenada.add("Smells Like Teen Spirit"); // Se insertará en su posición alfabética
        System.out.println("Playlist ordenada: " + playlistOrdenada); // Imprimimos la playlist ordenada
        System.out.println("Número de canciones: " + playlistOrdenada.getSize()); // Imprimimos el número de canciones

        // Consultamos la primera y última canción
        System.out.println("\n--- Consultando canciones ---");
        System.out.println("Primera canción (alfabéticamente): " + playlistOrdenada.getFirst()); // Imprimimos la primera canción alfabéticamente
        System.out.println("Última canción (alfabéticamente): " + playlistOrdenada.getLast()); // Imprimimos la última canción alfabéticamente

        // Añadimos una canción que va al inicio alfabéticamente
        System.out.println("\n--- Añadiendo canción que va al inicio ---");
        playlistOrdenada.add("Angie"); // Angie va al inicio al ser la primera alfabéticamente
        System.out.println("Playlist tras añadir Angie: " + playlistOrdenada); // Imprimimos la playlist actualizada

        // Añadimos una canción que va al final alfabéticamente
        System.out.println("\n--- Añadiendo canción que va al final ---");
        playlistOrdenada.add("Yesterday"); // Yesterday va al final al ser la última alfabéticamente
        System.out.println("Playlist tras añadir Yesterday: " + playlistOrdenada); // Imprimimos la playlist actualizada

        // Buscamos una canción por valor
        System.out.println("\n--- Buscando canciones ---");
        System.out.println("Buscando Imagine: " + playlistOrdenada.get("Imagine")); // Buscamos Imagine por valor
        System.out.println("Buscando Thriller: " + playlistOrdenada.get("Thriller")); // Buscamos Thriller que no existe

        // Eliminamos una canción por valor
        System.out.println("\n--- Eliminando canción por valor ---");
        System.out.println("Eliminando Bohemian Rhapsody: " + playlistOrdenada.del("Bohemian Rhapsody")); // Eliminamos Bohemian Rhapsody por valor
        System.out.println("Playlist tras eliminar: " + playlistOrdenada); // Imprimimos la playlist actualizada

        // Eliminamos la primera y última canción
        System.out.println("\n--- Eliminando primera y última canción ---");
        System.out.println("Eliminando primera canción: " + playlistOrdenada.removeFirst()); // Eliminamos y devolvemos la primera canción
        System.out.println("Eliminando última canción: " + playlistOrdenada.removeLast()); // Eliminamos y devolvemos la última canción
        System.out.println("Playlist tras eliminar primera y última: " + playlistOrdenada); // Imprimimos la playlist actualizada

        // Vaciamos la playlist
        System.out.println("\n--- Vaciando playlist ---");
        playlistOrdenada.clear(); // Vaciamos la lista eliminando todos los elementos
        System.out.println("¿Playlist vacía? " + playlistOrdenada.isEmpty()); // Comprobamos si la lista está vacía
    }
}