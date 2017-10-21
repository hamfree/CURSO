/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import cws.Pedido;
import cws.WS2_Service;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author curso
 */
@WebService(serviceName = "WS1")
public class WS1 {
    @WebServiceRef(wsdlLocation = "http://curso-pc:8080/Ejercicio_WS_WS2/WS2?wsdl")
    private WS2_Service service;

    /**
     * This is a sample web service operation
     * @param codPedido
     * @return 
     */
    @WebMethod(operationName = "damePedido")
    public modelo.Pedido damePedido(@WebParam(name = "idPedido") String codPedido) {
        System.out.println("Web service WS1.damePedido(" + codPedido + ") - INICIO");
        modelo.Pedido ped = new modelo.Pedido();
        
        System.out.println("...llamando a WS2.infoPedido()...");
        
        Pedido p = infoPedido(codPedido);
        ped.setCodPedido(p.getCodPedido());
        ped.setDistribuidoPor(p.getDistribuidoPor());
        ped.setEstado(p.getEstado());
        System.out.println("Web service WS1.damePedido() - FIN");
        return ped;
        
    }

    private Pedido infoPedido(java.lang.String codPedido) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        cws.WS2 port = service.getWS2Port();
        return port.infoPedido(codPedido);
    }
}
