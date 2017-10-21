package com.spring.apps.ioc;

import com.spring.ioc.Local;
import com.spring.ioc.ServicioAlquiler;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsolaApp
{
    private static final String TITULO = "Forest Gump";

    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "application-context.xml" );

        ServicioAlquiler servicioAlquiler = ctx.getBean( "servicioAlquiler",
            ServicioAlquiler.class );

        List<Local> lugares = servicioAlquiler.find( TITULO, "16802", 10 );
        System.out.format( "%s: ", TITULO );
        for ( Local location : lugares ) {
            System.out.format( "%s, ", location.getNombre() );
        }
        System.out.format( "%n" );

        ( (ClassPathXmlApplicationContext) ctx ).close();
    }
}
