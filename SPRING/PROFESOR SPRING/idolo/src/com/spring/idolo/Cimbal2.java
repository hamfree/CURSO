package com.spring.idolo;

import org.springframework.stereotype.Component;

@Component
public class Cimbal2 implements Instrumento
{
    @Override
    public void play()
    {
        System.out.println( "cimbal2 cimbal2 cimbal2" );
    }
}
