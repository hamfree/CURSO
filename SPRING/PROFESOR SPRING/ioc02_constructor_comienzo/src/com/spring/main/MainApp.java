package com.spring.main;

import com.spring.bean.Estudiante;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext ctx = null;
        try {
            ctx = new ClassPathXmlApplicationContext("application-context.xml");
            Estudiante estudiante = ctx.getBean("est",Estudiante.class);
            System.out.format("'%s'%n", estudiante);
        } finally {
            if (ctx != null) {
                ((ClassPathXmlApplicationContext) ctx).close();
            }
        }
    }
}
