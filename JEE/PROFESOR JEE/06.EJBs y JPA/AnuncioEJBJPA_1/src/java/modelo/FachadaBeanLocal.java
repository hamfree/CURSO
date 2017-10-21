/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface FachadaBeanLocal {
    public Usuario dameUsuario(String user, String password);
        public void insertarAnuncio(String idUser, Anuncio a);
}
