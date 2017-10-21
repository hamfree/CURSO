package main;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImpl;
import dao.EmpresaDao;
import dao.EmpresaDaoImpl;
import entidad.Empleado;
import entidad.Empresa;
import java.util.List;

public class DaosApp
{
    private static EmpleadoDao empleadoDao = new EmpleadoDaoImpl();
    private static EmpresaDao empresaDao = new EmpresaDaoImpl();

    public static void main( String[] args )
    {
        testEmpresaEmpleado();
        testEmpleadoEmpresa();
    }

    private static void testEmpresaEmpleado()
    {
        Empresa empresa = new Empresa( "Cervezas La Segoviana" );

        Empleado empleado = new Empleado( "Vega", 19 );
        empresa.contratarEmpleado( empleado );
        empleado.setEmpresa( empresa );

        empleado = new Empleado( "Hugo", 30 );
        empresa.contratarEmpleado( empleado );
        empleado.setEmpresa( empresa );

        empresa = empresaDao.creaEmpresa( empresa );
        long id = empresa.getId();

        empresa = empresaDao.leeEmpresa( id );
        System.out.format( "Empleados de la empresa %s%n", empresa.getNombre() );
        for ( Empleado e : empresa.getEmpleados() ) {
            System.out.format( "\t%s%n", e );
        }
    }

    private static void testEmpleadoEmpresa()
    {
        Empleado empleado = new Empleado( "Carmen", 44 );
        Empresa empresa = new Empresa( "Software Completo" );
        empresa.contratarEmpleado( empleado );
        empleado.setEmpresa( empresa );

        empleadoDao.creaEmpleado( empleado );

        List<Empresa> listaEmpresas = empresaDao.getTodasLasEmpresas();
        for ( Empresa e : listaEmpresas ) {
            System.out.format( "%s:%n", e.getNombre() );
            for ( Empleado empl : e.getEmpleados() ) {
                System.out.format( "\t%s%n", empl );
            }
        }
    }
}
