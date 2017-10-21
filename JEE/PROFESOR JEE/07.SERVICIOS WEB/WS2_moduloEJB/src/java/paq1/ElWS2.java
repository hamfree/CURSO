/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author curso
 */
@WebService(serviceName = "ElWS2")
@Stateless()
public class ElWS2 {

    @WebMethod(operationName = "verPedidoWs2")
    public Pedido pedido(@WebParam(name = "codigo") String txt) {
        Pedido p = new Pedido(txt, "En Transito", "SEUR");
        return p;
    }
}
