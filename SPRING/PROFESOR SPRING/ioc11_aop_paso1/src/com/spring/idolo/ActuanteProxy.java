package com.spring.idolo;

public class ActuanteProxy
    implements Actuante
{
    private final Actuante actuante;

    public ActuanteProxy( Actuante actuante )
    {
        this.actuante = actuante;
    }

    @Override
    public void actuar() throws ActuacionException
    {
        long antes = System.nanoTime();

        actuante.actuar();

        long ahora = System.nanoTime();
        long nanosPorMili = 1_000_000;
        long tiempoTotalEnMilisegundos = ( ahora - antes ) / nanosPorMili;
        System.out.format( "actuar tarda %d milisegundos en ejecutarse%n", tiempoTotalEnMilisegundos );
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
