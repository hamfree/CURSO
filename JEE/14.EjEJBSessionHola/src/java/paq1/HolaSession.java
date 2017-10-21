package paq1;

import javax.ejb.Stateless;

/**
 * Ejemplo de EJB Stateless (implementación)
 * @author curso
 */
@Stateless
public class HolaSession implements HolaSessionLocal {

    @Override
    public String saludar(String nombre) {
        return "Hola, " + nombre + ".";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
