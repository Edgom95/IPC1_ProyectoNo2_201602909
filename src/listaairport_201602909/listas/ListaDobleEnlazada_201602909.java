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
    
    public int tamaño(){
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
    
    public Avion_201602909 buscar(int turno){
        NodoAvion_201602909 aux=inicio;
        Avion_201602909 avion = null;
        while(aux!=null){
           if(aux.getAvion().NoTurnos==turno){
           avion=aux.getAvion();
           }
           aux=aux.getSiguiente();
        }
        return avion;
    } 
    
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
            if (aux.getAvion().getNoTurnos() > 0) {
                aux.getAvion().setNoTurnos(aux.getAvion().getNoTurnos() - 1);
            } else {
                aux.getAvion().setNoTurnos(0);
            }
            aux = aux.getSiguiente();
        }
    }
    
    public void infoDot() {
        String cadena = "";

        File archivo = new File("ListaAviones.dot");

        if (!estaVacia()) {
            cadena += "nodo" + inicio.hashCode() + "[label=\"" + "Avion " + inicio.getAvion().getNombre()+ "\n" + " NoPasajeros: " + inicio.getAvion().getNoPasajeros()+ "\n" + " NoTurnos: " + inicio.getAvion().getNoTurnos()+ "\n" + " TurnosMantenimiento: " + inicio.getAvion().getNoTurnosMantenimiento() + "\"];\n";
            String anterior = "nodo" + inicio.hashCode();
            NodoAvion_201602909 aux = inicio.getSiguiente();
            while (aux != null) {
                cadena += "nodo" + aux.hashCode() + "[label=\"" + "Avion " + aux.getAvion().getNombre()+ "\n" + " NoPasajeros: " + aux.getAvion().getNoPasajeros()+ "\n" + " NoTurnos: " + aux.getAvion().getNoTurnos()+ "\n" + " TurnosMantenimiento: " + aux.getAvion().getNoTurnosMantenimiento() + "\"];\n";
                cadena += anterior + "->"+ "nodo" + aux.hashCode()+ "[dir=both]" + ";\n";
                anterior = "nodo" + aux.hashCode();
                aux = aux.getSiguiente();
            }
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println("digraph ListaDobleEnlazada {");
                pw.println("rankdir=UD");
                pw.println("node [margin=0 fontcolor=black fontsize=48 width=0.8 shape=invhouse style=filled]");
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
