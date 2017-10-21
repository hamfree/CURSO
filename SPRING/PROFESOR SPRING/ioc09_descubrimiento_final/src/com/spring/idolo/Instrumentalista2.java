package com.spring.idolo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Instrumentalista2
    implements Actuante
{
    private Instrumento instrumento;
    private String song = "Yesterday";

    public String getSong()
    {
        return song;
    }

    @Override
    public void actuar() throws ActuacionException
    {
        System.out.format( "Tocando %s: ", song );
        instrumento.play();
    }

    @Autowired
    public void setInstrumento( Instrumento instrumento )
    {
        this.instrumento = instrumento;
    }

    public void setSong( String song )
    {
        this.song = song;
    }
}
