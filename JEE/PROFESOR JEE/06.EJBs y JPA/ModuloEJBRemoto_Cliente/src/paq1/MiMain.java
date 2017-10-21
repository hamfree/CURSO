/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author curso
 */
public class MiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EjemploSBRemote var = null;
        try {
            Context c = new InitialContext();
            var = (EjemploSBRemote) c.lookup("java:global/ModuloEJBRemoto/EjemploSB");
            System.out.println( var.hacerAlgo() );
           
        } catch (NamingException ne) {
            System.out.println("Horror "+ne);
        }
    }
    
}
