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
public class NodoCola_201602909 {

    public Cola_201602909 Cola;
    public NodoCola_201602909 Siguiente;
    public NodoCola_201602909 Anterior;

    public NodoCola_201602909(Cola_201602909 cola) {
        setCola(cola);
    }

    public NodoCola_201602909(Cola_201602909 cola, NodoCola_201602909 Siguiente, NodoCola_201602909 Anterior) {
        setCola(cola);
        setSiguiente(Siguiente);
        setAnterior(Anterior);
    }

    public Cola_201602909 getCola() {
        return Cola;
    }

    public void setCola(Cola_201602909 cola) {
        this.Cola = cola;
    }

    public NodoCola_201602909 getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoCola_201602909 Siguiente) {
        this.Siguiente = Siguiente;
    }

    public NodoCola_201602909 getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoCola_201602909 Anterior) {
        this.Anterior = Anterior;
    }
}
