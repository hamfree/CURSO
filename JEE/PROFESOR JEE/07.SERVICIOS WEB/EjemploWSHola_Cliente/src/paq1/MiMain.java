/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

/**
 *
 * @author curso
 */
public class MiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(saludar("pepe"));
    }

    private static String saludar(java.lang.String nombre) {
        paquetePojos.SaludoWS_Service service = new paquetePojos.SaludoWS_Service();
        paquetePojos.SaludoWS port = service.getSaludoWSPort();
        return port.saludar(nombre);
    }
    
}
