package com.spring.apps.manual;

import com.spring.ioc.BuscadorKiosko;
import com.spring.ioc.Local;
import com.spring.ioc.ServicioAlquiler;
import java.util.List;

public class ConsolaApp
{
    private static final String TITULO = "Forest Gump";

    public static void main( String[] args )
    {
        ServicioAlquiler servicioAlquiler = new ServicioAlquiler( new BuscadorKiosko( "key" ) );

        List<Local> lugares = servicioAlquiler.find( TITULO, "16802", 10 );
        System.out.format( "%s: ", TITULO );
        for ( Local location : lugares ) {
            System.out.format( "%s, ", location.getNombre() );
        }
        System.out.format( "%n" );
    }
}
