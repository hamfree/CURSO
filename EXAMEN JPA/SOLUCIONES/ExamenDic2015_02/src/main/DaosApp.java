package main;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImpl;
import dao.EmpresaDao;
import dao.EmpresaDaoImpl;
import entidad.Empleado;
import entidad.Empresa;
import excepcion.EmpleadoNoEncontradoException;
import java.util.List;

public class DaosApp
{
    public static void main( String[] args ) throws
        EmpleadoNoEncontradoException
    {
        testEmpleado();
        testEmpresa();
    }

    private static void testEmpleado() throws EmpleadoNoEncontradoException
    {
        EmpleadoDao empleadoDao = new EmpleadoDaoImpl();

        String nombre = "Vega";
        int edad = 19;
        Empleado empleado = new Empleado( nombre, edad );
        empleado = empleadoDao.creaEmpleado( empleado );
        System.out.format( "Empleado leído: %s%n", empleado );

        long id = empleado.getId();
        empleado = empleadoDao.leeEmpleado( id );
        assert empleado.getId() == id;
        assert empleado.getNombre().equals( nombre );
        assert empleado.getEdad() == edad;

        empleado = new Empleado( "Hugo", 30 );
        empleado = empleadoDao.creaEmpleado( empleado );
        System.out.format( "Empleado leído: %s%n", empleado );

        System.out.format( "%nLista de todos los empleados:%n" );
        List<Empleado> list = empleadoDao.leeTodosLosEmpleados();
        for ( Empleado e : list ) {
            System.out.format( "\t%s%n", e );
        }

        id = 133;

        try {
            empleadoDao.leeEmpleado( id );
            System.out.format( "No puede ser!!!" );
        }
        catch( EmpleadoNoEncontradoException ex ) {
            System.out.format( "Todo bien empleado con id=%d no existe%n%n", id );
        }
    }

    private static void testEmpresa()
    {
        EmpresaDao empresaDao = new EmpresaDaoImpl();

        Empresa empresa = new Empresa( "Cervezas La Segoviana" );
        empresaDao.creaEmpresa( empresa );

        empresa = new Empresa( "Aceros del Norte" );
        empresaDao.creaEmpresa( empresa );

        System.out.format( "Lista de todas las empresas:%n" );
        List<Empresa> lista = empresaDao.getTodasLasEmpresas();
        for ( Empresa e : lista ) {
            System.out.format( "\t%s%n", e );
        }
    }
}
