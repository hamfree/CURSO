package com.spring.main;

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

        Actuante actuante = ctx.getBean("bandaList", Actuante.class);
        
        actuante.actuar();
        
        
        ( (ClassPathXmlApplicationContext) ctx ).close();
    }
}
