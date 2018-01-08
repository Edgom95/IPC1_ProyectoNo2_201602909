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
public class ListaEnlazadaColaPila_201602909 {

    public Cola_201602909 Cola;
    public Pila_201602909 Pila;
    public String Nombre;
    public NodoColaPila_201602909 inicio;
    public NodoColaPila_201602909 fin;
    public int tamaño = 0;

    public ListaEnlazadaColaPila_201602909(String nombre) {
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

    public int tamaño() {
        return tamaño;
    }

    public void insertarALFin(Cola_201602909 cola,Pila_201602909 pila) {
        NodoColaPila_201602909 nuevo = new NodoColaPila_201602909(cola,pila);
        if (estaVacia()) {
            inicio = nuevo;
            tamaño++;
        } else {
            NodoColaPila_201602909 aux = inicio;

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
            NodoColaPila_201602909 aux = inicio;
            NodoColaPila_201602909 ant = null;

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
    public Cola_201602909 buscar(Cola_201602909 col) {
        NodoColaPila_201602909 aux = inicio;
        Cola_201602909 cola = null;
        while (aux != null) {
            if (aux.getCola().equals(col)) {
                cola = aux.getCola();
            }
            aux = aux.getSiguiente();
        }
        return cola;
    }

    public Pila_201602909 buscar(Pila_201602909 pil) {
        NodoColaPila_201602909 aux = inicio;
        Pila_201602909 pila = null;
        while (aux != null) {
            if (aux.getPila().equals(pil)) {
                pila = aux.getPila();
            }
            aux = aux.getSiguiente();
        }
        return pila;
    }

    public void infoDot() {
        String cadena = "";

        File archivo = new File("ListaEstacionesRegistro.dot");

        if (!estaVacia()) {
            cadena += "nodo" + inicio.hashCode() + "[label=\"" + "Estacion Registro " + "\"];\n";
            String anterior = "nodo" + inicio.hashCode();
            NodoColaPila_201602909 aux = inicio.getSiguiente();
            while (aux != null) {
                cadena += "nodo" + aux.hashCode() + "[label=\"" + "Estacion Registro" + "\"];\n";
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
                pw.println("node [margin=0 fontcolor=purple fontsize=32 width=0.8 shape=hexagon style=filled]");
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
