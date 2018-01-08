/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaairport_201602909.listas;

/**
 *
 * @author edgom
 */
public class NodoColaPila_201602909 {

    public Cola_201602909 Cola;
    public Pila_201602909 Pila;
    public NodoColaPila_201602909 Siguiente;
    public NodoColaPila_201602909 Anterior;

    public NodoColaPila_201602909(Cola_201602909 cola,Pila_201602909 pila) {
        setCola(cola);
        setPila(pila);
    }

    public NodoColaPila_201602909(Cola_201602909 cola, NodoColaPila_201602909 Siguiente, NodoColaPila_201602909 Anterior) {
        setCola(cola);
        setSiguiente(Siguiente);
        setAnterior(Anterior);
    }

    public NodoColaPila_201602909(Cola_201602909 Cola) {
        this.Cola = Cola;
    }
    
    public Cola_201602909 getCola() {
        return Cola;
    }

    public void setCola(Cola_201602909 cola) {
        this.Cola = cola;
    }

    public NodoColaPila_201602909 getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoColaPila_201602909 Siguiente) {
        this.Siguiente = Siguiente;
    }

    public NodoColaPila_201602909 getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoColaPila_201602909 Anterior) {
        this.Anterior = Anterior;
    }

    public Pila_201602909 getPila() {
        return Pila;
    }

    public void setPila(Pila_201602909 Pila) {
        this.Pila = Pila;
    }
    
}
