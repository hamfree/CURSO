package com.spring.idolo;

public class Malabarista2
    implements Actuante
{
    private int bolas = 3;

    public Malabarista2()
    {
    }

    public Malabarista2( int bolas )
    {
        this.bolas = bolas;
    }

    @Override
    public void actuar() throws ActuacionException
    {
        esperar();
        System.out.println( "Haciendo malabarismos con " + bolas + " bolas" );
    }

    private void esperar()
    {
        long random = (long) ( 1 + Math.random() * 1000 );
        try {
            Thread.sleep( random );
        }
        catch( InterruptedException ex ) {
        }
    }
}
