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
public class Zerg extends Escuadron {

    /*
    Los Zerg basan su fuerza en la cantidad. Mientras más esbirros tenga un
escuadrón, más poderoso es. 
    Cada esbirro aumenta el ataque del
campeón Zerg en un 15%, y su defensa en un 30%. Además, los Zerg
disponen de unidades especiales llamadas overlords (superamos), que les
otorgan un incremento en su fuerza de ataque de un 40%.
     */
    private double cantidadesbirros;

    private int overlords;

    public Zerg(double cantidadesbirros, int overlords, String nombre, int numvictorias, int nivelataque, int niveldefensa) {
        super(nombre, numvictorias, nivelataque, niveldefensa);
        this.cantidadesbirros = cantidadesbirros;
        this.overlords = overlords;
    }

    public int getOverlords() {
        return overlords;
    }

    public void setOverlords(int overlords) {
        this.overlords = overlords;
    }

    public double getCantidadEsbirros() {
        return cantidadesbirros;
    }

    public void setCantidadEsbirros(double cantidadesbirros) {
        this.cantidadesbirros = cantidadesbirros;
    }

    @Override
    public double calcularAtaque() {
        double x = ((cantidadesbirros) * 0.15) + getNivelataque();
        return +((overlords) * 0.50);
    }

    @Override
    public double calcularDefensa() {
        return ((cantidadesbirros) * 0.30) + getNiveldefensa();

    }

}
