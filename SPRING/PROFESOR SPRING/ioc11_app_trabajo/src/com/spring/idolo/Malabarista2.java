package com.spring.idolo;

public class Malabarista2
        implements Actuante {

    private int bolas = 3;
    

    public Malabarista2() {
    }

    public Malabarista2(int bolas) {
        this.bolas = bolas;
    }

   
    
    

    @Override
    public void actuar() throws ActuacionException {
        System.out.println(this.getClass().getSimpleName() + ".actuar() - INICIO");
        esperar();
        System.out.println("Haciendo malabarismos con " + bolas + " bolas");
        System.out.println(this.getClass().getSimpleName() + ".actuar() - FIN");
    }

    /**
     * Este método retendrá la CPU entre 1 y 1000 milisegundos.
     */
    private void esperar() {
        long random = (long) (Math.random() *  1000 + 1);
        try {
            Thread.sleep(random);
        } catch (InterruptedException e){
            
        }
    }
}
