package com.spring.bean07;

import org.springframework.stereotype.Component;

@Component
public class Malabarista
{
    private final int nroBolas = 5;

    public Malabarista()
    {
    }

    public int getNroBolas()
    {
        return nroBolas;
    }
}
