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
public class Terran extends Escuadron {

    /*
    Los Terran pueden construir edificios en cualquier zona. Por cada edificio
construido, su defensa aumenta en un 25%. Además, la tecnología les
hace más poderosos, por lo que cada v ez que se desarrolla una nuev a
arma, su niv el de ataque también se incrementa en un 50%.
     */
    private int numedificio;

    private int tecnologia;

    public Terran(int numedificio, int tecnologia, String nombre, int numvictorias, int nivelataque, int niveldefensa) {
        super(nombre, numvictorias, nivelataque, niveldefensa);
        this.numedificio = numedificio;
        this.tecnologia = tecnologia;
    }

    public int getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(int tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getNumedificio() {
        return numedificio;
    }

    public void setNumedificio(int numedificio) {
        this.numedificio = numedificio;
    }

    @Override
    public double calcularAtaque() {
        return ((tecnologia) * 0.50) + getNivelataque();
    }

    @Override
    public double calcularDefensa() {
        return ((numedificio) * 0.25) + getNiveldefensa();
    }

}
