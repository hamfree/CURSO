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
public class FachadaSB implements FachadaSBLocal {

        // Si devuelve null es porque no existe el usuario o el password está mal
    public Usuario dameUsuario(String user, String password){
        // se delega  para consulta en BD con user y pass.
        // y que me entregara un objeto Usuario con su nombre y apellido
         
        Usuario usu = DAO.seleccionarUsuario(user, password);

        return usu;
    }
    public void insertarAnuncio(String idUser, Anuncio a){
       DAO.insertarUsuario(idUser, a);
       
    }
}
