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
public class ListaSimpleCola_201602909 {

public NodoColaPila_201602909 Inicio;
public NodoColaPila_201602909 Fin;
public Cola_201602909 Cola;
public String Nombre;
public int tamaño;

    public ListaSimpleCola_201602909(String Nombre) {
        this.Inicio = null;
        this.Fin = null;
        this.Nombre = Nombre;
    }
    
    public boolean estaVacio() {
        if (Inicio == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public int tamaño()
    {
    return tamaño;
    }

    public void insertarAlFin(Cola_201602909 cola) {
    NodoColaPila_201602909 nuevo = new NodoColaPila_201602909(cola);
    if(estaVacio()){
    Inicio=nuevo;
    }else{
    NodoColaPila_201602909 aux = Inicio;
    while(aux.getSiguiente()!=null){
    aux=aux.getSiguiente();
    }
    aux.setSiguiente(nuevo);
    }
    tamaño++;
    }
    
    public void eliminar(Cola_201602909 cola) {
        if(Inicio.getCola().equals(cola)){
        Inicio=Inicio.getSiguiente();
        }else{
        NodoColaPila_201602909 aux=Inicio;
        while((aux.getSiguiente().getCola()!=cola)){
        aux=aux.getSiguiente();
        }
        NodoColaPila_201602909 siguiente =aux.getSiguiente().getSiguiente();
        aux.setSiguiente(siguiente);
        }
    }
    
    public Cola_201602909 buscar(Cola_201602909 col) {
        NodoColaPila_201602909 aux = Inicio;
        Cola_201602909 cola = null;
        while (aux != null) {
            if (aux.getCola().equals(col)) {
                cola = aux.getCola();
            }
            aux = aux.getSiguiente();
        }
        return cola;
    }
    
    public void infoDot() {
        String cadena = "";

        File archivo = new File("ListaMantenimiento.dot");

        if (!estaVacio()) {
            cadena += "nodo" + Inicio.hashCode() + "[label=\"" + "Estacion \n"+"Mantenimiento " +"\"];\n";
            String anterior = "nodo" + Inicio.hashCode();
            NodoColaPila_201602909 aux = Inicio.getSiguiente();
            while (aux != null) {
                cadena += "nodo" + aux.hashCode() + "[label=\"" + "Estacion \n"+"Mantenimiento " +"\"];\n";
                cadena += anterior + "->" + "nodo" + aux.hashCode() + ";\n";
                anterior = "nodo" + aux.hashCode();
                aux = aux.getSiguiente();
            }
            try {
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                pw.println("digraph ListaEnlazadaSimple {");
                pw.println("rankdir=RL");
                pw.println("node [margin=0.5 fontcolor=red fontsize=24 width=0.8 shape=component style=filled]");
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
