package com.spring.bean03;

public class Direccion
{
    private final String calle;
    private final String ciudad;

    public Direccion( String calle, String ciudad )
    {
        this.calle = calle;
        this.ciudad = ciudad;
    }

    public String getCalle()
    {
        return calle;
    }

    public String getCiudad()
    {
        return ciudad;
    }
}
