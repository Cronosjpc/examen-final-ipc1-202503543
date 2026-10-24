
package com.mycompany.examenfinal_202503543;


public class Playlist {
    
    private NodoDoble cabeza; 
    private NodoDoble cola; 
    private NodoDoble actual; 
    private int tamanio;
    
    
    public Playlist() {
        this.cabeza = null;
        this.cola = null;
        this.actual = null;
        this.tamanio = 0;
    }
    
   
    public void agregarCancion(Cancion c) {
        NodoDoble nuevo = new NodoDoble(c); 
        
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            actual = nuevo; 
        } else { 
            cola.setSiguiente(nuevo); 
            nuevo.setAnterior(cola); 
            cola = nuevo; 
        }
        tamanio++;
    }
    
 
    public void mostrarPlaylist() {
        System.out.println("\n--- PLAYLIST CHRISTIAN (" + tamanio + " canciones) ---");
        NodoDoble explorador = cabeza;
        while (explorador != null) {
            
            if (explorador == actual) {
                System.out.print("-> ");
            } else {
                System.out.print("   ");
            }
            System.out.println(explorador.getDato().getTitulo() + " - " + explorador.getDato().getArtista());
            explorador = explorador.getSiguiente(); 
        }
        System.out.println("---------------------------------");
    }
}
