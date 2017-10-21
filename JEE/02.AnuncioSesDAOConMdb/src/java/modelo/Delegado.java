/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Infomática
 */
public class Delegado {
    GestorAnuncioLocal gestorAnunciosBean = lookupGestorAnunciosBeanLocal();
    private static final Delegado GESTOR = new Delegado();
    
    private Delegado(){
        
    }
    public static Delegado dameInstancia(){
        return GESTOR;
    }

    public void insertarAnuncio( Anuncio a){
        System.out.println("Delegado.insertarAnuncio(" + a.toString() + ") - INICIO");
       gestorAnunciosBean.insertarAnuncio(a);
       System.out.println("Delegado.insertarAnuncio(" + a.toString() + ") - FIN");
    }
    
    public void enviarMensaje(String tema, String texto) {
        System.out.println("Delegado.enviarMensaje('" + tema + "','" + texto +  "') - INICIO");
        gestorAnunciosBean.enviarMensaje(tema, texto);
        System.out.println("Delegado.enviarMensaje() - FIN");
    }

    private GestorAnuncioLocal lookupGestorAnunciosBeanLocal() {
        try {
            Context c = new InitialContext();
            return (GestorAnuncioLocal) c.lookup("java:global/02.AnuncioSesDAOConMdb/GestorAnunciosBean!modelo.GestorAnuncioLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
