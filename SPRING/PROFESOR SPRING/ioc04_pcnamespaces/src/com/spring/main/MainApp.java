package com.spring.main;

import com.spring.bean.Estudiante;
import com.spring.idolo.ActuacionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public static void main( String[] args ) throws ActuacionException
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
            "application-context.xml" );

        Estudiante estud = ctx.getBean( "estudiante", Estudiante.class );
        System.out.format( "%s%n", estud );

        ( (ClassPathXmlApplicationContext) ctx ).close();
    }
}
