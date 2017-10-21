package com.spring.bean;

public class Estudiante
{
    private int edad;
    private String nombre;
    private Direccion direccion;

    public Estudiante( Direccion direccion )
    {
        this.direccion = direccion;
    }

    public Estudiante( String nombre )
    {
        this.nombre = nombre;
    }

    public Estudiante( int edad )
    {
        this.edad = edad;
    }

    public Estudiante( int edad, String name )
    {
        this.edad = edad;
        this.nombre = name;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad( int edad )
    {
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
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
        return "[Estudiante: " + "edad=" + edad + ", name=" + nombre + ", direccion=" + direccion + ']';
    }
}
