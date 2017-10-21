package com.spring.main;

import com.spring.idolo.ActuacionException;
import com.spring.idolo.Actuante;
import com.spring.idolo.Instrumentalista;
import com.spring.idolo.Malabarista;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) throws ActuacionException {
        ApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext(
                    "application-context.xml");

            // Tanto actuante como actuante2 apuntarán al mismo Bean. Spring no generará un segundo Bean para actuante2
            Actuante actuante = ctx.getBean("duke", Actuante.class);
            Actuante actuante2 = ctx.getBean("duke", Actuante.class);
            if (actuante == actuante2) {
                System.out.format("%s%n", "Iguales");
            } else {
                System.out.format("%s%n", "Distintos");
            }


            
        } finally {
            if (ctx != null) {
                ((ClassPathXmlApplicationContext) ctx).close();
            }
        }
    }
}
