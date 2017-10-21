/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author curso
 */
@Stateless
public class TemporizadorSB implements TemporizadorSBLocal {

   
    @Resource(mappedName = "jms/Cola1ConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Cola1")
    private Queue queue;
    
     @Override
    @Schedule(second = "*/10", minute = "*", hour = "*")
    public void lanzar() {
       // System.out.println("----> Lanzado: " + new java.util.Date());

        try (Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue)) {

            TextMessage message = session.createTextMessage();
            int n = (int)(Math.random()*1000);
            String texto = "Esto es un mensaje "+n;
            message.setText(texto);
            messageProducer.send(message);

            System.out.println("---> Enviado  Message: " + texto);
        } catch (JMSException ex) {
            System.out.println("Horror " + ex);
        }
    }
}
