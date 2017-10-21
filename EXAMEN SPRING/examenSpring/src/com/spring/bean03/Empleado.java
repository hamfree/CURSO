package com.spring.bean03;

public class Empleado
{
    private final String nombre;
    private Direccion direccion;

    public Empleado( String nombre )
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public Direccion getDireccion()
    {
        return direccion;
    }

    public void setDireccion( Direccion direccion )
    {
        this.direccion = direccion;
    }
}
