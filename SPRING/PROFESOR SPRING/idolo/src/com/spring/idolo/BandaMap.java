package com.spring.idolo;

import java.util.Map;

public class BandaMap implements Actuante
{
    private Map<String, Instrumento> instrumentos;

    @Override
    public void actuar() throws ActuacionException
    {
        for ( String key : instrumentos.keySet() ) {
            Instrumento instrumento = instrumentos.get( key );
            System.out.format( "%s : ", key );
            instrumento.play();
        }
    }

    public void setInstruments( Map<String, Instrumento> instrumentos )
    {
        this.instrumentos = instrumentos;
    }
}
