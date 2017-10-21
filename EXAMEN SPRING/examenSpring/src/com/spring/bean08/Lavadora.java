package com.spring.bean08;

public class Lavadora
    implements ProductorMensaje
{
    @Override
    public String getMensaje()
    {
        return "Si quiere su ropa blanca...";
    }
}
