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
public class ListaEnlazadaCola_201602909 {

    public Cola_201602909 Cola;
    public String Nombre;
    public NodoCola_201602909 inicio;
    public NodoCola_201602909 fin;
    public int tamaño = 0;

    public ListaEnlazadaCola_201602909(String nombre) {
        this.Nombre = nombre;
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

    public int tamañoLista() {
        return tamaño;
    }

    public void insertarALFin(Cola_201602909 cola) {
        NodoCola_201602909 nuevo = new NodoCola_201602909(cola);
        if (estaVacia()) {
            inicio = nuevo;
            tamaño++;
        } else {
            NodoCola_201602909 aux = inicio;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
            nuevo.setAnterior(aux);
            tamaño++;
        }
    }
    
    public void eliminarCola(Cola_201602909 cola) {

        if (!estaVacia()) {
            NodoCola_201602909 aux = inicio;
            NodoCola_201602909 ant = null;

            while (aux != null) {

                if (aux.getCola().equals(cola)) {
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
    
    public void infoDot() {
        String cadena = "";

        File archivo = new File("ListaEstacionesRegistro.dot");

        if (!estaVacia()) {
            cadena += "nodo" + inicio.hashCode() + "[label=\"" + "Estacion " + "\"];\n";
            String anterior = "nodo" + inicio.hashCode();
            NodoCola_201602909 aux = inicio;
            while (aux != null) {
                cadena += "nodo" + aux.hashCode() + "[label=\"" + "Estacion " + "\"];\n";
                cadena += anterior + "->"+ "nodo" + aux.hashCode()+ "[dir=both]" + ";\n";
                anterior = "nodo" + aux.hashCode();
                aux = aux.getSiguiente();
            }
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println("digraph ListaDobleEnlazada {");
                pw.println("rankdir=RL");
                pw.println("node [margin=0 fontcolor=black fontsize=48 width=0.8 shape=note style=filled]");
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
