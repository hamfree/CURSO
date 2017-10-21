/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Stateless;

/**
 *
 * @author curso
 */
@Stateless
public class HolaSession implements HolaSessionLocal {

    @Override
    public String saludar(String nombre) {
        return "Holaa " + nombre;
    }

}
