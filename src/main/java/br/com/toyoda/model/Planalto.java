package br.com.toyoda.model;

public enum Planalto {

    MALHA_MARTE(0,5,0,5);
    
    private int coordenadaMinimoX;
    private int coordenadaMinimoY;
    private int coordenadaLimitX;
    private int coordenadaLimitY;

    private Planalto(int coordenadaMinimoX, int coordenadaLimitX, int coordenadaMinimoY, int coordenadaLimitY) {
        this.coordenadaMinimoX = coordenadaMinimoX;
        this.coordenadaLimitX = coordenadaLimitX;
        this.coordenadaMinimoY = coordenadaMinimoY;
        this.coordenadaLimitY = coordenadaLimitY;
    }

    public int getCoordenadaMinimoX() {
        return coordenadaMinimoX;
    }

    public int getCoordenadaMinimoY() {
        return coordenadaMinimoY;
    }

    public int getCoordenadaLimitX() {
        return coordenadaLimitX;
    }

    public int getCoordenadaLimitY() {
        return coordenadaLimitY;
    }
    
}
