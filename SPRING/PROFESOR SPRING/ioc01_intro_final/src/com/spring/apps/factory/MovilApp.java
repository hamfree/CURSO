package com.spring.apps.factory;

import com.spring.ioc.Local;
import com.spring.ioc.ServicioAlquiler;
import java.util.List;

public class MovilApp
{
    private static final String TITULO = "Forest Gump";

    @SuppressWarnings( "unused" )
    public static void main( String[] args )
    {
        ServicioAlquiler servicioAlquiler = new ServicioAlquiler( LocalizadorKioskoFactoria.createInstance( "clave" ) );

        List<Local> lugares = servicioAlquiler.find( TITULO, "16802", 10 );
    }
}
