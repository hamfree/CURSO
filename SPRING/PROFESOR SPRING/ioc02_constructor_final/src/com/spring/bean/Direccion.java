package com.spring.bean;

public class Direccion
{
    private String calle;
    private String codigoPostal;

    public Direccion( String calle )
    {
        this.calle = calle;
    }

    public String getCalle()
    {
        return calle;
    }

    public void setCalle( String calle )
    {
        this.calle = calle;
    }

    public String getCodigoPostal()
    {
        return codigoPostal;
    }

    public void setCodigoPostal( String codigoPostal )
    {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString()
    {
        return "[Direccion: " + "calle=" + calle + ", codigoPostal=" + codigoPostal + ']';
    }
}
