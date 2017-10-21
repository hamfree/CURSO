package com.spring.bean;

public class AutorizacionFactory
{
    public Autorizacion getAutorizacion2( boolean estricto )
    {
        return Math.random() < 0.5 ? new AutorizacionVisa() : new AutorizacionLocal();
    }

    public static Autorizacion getAutorizacion( boolean estricto )
    {
        return Math.random() < 0.5 ? new AutorizacionVisa() : new AutorizacionLocal();
    }
}
