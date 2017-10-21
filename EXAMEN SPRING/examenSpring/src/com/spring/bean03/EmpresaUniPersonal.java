package com.spring.bean03;

public class EmpresaUniPersonal
{
    private String nombre;
    private Empleado empleado;

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public Empleado getEmpleado()
    {
        return empleado;
    }

    public void setEmpleado( Empleado empleado )
    {
        this.empleado = empleado;
    }

}
