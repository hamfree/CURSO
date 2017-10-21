/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.io.Serializable;

/**
 *
 * @author curso
 */
public class Pedido implements Serializable{
    private String codigo;
    private String estado;
    private String distribuidor;

    public Pedido() {
    }

    public Pedido(String codigo, String estado, String distribuidor) {
        this.codigo = codigo;
        this.estado = estado;
        this.distribuidor = distribuidor;
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the distribuidor
     */
    public String getDistribuidor() {
        return distribuidor;
    }

    /**
     * @param distribuidor the distribuidor to set
     */
    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    @Override
    public String toString() {
        return "Pedido{" + "codigo=" + codigo + ", estado=" + estado + ", distribuidor=" + distribuidor + '}';
    }
    
}
