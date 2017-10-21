package com.spring.ioc;

import java.util.List;

public class Local
{
    private List<String> titulos;
    private String nombre;

    public Local( String nombre, List<String> titulos )
    {
        this.titulos = titulos;
        this.nombre = nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public List<String> getTitulos()
    {
        return titulos;
    }

    public void setTitulos( List<String> titulos )
    {
        this.titulos = titulos;
    }
}
