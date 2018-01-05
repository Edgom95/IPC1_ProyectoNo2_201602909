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
public class Cola_201602909 {

    public NodoPasajero_201602909 Raiz, Fondo;
    public int longitud;

    public Cola_201602909() {
        this.Raiz = null;
        this.Fondo = null;
        this.longitud = 0;
    }

    public boolean estaVacia() {
        if (Raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertar(Pasajero_201602909 pasajero) {
        NodoPasajero_201602909 nuevo = new NodoPasajero_201602909(pasajero);
        if (estaVacia()) {
            Raiz = nuevo;
        } else {
           NodoPasajero_201602909 aux = Raiz;
            
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
        }
        longitud++;
    }

    public Pasajero_201602909 extraer() {
        Pasajero_201602909 pass;
        if (estaVacia()) {
            return null;
        }
        pass = Raiz.getPasajero();
        Raiz = Raiz.getSiguiente();
        longitud--;
        if (longitud == 0) {
            Fondo = null;
        }
        return pass;
    }

}
