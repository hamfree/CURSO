package modelo;

import javax.ejb.Local;

@Local
public interface HolaSessionLocal {

    String saludar(String nombre);
    
}
