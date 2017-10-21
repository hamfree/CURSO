/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javax.annotation.Resource;
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
 * @author Jesus
 */
@Stateless
public class FachadaBean implements FachadaBeanLocal {
    @Resource(mappedName = "jms/Cola1ConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Cola1")
    private Queue queue;


    @Override
    public void mandarAnuncio(String anun) {
          try (Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue)){
            
            TextMessage message = session.createTextMessage();
            
            message.setText(anun);
            messageProducer.send(message);

            System.out.println("---> Enviado  Anuncio: " + anun);
        } catch (JMSException ex) {
            System.out.println("Horror "+ex);
        }
    }

    
}
