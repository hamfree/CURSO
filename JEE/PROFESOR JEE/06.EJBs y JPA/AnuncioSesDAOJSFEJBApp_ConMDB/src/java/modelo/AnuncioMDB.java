/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Jesus
 */
@MessageDriven(mappedName = "jms/Cola1", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType",
            propertyValue = "javax.jms.Queue")
})
public class AnuncioMDB implements MessageListener {
    @EJB
    private FachadaSBLocal fachadaSB;

    public AnuncioMDB() {
    }
    
    @Override
    public void onMessage(Message message) {
        // Vienen mensajes de texto con el formato:
        // Tema - mensaje
        try {
            String m = ((TextMessage) message).getText();
            String[] aux = m.split("-");
            Anuncio an = new Anuncio(aux[0], aux[1]);
            fachadaSB.insertarAnuncio("anonimo", an);
            System.out.println("--->recibido msg "+m);
        } catch (JMSException ex) {
            System.out.println("Horror " + ex);
        }
    }
    
}
