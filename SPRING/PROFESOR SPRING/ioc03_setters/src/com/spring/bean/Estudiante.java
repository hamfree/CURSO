package com.spring.bean;

public class Estudiante
{
    private int edad;
    private String name;
    private Direccion direccion;

    public Estudiante()
    {
    }

    public Estudiante( Direccion direccion )
    {
        this.direccion = direccion;
    }

    public Estudiante( String name )
    {
        this.name = name;
    }

    public Estudiante( int nombre )
    {
        this.edad = nombre;
    }

    public Estudiante( int edad, String name )
    {
        this.edad = edad;
        this.name = name;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad( int edad )
    {
        this.edad = edad;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Direccion getDireccion()
    {
        return direccion;
    }

    public void setDireccion( Direccion direccion )
    {
        this.direccion = direccion;
    }

    @Override
    public String toString()
    {
        return "[Estudiante: " + "edad=" + edad + ", name=" + name + ", direccion=" + direccion + ']';
    }
}
