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
public class Protoss extends Escuadron {

    /*
    Los Protoss dependen de los pilones, que otorgan un radio para que la
mayoría de sus instalaciones funcionen. Cada pilón aumenta el ataque y
la defensa en un 50%.
     */
    private double pilon;

    public Protoss(double pilon, String nombre, int numvictorias, double nivelataque, double niveldefensa) {
        super(nombre, numvictorias, nivelataque, niveldefensa);
        this.pilon = pilon;
    }

    public double getPilon() {
        return pilon;
    }

    public void setPilon(int pilon) {
        this.pilon = pilon;
    }

    @Override
    public double calcularAtaque() {
        return ((pilon) * 0.50) + getNivelataque();
    }

    @Override
    public double calcularDefensa() {
     return ((pilon) * 0.50) + getNiveldefensa();
    }

}
