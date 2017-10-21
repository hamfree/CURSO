package com.spring.solucion;

import com.spring.idolo.ActuacionException;
import com.spring.idolo.MalabaristaPoeta;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) throws ActuacionException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "application-context.xml");
        MalabaristaPoeta mp = ctx.getBean("malabaristaPoeta", MalabaristaPoeta.class);
        
        mp.actuar();

        ((ClassPathXmlApplicationContext) ctx).close();

    }
}
