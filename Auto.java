package Lab8;

import java.awt.Color;
import java.io.Serializable;

public abstract class Auto implements Serializable {

    private int numeroUnico;
    private double distanciaRecorrida;
    private String nombreCorredor;
    private Color color;

    private static final long SerialVersionUID = 299L;

    public Auto(int numeroUnico,double distanciaRecorrida, String nombreCorredor, Color color) {
        this.numeroUnico = numeroUnico;
        this.distanciaRecorrida = distanciaRecorrida;
        this.nombreCorredor = nombreCorredor;
        this.color = color;
    }

    public int getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroIdentificador(int numeroIdentificador) {
        this.numeroUnico = numeroIdentificador;
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public String getNombreCorredor() {
        return nombreCorredor;
    }

    public void setNombreCorredor(String nombreCorredor) {
        this.nombreCorredor = nombreCorredor;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{" + "numeroIdentificador=" + numeroUnico + ", distanciaRecorrida=" + distanciaRecorrida + ", nombreCorredor=" + nombreCorredor + ", color=" + color + '}';
    }

    public abstract int distanciaRecorrida();
}
