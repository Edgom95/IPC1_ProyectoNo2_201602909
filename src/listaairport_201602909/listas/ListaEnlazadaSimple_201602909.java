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
public class ListaEnlazadaSimple_201602909 {

    public Pasajero_201602909 Pasajero;
    public String Nombre;
    public NodoPasajero_201602909 inicio;
    public int tamaño;
    public NodoPasajero_201602909 fin;

    public ListaEnlazadaSimple_201602909(String nombre) {
        this.Nombre = nombre;
        inicio = null;
        fin = inicio;
    }
    
    public boolean estaVacio() {
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public int tamaño()
    {
    return tamaño;
    }
    

    public void insertarAlFin(Pasajero_201602909 pasajero) {
    NodoPasajero_201602909 nuevo = new NodoPasajero_201602909(pasajero);
    if(estaVacio()){
    inicio=nuevo;
    }else{
    NodoPasajero_201602909 aux = inicio;
    while(aux.getSiguiente()!=null){
    aux=aux.getSiguiente();
    }
    aux.setSiguiente(nuevo);
    }
    tamaño++;
    }
    
    public void ImprimirLista(){
     NodoPasajero_201602909 aux= inicio;
      while(aux != null){
       System.out.println(aux.getPasajero());
       aux=aux.getSiguiente();
      }
    }
    
    public void eliminarPasajero(Pasajero_201602909 pasajero) {
        if(inicio.getPasajero().equals(pasajero)){
        inicio=inicio.getSiguiente();
        }else{
        NodoPasajero_201602909 aux=inicio;
        while((aux.getSiguiente().getPasajero()!=pasajero)){
        aux=aux.getSiguiente();
        }
        NodoPasajero_201602909 siguiente =aux.getSiguiente().getSiguiente();
        aux.setSiguiente(siguiente);
        }
    }
    
    public void crearDot(){
    File archivo = new File("ListaAviones.dot");
        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            pw.write("digraph G {"+"\n");
            NodoPasajero_201602909 aux = inicio;
            while (aux != null) {
            pw.write("Pasajero: "+aux.getPasajero().getNombre()+" No Maletas: "+aux.getPasajero().getNoMaletas()+" No Documentos: "+aux.getPasajero().getNoDocumentos()+" No Turnos: "+aux.getPasajero().getNoTurnos());
            aux = aux.getSiguiente();
            }
            pw.write("}"+"\n");
            pw.close();
            bw.close();

        } catch (IOException e) {
        }
    }
}
