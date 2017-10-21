/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;
import paqgenerados.ElWS2_Service;
import paqgenerados.Pedido;

/**
 *
 * @author curso
 */
@WebService(serviceName = "ElWS1")
public class ElWS1 {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/curso-PC_8080/ElWS2/ElWS2.wsdl")
    private ElWS2_Service service;

    @WebMethod(operationName = "verPedidoWS1")
    public Pedido pedidows1(@WebParam(name = "codigo") String txt) {
        Pedido p = verPedidoWs2(txt);
        return p;
    }

    private Pedido verPedidoWs2(java.lang.String codigo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        paqgenerados.ElWS2 port = service.getElWS2Port();
        return port.verPedidoWs2(codigo);
    }
}
