
package Lab8;

import java.awt.Color;
import java.util.Random;


public class Convertible extends Auto{
    private Random numeroRandom = new Random();
    public Convertible(int numeroUnico, double distanciaRecorrida, String nombreCorredor, Color color) {
        super(numeroUnico, distanciaRecorrida, nombreCorredor, color);
    }

    @Override
    public int distanciaRecorrida() {
       return numeroRandom.nextInt(200-20)+20; 
    }
    
}
