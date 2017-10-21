/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author curso
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Cola1"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class HolaMDB implements MessageListener {
    
    public HolaMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            String txt = ((TextMessage)message).getText();
            System.out.println("------>Recibido: "+ txt);
        } catch (JMSException ex) {
            System.out.println("Horror "+ex);
        }
    }
    
}
