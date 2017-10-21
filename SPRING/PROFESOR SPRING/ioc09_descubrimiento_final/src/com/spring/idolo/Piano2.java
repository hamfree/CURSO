package com.spring.idolo;

import org.springframework.stereotype.Component;

@Component
public class Piano2
    implements Instrumento
{
    @Override
    public void play()
    {
        System.out.println( "piano2 piano2 piano2" );
    }
}
