package paq1;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MiMain {

    public static void main(String[] args) {
        try {
            
            // Importante: El ejb remoto debe estar desplegado y ejecutándose en el servidor de aplicaciones...
            EjemploSBRemote var = null;
       
            // Una forma de llamar mediante JNDI a nuestro EJB "remoto"
            Hashtable props = new Hashtable();
            props.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.enterprise.naming.SerialInitContextFactory");
            
            // Protocolo : CORBA (ioop), la IP es la de nuestra máquina o máquina donde está desplegado el EJB remoto y 
            // 3700 es el puerto donde está escuchando el servidor de nombres JNDI del servidor de aplicaciones...
            props.put(Context.PROVIDER_URL, "iiop://10.0.2.15:3700");
            Context c = new InitialContext(props);
                                              
            var = (EjemploSBRemote) c.lookup("java:global/ModuloEJBRemoto/EjemploSB");
            System.out.println(var.hacerAlgo());
        } catch (NamingException ne) {
            System.out.println("Error: " + ne);
            throw new RuntimeException(ne);
        }
    }

}
