package com.spring.idolo;

public class Malabarista
        implements Actuante {

    private int bolas = 3;
    

    public Malabarista() {
    }

    public Malabarista(int bolas) {
        this.bolas = bolas;
    }

   
    
    

    @Override
    public void actuar() throws ActuacionException {
        System.out.println("Haciendo malabarismos con " + bolas + " bolas");
    }
}
