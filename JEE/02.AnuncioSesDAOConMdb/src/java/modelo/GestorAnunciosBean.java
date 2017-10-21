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

@Stateless
public class GestorAnunciosBean implements GestorAnuncioLocal {

    /**
     * Esta aplicación necesita que los recursos JMS de abajo sean creados
     * previamente en el servidor de aplicaciones Glassfish.
     */
    @Resource(mappedName = "jms/Cola1ConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Cola1")
    private Queue queue;

    @Override
    public void enviarMensaje(String tema, String texto) {
        System.out.println("GestorAnunciosBean.enviarMensaje('" + tema + "','" + texto + "') - INICIO");
        try (Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue)) {
            int n = (int) (Math.random() * 1000);
            TextMessage message = session.createTextMessage();
            String mensaje = tema + "#" + texto;
            message.setText(mensaje);
            System.out.println("...enviando mensaje '" + mensaje + "' --->");
            messageProducer.send(message);
        } catch (JMSException ex) {
            System.out.println("Error de JMS : " + ex.getLocalizedMessage());
        }
        System.out.println("GestorAnunciosBean.enviarMensaje() - FIN");
    }

    @Override
    public void insertarAnuncio(Anuncio anuncio) {
        System.out.println("GestorAnunciosBean.insertarAnuncio(" + anuncio.toString() + ") - INICIO");
        System.out.println("....llamando al DAO para insertar el anuncio en la BD...");
        DAO.insertarAnuncio(anuncio);
        System.out.println("GestorAnunciosBean.insertarAnuncio() - FIN");
    }
}
