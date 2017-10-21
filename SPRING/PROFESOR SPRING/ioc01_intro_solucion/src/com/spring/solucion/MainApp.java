package com.spring.solucion;

import com.spring.idolo.ActuacionException;
import com.spring.idolo.Actuante;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public static void main( String[] args ) throws ActuacionException
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "application-context.xml" );

        Actuante actuante = ctx.getBean( "duke3", Actuante.class );
        actuante.actuar();

        actuante = (Actuante) ctx.getBean( "duke15" );
        actuante.actuar();

        ( (ClassPathXmlApplicationContext) ctx ).close();
    }
}
