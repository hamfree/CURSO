package com.spring.idolo;

public class Gamoneda
    implements Poema
{
    @Override
    public void recitar()
    {
        System.out.format( "Cada mañana ponía en los arroyos acero y lágrimas...%n" );
    }
}
