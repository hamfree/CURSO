package com.spring.idolo;

public class ControladorTiempo
{
    private long antes;

    public void antes()
    {
        antes = System.nanoTime();
    }

    public void despues()
    {
        final long nanosEnMilisegundos = 1_000_000;

        long despues = System.nanoTime();
        long total = ( despues - antes ) / nanosEnMilisegundos;

        System.out.format( "Tiempo de ejecución: %d milisegundos%n", total );
    }
}
