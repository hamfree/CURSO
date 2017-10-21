package com.spring.main;

import com.spring.bean00_02.HolaMundo;
import com.spring.bean03.Direccion;
import com.spring.bean03.Empleado;
import com.spring.bean03.EmpresaUniPersonal;
import com.spring.bean04.Coche;
import com.spring.bean05.Floristeria;
import com.spring.bean06.Jefe;
import com.spring.bean07.Malabarista;
import com.spring.bean08.Anuncio;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = null;
        try {
            if ( !args[0].equals( "todos" ) ) {
                String fichero = "application-context" + args[0] + ".xml";
                ctx = new ClassPathXmlApplicationContext( fichero );
            }

            switch( args[0] ) {
                case "todos":
                    for ( int i = 0; i < 9; ++i ) {
                        String value = String.format( "%02d", i );
                        try {
                            main( new String[] { value } );
                        }
                        catch( Throwable e ) {
                            System.out.format( "excepción en %s%n", value );
                        }
                    }
                    break;
                case "00":
                    test00( ctx );
                    break;
                case "01":
                    test01( ctx );
                    break;
                case "02":
                    test02Java( ctx );
                    break;
                case "03":
                    test03( ctx );
                    test03Java( ctx );
                    break;
                case "04":
                    test04( ctx );
                    break;
                case "05":
                    test05( ctx );
                    break;
                case "06":
                    test06( ctx );
                    break;
                case "07":
                    test07( ctx );
                    break;
                case "08":
                    test08Java( ctx );
                    break;
            }
        }
        finally {
            if ( ctx != null ) {
                ( (ClassPathXmlApplicationContext) ctx ).close();
            }
        }
    }

    private static void test00( ApplicationContext ctx )
    {
        System.out.format( "test00: " );
        HolaMundo hola = ctx.getBean( HolaMundo.class );
        assert hola.getMessage() == null;
        System.out.format( "bien%n" );
    }

    private static void test01( ApplicationContext ctx )
    {
        System.out.format( "test01: " );
        HolaMundo hola = ctx.getBean( HolaMundo.class );
        assert hola.getMessage().equals( "Spring es primavera" );
        System.out.format( "bien%n" );
    }

    private static void test02Java( ApplicationContext ctx )
    {
        System.out.format( "test02Java: " );
        HolaMundo hola = ctx.getBean( "hola02", HolaMundo.class );
        assert hola.getMessage().equals( "Abracadabra" );

        System.out.format( "bien%n" );
    }

    private static void test03( ApplicationContext ctx )
    {
        System.out.format( "test03: " );
        Empleado empleado = ctx.getBean( "emp01", Empleado.class );
        assert empleado.getNombre().equals( "Adriana" );

        String calle = "Vallehermoso 52";
        String ciudad = "Madrid";

        Direccion direccion = ctx.getBean( "dir01", Direccion.class );
        assert direccion.getCalle().equals( calle );
        assert direccion.getCiudad().equals( ciudad );

        empleado = ctx.getBean( "emp02", Empleado.class );
        assert empleado.getNombre().equals( "Max" );
        assert empleado.getDireccion().getCalle().equals( calle );
        assert empleado.getDireccion().getCiudad().equals( ciudad );

        System.out.format( "bien%n" );
    }

    private static void test03Java( ApplicationContext ctx )
    {
        System.out.format( "test03Java: " );
        Empleado empleado = ctx.getBean( "emp01Java", Empleado.class );
        assert empleado.getNombre().equals( "Adriana" );

        String nombreEmpresa = "Spring SA";
        String nombreEmpleado = "Max";
        String calle = "Vallehermoso 52";
        String ciudad = "Madrid";

        Direccion direccion = ctx.getBean( "dir01Java", Direccion.class );
        assert direccion.getCalle().equals( calle );
        assert direccion.getCiudad().equals( ciudad );

        empleado = ctx.getBean( "emp02Java", Empleado.class );
        assert empleado.getNombre().equals( nombreEmpleado );
        assert empleado.getDireccion().getCalle().equals( calle );
        assert empleado.getDireccion().getCiudad().equals( ciudad );

        EmpresaUniPersonal empresa = ctx.getBean( "empresa", EmpresaUniPersonal.class );
        assert empresa.getEmpleado().getNombre().equals( nombreEmpleado );
        assert empresa.getEmpleado().getDireccion().getCalle().equals( calle );
        assert empresa.getEmpleado().getDireccion().getCiudad().equals( ciudad );
        assert empresa.getNombre().equals( nombreEmpresa );

        System.out.format( "bien%n" );
    }

    private static void test04( ApplicationContext ctx )
    {
        System.out.format( "test04: " );
        Coche coche01 = ctx.getBean( "cocheSingleton", Coche.class );
        Coche coche02 = ctx.getBean( "cocheSingleton", Coche.class );
        assert coche01 == coche02;

        coche01 = ctx.getBean( "cochePrototype", Coche.class );
        coche02 = ctx.getBean( "cochePrototype", Coche.class );
        assert coche01 != coche02;

        System.out.format( "bien%n" );
    }

    private static void test05( ApplicationContext ctx )
    {
        System.out.format( "test05: " );
        Floristeria floristeria = ctx.getBean( "floristeria", Floristeria.class );

        assert floristeria.getNombre().equals( "Fragancia" );

        String[] nombresFlores = { "Margarita", "Hortensia", "Azucena" };
        for ( int i = 0; i < nombresFlores.length; ++i ) {
            assert floristeria.getStock().get( i ).equals( nombresFlores[i] );
        }

        System.out.format( "bien%n" );
    }

    private static void test06( ApplicationContext ctx )
    {
        System.out.format( "test06: " );
        Jefe jefe = ctx.getBean( "jefe", Jefe.class );

        assert jefe.getDespacho().getUbicacion().equals( "Segunda Planta" );
        assert jefe.getDespacho().getCapacidad() == 3;

        assert jefe.getPlazaGaraje().getPlanta() == 2;
        assert jefe.getPlazaGaraje().getPlaza() == 4;

        System.out.format( "bien%n" );
    }

    private static void test07( ApplicationContext ctx )
    {
        System.out.format( "test07: " );
        Malabarista malabarista = ctx.getBean( Malabarista.class );
        assert malabarista.getNroBolas() == 5;

        System.out.format( "bien%n" );
    }

    private static void test08Java( ApplicationContext ctx )
    {
        System.out.format( "test08Java: " );
        Anuncio anuncio = ctx.getBean( Anuncio.class );
        assert anuncio.getMensaje().equals( "Si quiere su ropa blanca..." );

        System.out.format( "bien%n" );
    }
}
