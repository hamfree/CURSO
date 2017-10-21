/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import auxiliar.C;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author curso
 */
@Stateless
public class FachadaSB implements FachadaSBLocal {

    @PersistenceContext(unitName = "AnuncioSesJSF_EJBApp_ConMDByJPAPU")
    private EntityManager em;

    // Si devuelve null es porque no existe el usuario o el password está mal
    @Override
    public Usuario dameUsuario(String name, String password) {
        if (name == null || password == null) {
            return null;
        }
        String query;
        query = "SELECT * FROM " + C.T_USUARIO
                + " WHERE "
                + C.NOMBRE + " = '" + name + "' AND "
                + C.PASSWORD + " = '" + password + "'";
        Query q = em.createNativeQuery(query, Usuario.class);

        List l = q.getResultList();

        if (l != null) {
            System.out.println("Registros en la query:" + l.size());
            if (l.size() == 1) {
                return (Usuario) l.get(0);
            } else if (l.isEmpty()) {
                System.out.println("Error: No se encontró ningún usuario con el nombre '" + name + "' y el password '" + password + "'");
                return null;
            } else {
                System.out.println("Error: Hay más de un usuario con el nombre '" + name + "' y el password '" + password + "'");
                return null;
            }
        }
        return null;
    }

    @Override
    public void insertarAnuncio(int idUser, Anuncio a) {
        //Hace falta añadir el id de usuario a la entidad Anuncio, para poder luego relacionar los anuncios con sus usuarios...
        a.setId_usuario(idUser);
        long registros = dameCantidadAnuncios();
        System.out.println("registros: " + registros);
        registros++;
        a.setId_anuncio((int) registros);
        System.out.println("Anuncio a insertar:" + a.toString());
        em.persist(a);
        em.flush();
    }

    @Override
    public long dameCantidadAnuncios() {
        long registros = 0;
        String query = "SELECT COUNT(" + C.IDANUNCIO + ") FROM " + C.T_ANUNCIO;
        Query q = em.createNativeQuery(query);
        registros = (long) q.getSingleResult();

        return registros;
    }

}
