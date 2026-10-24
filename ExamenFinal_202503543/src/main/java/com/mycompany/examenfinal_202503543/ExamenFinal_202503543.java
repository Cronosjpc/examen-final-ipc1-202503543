

package com.mycompany.examenfinal_202503543;


public class ExamenFinal_202503543 {

    public static void main(String[] args) {
        Playlist miLista = new Playlist();
        miLista.agregarCancion(new Cancion("Superpowers", 300, "Daniel Caesar"));
        miLista.agregarCancion(new Cancion("Valentina", 200,"Daniel Caesar"));
        miLista.agregarCancion(new Cancion("Who Knows", 120, "Daniel Caesar"));
        
        miLista.mostrarPlaylist(); // 1. Mostrar las 3
        miLista.siguiente();       // 2. Avanza a cancion 2
        miLista.siguiente();       // 3. Avanza a cancion 3
        miLista.anterior();        // 4. Regresa a cancion 2
        miLista.eliminarActual();  // 5. Borra la cancion 2
        miLista.mostrarPlaylist(); // 6. Muestra que solo quedo la 1 y la 3
    }
}