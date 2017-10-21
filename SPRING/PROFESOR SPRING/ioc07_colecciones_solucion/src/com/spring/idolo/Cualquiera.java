package com.spring.idolo;

public class Cualquiera
    implements Poema
{
    private final String poema;

    public Cualquiera( String poema )
    {
        this.poema = poema;
    }

    @Override
    public void recitar()
    {
        System.out.format( "%s%n", poema );
    }
}
