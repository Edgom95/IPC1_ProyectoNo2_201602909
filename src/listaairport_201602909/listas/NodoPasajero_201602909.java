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
public class NodoPasajero_201602909 {

    public Pasajero_201602909 Pasajero;
    public NodoPasajero_201602909 Siguiente,Anterior;

    public NodoPasajero_201602909(Pasajero_201602909 pasajero, NodoPasajero_201602909 siguiente,NodoPasajero_201602909 anterior) {
        setPasajero(pasajero);
        setSiguiente(siguiente);
        setAnterior(anterior);
    }

    public NodoPasajero_201602909(Pasajero_201602909 pasajero) {
        this(pasajero, null,null);
    }

    public Pasajero_201602909 getPasajero() {
        return Pasajero;
    }

    public void setPasajero(Pasajero_201602909 Pasajero) {
        this.Pasajero = Pasajero;
    }

    public NodoPasajero_201602909 getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoPasajero_201602909 Siguiente) {
        this.Siguiente = Siguiente;
    }

    public NodoPasajero_201602909 getAnterior() {
        return Anterior;
    }

    public void setAnterior(NodoPasajero_201602909 Anterior) {
        this.Anterior = Anterior;
    }
    
}
