package Lab8;

import java.awt.Color;
import java.util.Random;

public class Mcqueen extends Auto {
    private Random numeroRandom = new Random();
    public Mcqueen(int numeroUnico, double distanciaRecorrida, String nombreCorredor, Color color) {
        super(numeroUnico, 4, nombreCorredor, color);
    }
    public Random getRand() {
        return numeroRandom;
    }

    public void setRand(Random rand) {
        this.numeroRandom = rand;
    }
    
    public int distanciaRecorrida() {
        return numeroRandom.nextInt(190-30)+30;
    }
    

}
