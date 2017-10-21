package paq1;

import javax.ejb.Stateless;

@Stateless
public class EjemploSB implements EjemploSBRemote {

    @Override
    public String hacerAlgo() {
        return "Hola, amigo";
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
