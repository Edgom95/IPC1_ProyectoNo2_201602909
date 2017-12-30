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
public class NodoAvion_201602909
{

    public Avion_201602909 Avion;
    public NodoAvion_201602909 Siguiente;
    public NodoAvion_201602909 Anterior;

    public NodoAvion_201602909(Avion_201602909 avion) {
        setAvion(avion);
        setSiguiente(null);
        setAnterior(null);
    }

    public NodoAvion_201602909(Avion_201602909 avion, NodoAvion_201602909 sig, NodoAvion_201602909 ant) {
        setAvion(avion);
        setSiguiente(sig);
        setAnterior(ant);
    }

    public NodoAvion_201602909 getSiguiente() {
        return Siguiente;
    }

    public Avion_201602909 getAvion() {
        return Avion;
    }

    public void setAvion(Avion_201602909 Avion) {
        this.Avion = Avion;
    }

    public void setSiguiente(NodoAvion_201602909 Siguiente) {
        this.Siguiente = Siguiente;
    }

    public NodoAvion_201602909 getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoAvion_201602909 Anterior) {
        this.Anterior = Anterior;
    }
}
