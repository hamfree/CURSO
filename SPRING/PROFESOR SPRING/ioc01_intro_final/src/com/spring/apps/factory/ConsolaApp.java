package com.spring.apps.factory;

import com.spring.ioc.Local;
import com.spring.ioc.ServicioAlquiler;
import java.util.List;

public class ConsolaApp
{

    @SuppressWarnings( "unused" )
    public static void main( String[] args )
    {

        ServicioAlquiler servicioAlquiler
            = new ServicioAlquiler( LocalizadorKioskoFactoria.createInstance( "clave" ) );

        List<Local> locations = servicioAlquiler.find( "Jaws", "16802", 10 );

        // Permitir a los administradores ayudar a los clientes
    }
}
