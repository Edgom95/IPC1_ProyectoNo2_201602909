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
    public NodoPasajero_201602909 Siguiente;

    public NodoPasajero_201602909(Pasajero_201602909 pasajero, NodoPasajero_201602909 siguiente) {
        setPasajero(pasajero);
        setSiguiente(siguiente);
    }

    public NodoPasajero_201602909(Pasajero_201602909 pasajero) {
        this(pasajero, null);
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
}
