package com.spring.apps.factory;

import com.spring.ioc.Local;
import com.spring.ioc.ServicioAlquiler;
import java.util.List;

public class ClienteWebApp
{

    @SuppressWarnings( "unused" )
    public static void main( String[] args )
    {
        ServicioAlquiler servicioAlquiler = new ServicioAlquiler( LocalizadorMedioDigitalFactoria.createInstance() );

        List<Local> lugares = servicioAlquiler.find( "The Grey", "16802", 10 );
    }
}
