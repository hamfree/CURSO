/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import javax.ejb.Stateless;

@Stateless
public class EjemploSB implements EjemploSBRemote {

    @Override
    public String hacerAlgo() {
        return "hola amigo";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
