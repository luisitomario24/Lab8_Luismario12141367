package Lab8;

import java.awt.Color;
import java.util.Random;

public class Nascar extends Auto {

    private Random numeroRandom = new Random();

    public Nascar(int numeroUnico, double distanciaRecorrida, String nombreCorredor, Color color) {
        super(numeroUnico, distanciaRecorrida, nombreCorredor, color);
    }

    @Override
    public int distanciaRecorrida() {
        return numeroRandom.nextInt(180 - 40) + 40;
    }

}
