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
    public int documento;
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
    
    public void insertar(int documento){
    NodoPasajero_201602909 nuevo = new NodoPasajero_201602909(documento);
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
    
    public int sacar(){
    int maleta = inicio.getDocumentos();
    inicio=inicio.getSiguiente();
    return maleta;
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
    
    public void descontarTurnoPasajero() {
        NodoPasajero_201602909 aux = inicio;
        while (aux != null) {
            aux.getPasajero().setNoTurnos(aux.getPasajero().getNoTurnos() - 1);
            aux = aux.getSiguiente();
        }
    }
    
    public void infoDot() {
        String cadena = "";

        File archivo = new File("ListaPasajeros.dot");

        if (!estaVacio()) {
            cadena += "nodo" + inicio.hashCode() + "[label=\"" + "Pasajero " + inicio.getPasajero().getNombre() + "\n" + " NoMaletas: " + inicio.getPasajero().NoMaletas + "\n" + " NoDocumentos: " + inicio.getPasajero().getNoDocumentos() + "\n" + " Turnos: " + inicio.getPasajero().NoTurnos + "\"];\n";
            String anterior = "nodo" + inicio.hashCode();
            NodoPasajero_201602909 aux = inicio.getSiguiente();
            while (aux != null) {
                cadena += "nodo" + aux.hashCode() + "[label=\"" + "Pasajero " + aux.getPasajero().Nombre + "\n" + " NoMaletas: " + aux.getPasajero().getNoMaletas() + "\n" + " NoDocumentos: " + aux.getPasajero().getNoDocumentos() + "\n" + " Turnos: " + aux.getPasajero().getNoTurnos() + "\"];\n";
                cadena += anterior + "->" + "nodo" + aux.hashCode() + ";\n";
                anterior = "nodo" + aux.hashCode();
                aux = aux.getSiguiente();
            }
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println("digraph ListaEnlazadaSimple {");
                pw.println("rankdir=UD");
                pw.println("node [margin=0 fontcolor=blue fontsize=48 width=0.3 shape=parallelogram style=filled]");
                pw.println(cadena);
                pw.println("} \n");
                pw.close();
                bw.close();
            } catch (IOException e) {
            }
        }
    }

    public void GenImagen(String Dot, String Png) {
        try {
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String cmd = dotPath + " -Tjpg " + Dot + " -o " + Png;
            Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
