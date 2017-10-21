package com.spring.main;

import com.spring.idolo.ActuacionException;
import com.spring.idolo.Actuante;
import com.spring.idolo.Banda;
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
            System.out.format( "List%n" );
            Actuante actuante = ctx.getBean( "juanList", Actuante.class );
            actuante.actuar();
            assert ( (Banda) actuante ).getNumberOfInstruments() == 4;

            System.out.format( "%n%nSet%n" );
            actuante = ctx.getBean( "juanSet", Actuante.class );
            actuante.actuar();
            assert ( (Banda) actuante ).getNumberOfInstruments() == 3;
        }
        finally {
            if ( ctx != null ) {
                ( (ClassPathXmlApplicationContext) ctx ).close();
            }
        }
    }
}
