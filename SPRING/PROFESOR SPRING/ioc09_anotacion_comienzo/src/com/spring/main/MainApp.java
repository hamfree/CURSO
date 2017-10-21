package com.spring.main;

import com.spring.idolo.ActuacionException;
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
        }
        finally {
            if ( ctx != null ) {
                ( (ClassPathXmlApplicationContext) ctx ).close();
            }
        }
    }
}
