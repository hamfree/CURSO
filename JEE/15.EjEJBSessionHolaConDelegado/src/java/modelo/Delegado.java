package modelo;

// Implementa el Patron Business delegator
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

 
public class Delegado {
    HolaSessionLocal holaSession = lookupHolaSessionLocal();
    // Patrón singleton
    private static Delegado delegado = new Delegado();
    private Delegado(){}
    
    public static Delegado getInstance(){
        return delegado;
    }
    
    // Todos los Metodos del EJB
    public String saludar(String nombre){
        // Ataco al EJB, llamandolo con JNDI
        return lookupHolaSessionLocal().saludar(nombre);
    }

    /**
     * Autogenerado por el IDE, llamando a Insertar - Call Enterprise Bean
     * @return una referencia al EJB indicado
     */
    private HolaSessionLocal lookupHolaSessionLocal() {
        try {
            Context c = new InitialContext();
            // JNDIs que encuentran el EJB: "java:module/HolaSession"
            //                              "java:global/EjEJBSessionHolaConDelegado/HolaSession"
            //                              "java:app/EjEJBSessionHolaConDelegado/HolaSession"
            HolaSessionLocal var  = (HolaSessionLocal) c.lookup("java:module/HolaSession");
            return var;
        } catch (NamingException ne) {
            System.out.println("Error: " + ne);
            throw new RuntimeException(ne);
        }
    }
}
