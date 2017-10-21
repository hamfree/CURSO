package com.spring.idolo;

public class Calderon
    implements Poema
{
    @Override
    public void recitar()
    {
        System.out.format( "!Ay mísero de mí, hay infelice...%n" );
    }
}
