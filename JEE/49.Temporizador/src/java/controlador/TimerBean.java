package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@Stateless
public class TimerBean implements TimerBeanLocal {

    /**
     * Este Enterprise Bean Stateless muestra por la consola de Glassfish la fecha y hora actual cada 10 segundos...
     */
    @Resource(mappedName = "jms/Cola1ConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Cola1")
    private Queue queue;

    @Override
    @Schedule(hour = "*", minute = "*", second = "*/10")
    public void getTime() {
        Date ahora = new Date();
        String pattern = "yyyy-MM-dd hh:mm:ss";
        SimpleDateFormat formateador = new SimpleDateFormat(pattern);
        String fecha = formateador.format(ahora);

        try (Connection connection = connectionFactory.createConnection();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                MessageProducer messageProducer = session.createProducer(queue)) {
            int n = (int) (Math.random() * 1000);
            TextMessage message = session.createTextMessage();
            String texto = "Esto es un mensaje a las " + fecha + ". Numero aleatorio : " + n;
            message.setText(texto);
            System.out.println("Enviando mensaje --->");
            messageProducer.send(message);
        } catch (JMSException ex) {
            System.out.println("Error de JMS : " + ex.getLocalizedMessage());
        }
    }
}
    
