package com.spring.bean06;

public class Despacho
{
    private final String ubicacion;
    private final int capacidad;

    public Despacho( String ubicacion, int capacidad )
    {
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }

    public String getUbicacion()
    {
        return ubicacion;
    }

    public int getCapacidad()
    {
        return capacidad;
    }

}
