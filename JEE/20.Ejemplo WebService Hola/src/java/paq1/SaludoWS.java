/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author curso
 */
@WebService(serviceName = "SaludoWS")
public class SaludoWS {

    @WebMethod(operationName = "saludar")
    public String hello(@WebParam(name = "nombre") String txt) {
        System.out.println("Me llaman desde un cliente con el parametro '" + txt + "'.");
        return "¡Hola " + txt + " !";
    }
}
