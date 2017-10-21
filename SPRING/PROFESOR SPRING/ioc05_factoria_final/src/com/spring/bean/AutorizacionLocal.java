package com.spring.bean;

public class AutorizacionLocal
    implements Autorizacion
{
    @Override
    public boolean autorizar( int id, double doubleCantidad )
    {
        return id < 10;
    }
}
