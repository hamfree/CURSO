package modelo;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Esta aplicación necesita que los recursos JMS de abajo sean creados previamente
 * en el servidor de aplicaciones Glassfish.
 * @author hamfree
 */

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/Cola1"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class RecibirMensajeBean implements MessageListener {
    // Inyectamos en este bean MDB el EJB GestorAnuncio...
    @EJB
    private GestorAnuncioLocal ejb;

    public RecibirMensajeBean() {
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("RecibirMensajeBean.onMessage() - INICIO");
        try {
            String txt = ((TextMessage) message).getText();
            String tema = txt.substring(0, txt.indexOf("#"));
            String texto = txt.substring(txt.indexOf("#") + 1, txt.length());
            ejb.insertarAnuncio(new Anuncio(tema, texto));
        } catch (JMSException ex) {
            System.out.println("Error de JMS : " + ex.getLocalizedMessage());
        }
        System.out.println("RecibirMensajeBean.onMessage() - FIN");
    }

}
