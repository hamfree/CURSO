/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author curso
 */
public class Pedido implements Serializable {
    private static final long serialVersionUID = -2004469920279904043L;
    private String codPedido;
    private String estado;
    private String distribuidoPor;

    public Pedido() {
    }

    public Pedido(String codPedido, String estado, String distribuidoPor) {
        this.codPedido = codPedido;
        this.estado = estado;
        this.distribuidoPor = distribuidoPor;
    }

    public String getDistribuidoPor() {
        return distribuidoPor;
    }

    public void setDistribuidoPor(String distribuidoPor) {
        this.distribuidoPor = distribuidoPor;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(String codPedido) {
        this.codPedido = codPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codPedido=" + codPedido + ", estado=" + estado + ", distribuidoPor=" + distribuidoPor + '}';
    }
    
    
       
}
