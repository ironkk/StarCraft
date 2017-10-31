/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DAM
 */
public abstract class Escuadron {

    /*
    Cada escuadrón tiene las siguientes propiedades comunes:
nombre, número de v ictorias, niv el de ataque y niv el de defensa
     */

    private String nombre;

    private int numvictorias;

    private double nivelataque;

    private double niveldefensa;

    public Escuadron(String nombre, int numvictorias, double nivelataque, double niveldefensa) {
        this.nombre = nombre;
        this.numvictorias = numvictorias;
        this.nivelataque = nivelataque;
        this.niveldefensa = niveldefensa;
    }

    public double getNiveldefensa() {
        return niveldefensa;
    }

    public void setNiveldefensa(int niveldefensa) {
        this.niveldefensa = niveldefensa;
    }

    public double getNivelataque() {
        return nivelataque;
    }

    public void setNivelataque(int nivelataque) {
        this.nivelataque = nivelataque;
    }

    public int getNumvictorias() {
        return numvictorias;
    }

    public void setNumvictorias(int numvictorias) {
        this.numvictorias = numvictorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract double calcularAtaque();

    public abstract double calcularDefensa();
}
