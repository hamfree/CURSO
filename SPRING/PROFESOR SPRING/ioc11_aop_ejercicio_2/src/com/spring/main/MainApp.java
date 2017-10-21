package com.spring.main;

import com.spring.edadmedia.Caballero;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext(
                "application-context.xml" );

            Caballero caballero = ctx.getBean( "caballero", Caballero.class );
            caballero.emprenderGesta();
        }
        finally {
            if ( ctx != null ) {
                ( (ClassPathXmlApplicationContext) ctx ).close();
            }
        }
    }
}
