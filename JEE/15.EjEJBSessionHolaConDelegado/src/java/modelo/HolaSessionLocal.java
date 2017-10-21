package modelo;

import javax.ejb.Local;

/**
 * Ejemplo de EJB local (interfaz)
 * @author curso
 */
@Local
public interface HolaSessionLocal {

    String saludar(String nombre);
    
}
