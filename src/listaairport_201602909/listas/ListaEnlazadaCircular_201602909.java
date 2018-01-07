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
public class ListaEnlazadaCircular_201602909 {
    
    public NodoPasajero_201602909 Inicio;
    public NodoPasajero_201602909 Fin;
    public String Nombre;
    public int Maletas;
    public int tamaño=0;

    public ListaEnlazadaCircular_201602909(String Nombre) {
        this.Nombre = Nombre;
        this.Inicio=null;
        this.Fin=null;
    }

    public int Tamaño() {
        return tamaño;
    }

    public boolean estaVacio() {
        if (Inicio == null) {
            return true;
        } else {
            return false;
        }
    }
        
    public void insertarInicio(int maleta) {
        NodoPasajero_201602909 nuevo = new NodoPasajero_201602909(maleta);
        if(estaVacio()){
        Inicio=nuevo;
        Inicio.setSiguiente(nuevo);
        nuevo.setAnterior(Fin);
        Fin=nuevo;
        }else{
            Fin.setSiguiente(nuevo);
            nuevo.setSiguiente(Inicio);
            nuevo.setAnterior(Fin);
            Fin=nuevo;
            Inicio.setAnterior(Fin);
        }
        tamaño++;
    }
    
    public void ImprimirLista(){
     NodoPasajero_201602909 actual=Inicio;
     do{
         System.out.println(actual.getDocumentos());
         actual=actual.getSiguiente();
     }while(actual!=Inicio);
    }
    
    public void eliminarMaleta(int maleta) {
    NodoPasajero_201602909 actual=Inicio;
    NodoPasajero_201602909 ant = Fin;
    
    do{
        if(actual.getDocumentos()==maleta){
            if(actual==Inicio){
            Inicio=Inicio.getSiguiente();
            Fin.setSiguiente(Inicio);
            Inicio.setAnterior(Fin);
            }else if(actual==Fin){
            Fin=ant;
            Inicio.setAnterior(Fin);
            Fin.setSiguiente(Inicio);
            }else{
            ant.setSiguiente(actual.getSiguiente());
            actual.getSiguiente().setAnterior(ant);
            }
        }
    ant=actual;
    actual=actual.getSiguiente();
    }while(actual!=Inicio);
    }
    
     public void infoDot() {
        String cadena = "";

        File archivo = new File("ListaMaletas.dot");

        if (!estaVacio()) {
            cadena += "nodo" + Inicio.hashCode() + "[label=\"" + "Maleta " + Inicio.getDocumentos()+ "\n\"];\n";
            String anterior = "nodo" + Inicio.hashCode();
            NodoPasajero_201602909 aux = Inicio.getSiguiente();
            do {
                cadena += "nodo" + aux.hashCode() + "[label=\"" + "Maleta " + aux.getDocumentos()+ "\"];\n";
                cadena += anterior + "->"+ "nodo" + aux.hashCode()+ "[dir=both]" + ";\n";
                anterior = "nodo" + aux.hashCode();
                aux = aux.getSiguiente();
            }while (aux != Inicio);
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println("digraph ListaEnlazadaCircular {");
                pw.println("rankdir=RL");
                pw.println("node [margin=0 fontcolor=green fontsize=48 width=0.8 shape=folder style=filled]");
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
