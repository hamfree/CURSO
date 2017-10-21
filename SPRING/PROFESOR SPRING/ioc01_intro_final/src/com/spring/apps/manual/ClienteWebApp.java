package com.spring.apps.manual;

import com.spring.ioc.BuscadorWeb;
import com.spring.ioc.Local;
import com.spring.ioc.ServicioAlquiler;
import java.util.List;

public class ClienteWebApp
{
    private static final String TITULO = "Forest Gump";

    public static void main( String[] args )
    {
        ServicioAlquiler servicioAlquiler = new ServicioAlquiler( new BuscadorWeb() );

        List<Local> lugares = servicioAlquiler.find( TITULO, "16802", 10 );
        System.out.format( "%s: ", TITULO );
        for ( Local location : lugares ) {
            System.out.format( "%s, ", location.getNombre() );
        }
        System.out.format( "%n" );
    }
}
