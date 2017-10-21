package com.spring.main;

import com.spring.idolo.ActuacionException;
import com.spring.idolo.Actuante;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp2
{
    public static void main( String[] args ) throws ActuacionException
    {
        ApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext(
                "application-context2.xml" );

            Actuante actuante = ctx.getBean( "multiPoeta", Actuante.class );
            actuante.actuar();
        }
        finally {
            if ( ctx != null ) {
                ( (ClassPathXmlApplicationContext) ctx ).close();
            }
        }
    }
}
