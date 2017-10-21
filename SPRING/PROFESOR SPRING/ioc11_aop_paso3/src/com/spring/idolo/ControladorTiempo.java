package com.spring.idolo;

import org.aspectj.lang.ProceedingJoinPoint;

public class ControladorTiempo
{
    public void cronometrarActuacion( ProceedingJoinPoint joinpoint )
    {
        try {
            long antes = System.nanoTime();
            joinpoint.proceed();
            long despues = System.nanoTime();
            long nanosInMilis = 1_000_000;
            long total = ( despues - antes ) / nanosInMilis;

            System.out.format( "La actuación duró %d milisegundos%n", total );
        }
        catch( Throwable e ) {
            System.out.format( "Excepcion inesperada %s%n", e.getMessage() );
        }
    }
}
