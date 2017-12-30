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
public class Avion_201602909 {

    public String Nombre;
    public int NoPasajeros;
    public int NoTurnos;
    public int NoTurnosMantenimiento;

    public Avion_201602909(String nombre, int np, int nt, int ntm) {
        setNombre(nombre);
        setNoPasajeros(np);
        setNoTurnos(nt);
        setNoTurnosMantenimiento(ntm);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNoPasajeros() {
        return NoPasajeros;
    }

    public void setNoPasajeros(int NoPasajeros) {
        this.NoPasajeros = NoPasajeros;
    }

    public int getNoTurnos() {
        return NoTurnos;
    }

    public void setNoTurnos(int NoTurnos) {
        this.NoTurnos = NoTurnos;
    }

    public int getNoTurnosMantenimiento() {
        return NoTurnosMantenimiento;
    }

    public void setNoTurnosMantenimiento(int NoTurnosMantenimiento) {
        this.NoTurnosMantenimiento = NoTurnosMantenimiento;
    }

    @Override
    public String toString() {
        return "Avion_201602909{" + "Nombre=" + Nombre + ", NoPasajeros=" + NoPasajeros + ", NoTurnos=" + NoTurnos + ", NoTurnosMantenimiento=" + NoTurnosMantenimiento + '}';
    }
    
}
