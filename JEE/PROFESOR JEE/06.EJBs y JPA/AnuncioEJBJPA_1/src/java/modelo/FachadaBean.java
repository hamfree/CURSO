/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Administrator
 */
@Stateless
public class FachadaBean implements FachadaBeanLocal {

    @PersistenceContext
    EntityManager em;

    public Usuario dameUsuario(String user, String password) {

        Usuario usu = em.find(Usuario.class, user);
        System.out.println("Usuariode find "+usu);
        if (!usu.getPassword().equals(password)) {
            System.out.println("El password no coincide");
            return null;
        }
        return usu;
    }

    public void insertarAnuncio(String idUser, Anuncio a) {
        try {
            Usuario usu = em.find(Usuario.class, idUser);
           usu.addAnuncio(a);         
            em.persist(a);
        } catch (EntityExistsException ex) {
            System.out.println("Horror al insertar anuncio " + ex);

        }
    }
}
