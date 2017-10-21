package com.spring.edadmedia;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Juglar2
{
    @Pointcut( "execution(* com.spring.edadmedia.Caballero.emprenderGesta(..))" )
    public void emprender()
    {
    }

    @Before( "emprender()" )
    public void cantarAntesDeGesta()
    {
        System.out.println( "La la la; El caballero es tan valiente!" );
    }

    @AfterReturning( "emprender()" )
    public void cantarDespuesDeGesta()
    {
        System.out.println( "Fiu fiu fiu; El caballero finalizó su hazaña!" );
    }
}
