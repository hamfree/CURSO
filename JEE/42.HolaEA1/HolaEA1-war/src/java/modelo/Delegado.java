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
            HolaSessionLocal var  = (HolaSessionLocal) c.lookup("java:global/HolaEA1/HolaEA1-ejb/HolaSession");
            return var;
        } catch (NamingException ne) {
            System.out.println("Error: " + ne);
            throw new RuntimeException(ne);
        }
    }
}
