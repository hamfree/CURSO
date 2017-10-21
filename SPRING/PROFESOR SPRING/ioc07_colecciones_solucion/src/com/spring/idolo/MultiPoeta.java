package com.spring.idolo;

public class MultiPoeta
    implements Actuante
{
    private Poema[] poemas;

    public MultiPoeta()
    {
    }

    public Poema[] getPoemas()
    {
        return poemas;
    }

    public void setPoemas( Poema[] poemas )
    {
        this.poemas = poemas;
    }

    @Override
    public void actuar() throws ActuacionException
    {
        for ( Poema p : poemas ) {
            p.recitar();
        }
    }
}
