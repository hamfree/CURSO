package com.spring.idolo;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ControladorTiempo
{
    private long antes;

    @Pointcut( "execution(* com.spring.idolo.Actuante.actuar(..))" )
    public void actuacion()
    {
    }

    @Before( "actuacion()" )
    public void antes()
    {
        antes = System.nanoTime();
    }

    @AfterReturning( "actuacion()" )
    public void despues()
    {
        final long nanosEnMilisegundos = 1_000_000;

        long despues = System.nanoTime();
        long total = ( despues - antes ) / nanosEnMilisegundos;

        System.out.format( "Tiempo de ejecución: %d milisegundos%n", total );
    }
}
