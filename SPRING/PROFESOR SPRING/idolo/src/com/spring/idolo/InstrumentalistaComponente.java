package com.spring.idolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component( value = "paco" )
public class InstrumentalistaComponente implements Actuante
{
    private Instrumento instrumento;

    @Override
    public void actuar() throws ActuacionException
    {
        System.out.print( "Instrumentalista anotado tocando el instrumento: " );
        instrumento.play();
    }

    @Autowired
    public void setInstrument( Instrumento instrumento )
    {
        this.instrumento = instrumento;
    }
}
