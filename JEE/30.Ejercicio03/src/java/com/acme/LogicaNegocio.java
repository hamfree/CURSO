/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme;

import java.util.ArrayList;

/**
 *
 * @author curso
 */
public class LogicaNegocio {

    ArrayList<Cliente> alClientes = new ArrayList();

    public LogicaNegocio() {
        alClientes.add(new Cliente("juan","password","Juan Francisco Ruiz"));
        alClientes.add(new Cliente("pedro","password","Pedro Barea Lopez"));
        alClientes.add(new Cliente("jesus","password","Jesus Garcia Diaz"));
        alClientes.add(new Cliente("carlos","password","Carlos Ramirez Torres"));
    }

    public String dameNombre(String usuario, String passwd) {
        String nombre = null;
        if (usuario != null && passwd != null) {
            for (Cliente c : alClientes) {
                if (c.getUsuario().equalsIgnoreCase(usuario) && c.getClave().equalsIgnoreCase(passwd)) {
                    nombre = c.getNombre();
                }
            }
        }
        return nombre;
    }

}
