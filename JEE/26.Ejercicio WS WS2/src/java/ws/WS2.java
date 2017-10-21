/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Pedido;

/**
 *
 * @author curso
 */
@WebService(serviceName = "WS2")
public class WS2 {

    /**
     * Devuelve un pedido (generado aleatoriamente) a partir del codigo de pedido...
     *
     * @param codPedido
     * @return un Pedido con ese codigo de Pedido.
     */
    @WebMethod(operationName = "infoPedido")
    public Pedido infoPedido(@WebParam(name = "codPedido") String codPedido) {
        System.out.println("Web service WS2.infoPedido(" + codPedido + ") - INICIO");
        String[] estados = {"En transito", "En preparacion", "Entregado", "Con problemas"};
        String[] distribuidores = {"SEUR", "MRW", "FEDeX", "NACEX"};
        
        System.out.println("...generando pedido aleatorio ....");
        
        int rEstado = (int) (Math.random() * estados.length);
        int rDistribuidor = (int) (Math.random() * distribuidores.length);
        Pedido p = new Pedido(codPedido, estados[rEstado], distribuidores[rDistribuidor]);
        System.out.println("Web service WS2.infoPedido() - FIN");
        return p;
    }
}
