package paq1;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


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
            String txt = ((TextMessage) message).getText();
            System.out.println("----> Recibiendo mensaje : " + txt);
        } catch (JMSException ex) {
            System.out.println("Error de JMS : " + ex.getLocalizedMessage());
        }
    }
    
}
