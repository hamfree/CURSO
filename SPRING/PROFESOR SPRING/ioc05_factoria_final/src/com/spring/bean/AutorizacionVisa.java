package com.spring.bean;

public class AutorizacionVisa
    implements Autorizacion
{
    @Override
    public boolean autorizar( int id, double doubleCantidad )
    {
        return doubleCantidad < 10000.00;
    }
}
