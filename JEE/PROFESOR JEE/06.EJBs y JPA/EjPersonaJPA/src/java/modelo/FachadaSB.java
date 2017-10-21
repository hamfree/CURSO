/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class FachadaSB implements FachadaSBLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void agregarPersona(Persona usu) {
        try {
            em.persist(usu);
        } catch (EntityExistsException ex) {
            System.out.println("Horrorrrrr duplicado" + ex);
        }

    }

    @Override
    public Persona buscarPersonaPorId(String dni) {
        Persona u = em.find(Persona.class, dni);
        return u;
    }
    @Override
    public List<Persona> buscarPersonaPorNombre(String nombre) {
        String ins = "SELECT * FROM Tabla_Persona where nombre='" +
                      nombre + "'";
        System.out.println(ins);
        Query q = em.createNativeQuery(ins, Persona.class);
        List l = q.getResultList();
        return l;
    }
    @Override
    public void borrarPersona(String dni) {
        Persona u = buscarPersonaPorId(dni);
        if (u != null) {
            em.remove(u);
        }
    }

    @Override
    public void actualizarPersona(Persona p) {
        System.out.println("actualizamos");
        Persona u = buscarPersonaPorId(p.getDni());

        if (u != null) {
            em.merge(p);
        }
    }
}
