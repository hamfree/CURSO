package com.spring.bean05;

import java.util.List;

public class Floristeria
{
    private final String nombre;
    private List<String> stock;

    public Floristeria( String nombre )
    {
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public List<String> getStock()
    {
        return stock;
    }

    public void setStock( List<String> stock )
    {
        this.stock = stock;
    }
}
