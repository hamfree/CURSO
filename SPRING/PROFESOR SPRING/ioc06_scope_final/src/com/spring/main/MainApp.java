package com.spring.main;

import com.spring.idolo.ActuacionException;
import com.spring.idolo.Actuante;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public static void main( String[] args ) throws ActuacionException
    {
        ApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext(
                "application-context.xml" );

            Actuante actuante = ctx.getBean( "duke", Actuante.class );
            Actuante actuante2 = ctx.getBean( "duke", Actuante.class );
            assert actuante == actuante2;

            actuante = ctx.getBean( "duke2", Actuante.class );
            actuante2 = ctx.getBean( "duke2", Actuante.class );
            assert actuante != actuante2;
        }
        finally {
            if ( ctx != null ) {
                ( (ClassPathXmlApplicationContext) ctx ).close();
            }
        }
    }
}
