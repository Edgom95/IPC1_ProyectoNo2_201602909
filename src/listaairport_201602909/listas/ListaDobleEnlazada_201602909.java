/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaairport_201602909.listas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
public int tamaño=0;

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
    
    public int tamañoLista(){
    return tamaño;
    }

    public void insertarAlFin(Avion_201602909 avion) {
        NodoAvion_201602909 nuevo = new NodoAvion_201602909(avion);
        if (estaVacia()) {
            inicio = nuevo;
            tamaño++;
        } else {
            NodoAvion_201602909 aux = inicio;
            
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            tamaño++;
        }
    }
    
    public void ImprimirLista(){
     NodoAvion_201602909 aux= inicio;
      while(aux != null){
       System.out.println(aux.getAvion());
       aux=aux.getSiguiente();
      }
    }
    
    public void eliminarAvion() {

        if (!estaVacia()) {
            NodoAvion_201602909 aux = inicio;
            NodoAvion_201602909 ant = null;

            while (aux != null) {

                if (aux.getAvion().getNoTurnos()==0) {
                    if (ant == null) {
                        inicio = inicio.getSiguiente();
                        aux.setSiguiente(null);
                        aux = inicio;
                        tamaño--;
                    } else {
                        ant.setSiguiente(aux.getSiguiente());
                        aux.setSiguiente(null);
                        aux = ant.getSiguiente();
                        tamaño--;
                    }
                } else {
                    ant = aux;
                    aux = aux.getSiguiente();
                }
            }
        }
    }
    
    public void descontarTurnoAvion() {
        NodoAvion_201602909 aux = inicio;
        while (aux != null) {
            aux.getAvion().setNoTurnos(aux.getAvion().getNoTurnos() - 1);
            aux = aux.getSiguiente();
        }
    }
    
   public void crearDot() {
        File archivo = new File("ListaAviones.dot");
        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.write("digraph G {"+"\n");
            NodoAvion_201602909 aux = inicio;
            while (aux != null) {
            pw.write("Avion: "+aux.getAvion().getNombre()+" No Pasajeros: "+aux.getAvion().getNoPasajeros()+" No Turnos: "+aux.getAvion().getNoTurnos()+" No Turnos Mantenimiento: "+aux.getAvion().getNoTurnosMantenimiento()+" -> "+"\n");
            aux = aux.getSiguiente();
            }
            pw.write("}"+"\n");
            pw.close();
            bw.close();

        } catch (IOException e) {
        }
    }
}
