package com.spring.idolo;

import org.springframework.beans.factory.annotation.Autowired;

public class Instrumentalista2
    implements Actuante
{
    private Instrumento instrumento;

    @Autowired
    public void setInstrumento( Instrumento instrumento )
    {
        this.instrumento = instrumento;
    }

    @Override
    public void actuar() throws ActuacionException
    {
        if ( instrumento != null ) {
            instrumento.play();
        }
        else {
            System.out.format( "No hay instrumento!%n" );
        }
    }
}
