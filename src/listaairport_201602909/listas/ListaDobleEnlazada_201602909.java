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
public class ListaDobleEnlazada_201602909 
{
public Avion_201602909 Avion;
public String Nombre;
public NodoAvion_201602909 inicio;
public NodoAvion_201602909 fin;

    public ListaDobleEnlazada_201602909(String nombre) {
        this.Nombre=nombre;
        inicio = null;
        fin = inicio;
    }

    public boolean estaVacia() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertarAlFin(Avion_201602909 avion) {
        NodoAvion_201602909 nuevo = new NodoAvion_201602909(avion);
        if (estaVacia()) {
            inicio = nuevo;
        } else {
            NodoAvion_201602909 aux = inicio;
            
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
        }
    }
    
//    public NodoAvion_201602909 buscar(Avion_201602909 avion) {
//        NodoAvion_201602909 aux = inicio;
//        int contador = 0;
//        if (!estaVacia()) {
//
//            while (aux != null) {
//
//                if (aux.getAvion().equals(avion)) {
//                    aux = aux.getSiguiente();
//                    contador++;
//                }
//            }
//        }
//        return aux;
//    }
    
    public void ImprimirLista(){
     NodoAvion_201602909 aux= inicio;
      while(aux != null){
       System.out.println(aux.getAvion());
       aux=aux.getSiguiente();
      }
    }
    
    public void eliminarAvion(Avion_201602909 avion) {

        if (!estaVacia()) {
            NodoAvion_201602909 aux = inicio;
            NodoAvion_201602909 ant = null;

            while (aux != null) {

                if (aux.getAvion().equals(avion)) {
                    if (ant == null) {
                        inicio = inicio.getSiguiente();
                        aux.setSiguiente(null);
                        aux = inicio;
                    } else {
                        ant.setSiguiente(aux.getSiguiente());
                        aux.setSiguiente(null);
                        aux = ant.getSiguiente();
                    }
                } else {
                    ant = aux;
                    aux = aux.getSiguiente();
                }
            }
        }
    }
}
