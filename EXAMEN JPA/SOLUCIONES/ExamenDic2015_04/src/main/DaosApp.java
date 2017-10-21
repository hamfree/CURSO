package main;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImpl;
import entidad.Empleado;
import entidad.PlazaGaraje;
import java.util.List;

public class DaosApp
{
    private static EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

    public static void main( String[] args )
    {
        String nombre = "Mireia";
        int edad = 29;
        Empleado empleado = new Empleado( nombre, edad );

        PlazaGaraje plazaGaraje = new PlazaGaraje( "P223" );
        empleado.setPlazaGaraje( plazaGaraje );
        empleadoDao.creaEmpleado( empleado );

        List<Empleado> listaEmpleados = empleadoDao.leeTodosLosEmpleados();
        for ( Empleado e : listaEmpleados ) {
            System.out.format( "%s: %s%n", e.getNombre(), e.getPlazaGaraje().getUbicacion() );
        }
    }
}
