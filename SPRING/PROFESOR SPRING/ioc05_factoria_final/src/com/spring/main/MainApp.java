package com.spring.main;

import com.spring.bean.Autorizacion;
import com.spring.idolo.ActuacionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public static void main( String[] args ) throws ActuacionException
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "application-context.xml" );

        Autorizacion autorizacion = ctx.getBean( "autorizacion", Autorizacion.class );
        // Cumple requisitos para VISA pero no para Local
        System.out.format( "Se autoriza? %s%n", autorizacion.autorizar( 100, 1000 ) );

        Autorizacion autorizacion2 = ctx.getBean( "autorizacion2", Autorizacion.class );
        // Cumple requisitos para Local pero no para VISA
        System.out.format( "Se autoriza? %s%n", autorizacion2.autorizar( 1, 1000000 ) );

        ( (ClassPathXmlApplicationContext) ctx ).close();
    }
}
