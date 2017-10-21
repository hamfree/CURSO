/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Local;

/**
 *
 * @author curso
 */
@Local
public interface FachadaSBLocal {
           
    public Usuario dameUsuario(String user, String password);
    public void insertarAnuncio(String idUser, Anuncio a);
}
