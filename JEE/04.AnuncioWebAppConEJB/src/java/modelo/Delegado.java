package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class Delegado {
    EjbUsuariosLocal ejbAnuncios = lookupEjbAnunciosLocal();
    private static final Delegado DELEGADO = new Delegado();
    
    private Delegado(){}
    
    public static Delegado getInstance(){
        return DELEGADO;
    }
    public Usuario dameUsuario(String user, String password) {
        Usuario u = null;
        u = lookupEjbAnunciosLocal().dameUsuario(user, password);
        return u;
    }

    private EjbUsuariosLocal lookupEjbAnunciosLocal() {
        try {
            Context c = new InitialContext();
            EjbUsuariosLocal ejb = (EjbUsuariosLocal) c.lookup("java:global/04.AnuncioWebAppConEJB/EjbUsuarios");
            return ejb;
            
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Excepción al localizar el EJB: ", ne);
            throw new RuntimeException(ne);
        }
    }
}
