
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

    public Cancion siguiente() {
        if (actual == null || actual.getSiguiente() == null) {
            System.out.println("No hay mas canciones adelante.");
            return null; 
        }
        actual = actual.getSiguiente(); 
        System.out.print("Siguiente >> ");
        actual.getDato().reproducir(); 
        return actual.getDato();
    }
    
    public Cancion anterior() {
        if (actual == null || actual.getAnterior() == null) {
            System.out.println("No hay canciones atras.");
            return null; 
        }
        actual = actual.getAnterior(); 
        System.out.print("Anterior << ");
        actual.getDato().reproducir(); 
        return actual.getDato();
    }
    

    public void eliminarActual() {
        if (actual == null) return; 
        
        System.out.println("Borrando cancion: " + actual.getDato().getTitulo());
        
        // Caso 1: Es el unico nodo
        if (actual == cabeza && actual == cola) {
            cabeza = null;
            cola = null;
            actual = null;
        } 
        // Caso 2: Borrar la cabeza
        else if (actual == cabeza) {
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) {
                cabeza.setAnterior(null); 
            }
            actual = cabeza; 
        }
        // Caso 3: Borrar la cola
        else if (actual == cola) {
            cola = cola.getAnterior();
            if (cola != null) {
                cola.setSiguiente(null); 
            }
            actual = cola; 
        }
        // Caso 4: Borrar la de enmedio
        else {
            NodoDoble atras = actual.getAnterior();
            NodoDoble adelante = actual.getSiguiente();
            
            if (atras != null) atras.setSiguiente(adelante);
            if (adelante != null) adelante.setAnterior(atras);
            
            actual = adelante; 
        }
        tamanio--;
    }
}