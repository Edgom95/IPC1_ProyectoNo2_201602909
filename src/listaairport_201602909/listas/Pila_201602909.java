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
public class Pila_201602909 extends ListaEnlazadaSimple_201602909 {
    
    public Pila_201602909(String nombre) {
        super(nombre);
    }
    
    public void push(int documento){
    super.insertar(documento);
    }
    
    public int poop(){
    return super.sacar();
    }
    
    public boolean vacia(){
    return super.estaVacio();
    } 
}
