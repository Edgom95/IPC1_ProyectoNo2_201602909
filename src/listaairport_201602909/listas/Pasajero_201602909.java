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
public class Pasajero_201602909 {

    public int Nombre;
    public int NoMaletas;
    public int NoDocumentos;
    public int NoTurnos;
    
    public Pasajero_201602909(int nombre,int nm,int nd,int nt){
    setNombre(nombre);
    setNoMaletas(nm);
    setNoDocumentos(nd);
    setNoTurnos(nt);
    } 

    public int getNombre() {
        return Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = Nombre;
    }

    public int getNoMaletas() {
        return NoMaletas;
    }

    public void setNoMaletas(int NoMaletas) {
        this.NoMaletas = NoMaletas;
    }

    public int getNoDocumentos() {
        return NoDocumentos;
    }

    public void setNoDocumentos(int NoDocumentos) {
        this.NoDocumentos = NoDocumentos;
    }

    public int getNoTurnos() {
        return NoTurnos;
    }

    public void setNoTurnos(int NoTurnos) {
        this.NoTurnos = NoTurnos;
    }

    @Override
    public String toString() {
        return "Pasajero_201602909{" + "Nombre=" + Nombre + ", NoMaletas=" + NoMaletas + ", NoDocumentos=" + NoDocumentos + ", NoTurnos=" + NoTurnos + '}';
    }        
}
