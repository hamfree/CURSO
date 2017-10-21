package com.spring.idolo;

import org.springframework.beans.factory.annotation.Autowired;

public class InstrumentalistaAnotado implements Actuante
{
    private Instrumento instrumento;

    @Override
    public void actuar() throws ActuacionException
    {
        System.out.print( "Instrumenalist annotated playing the instrumento: " );
        instrumento.play();
    }

    @Autowired
    public void setInstrument( Instrumento instrumento )
    {
        this.instrumento = instrumento;
    }
}
