/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author curso
 */
public class Delegado {
    
    private static Delegado delegado = new Delegado();
    private Delegado(){}
    public static Delegado dameInstancia(){
        return delegado;
    }
     public String saludar(String nombre) {
        // ataco al metodo saludar del ejb
        return lookupHolaSessionLocal().saludar(nombre);
    }

    private HolaSessionLocal lookupHolaSessionLocal() {
        HolaSessionLocal var = null;
        try {
            Context c = new InitialContext();
            // Formas exitosas
            // var = (HolaSessionLocal) c.lookup("java:global/EjEJBSessionHolaConDelegado/HolaSession");
             var = (HolaSessionLocal) c.lookup("java:app/kkEA1-war/HolaSession");
            //var = (HolaSessionLocal) c.lookup("java:module/HolaSession");
              
        } catch (NamingException ne) {
            System.out.println("Horror "+ne);
        }
        return var;
    }
     
}
