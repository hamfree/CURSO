package modelo;

import javax.ejb.Stateless;

@Stateless
public class HolaSession implements HolaSessionLocal {

    @Override
    public String saludar(String nombre) {
        return "Hola, " + nombre + ".";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
