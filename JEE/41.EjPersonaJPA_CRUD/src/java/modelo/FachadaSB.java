package modelo;

import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class FachadaSB implements FachadaSBLocal {

    @PersistenceContext(unitName = "EjPersonaJPAPU")
    private EntityManager em;

    @Override
    public void agregarPersona(Persona per) {
        em.persist(per);
        mostrarMensaje(per, "agregada");
    }

    @Override
    public Persona buscarPersona(String dni) {
        Persona p = em.find(Persona.class, dni);
        mostrarMensaje(p, "encontrada");
        return p;
    }

    @Override
    public void borrarPersona(final String dni) {
        Persona p = buscarPersona(dni);
        if (p != null) {
            em.remove(p);
        }

        mostrarMensaje(p, "borrada");
    }

    @Override
    public Persona modificarPersona(final String dni, final String nombre, final String apellido) {
        Persona p = buscarPersona(dni);
        if (p != null) {
            if (!p.getApellido().equals(apellido)) {
                p.setApellido(apellido);
            }
            if (!p.getNombre().equals(nombre)) {
                p.setNombre(nombre);
            }
        }
        mostrarMensaje(p, "modificada");
        return p;
    }

    private void mostrarMensaje(Persona p, String accion) {
        String msg;
        if (p != null) {
            msg = p.toString();
        } else {

        }
        msg = "Persona *NO* " + accion;

        System.out.println(msg);
    }

    @Override
    public List<Persona> buscarPorNombre(final String nombre) {
        String query = "SELECT * FROM tabla_persona WHERE nombre='" + nombre + "'";
        Query q = em.createNativeQuery(query, Persona.class);
        
        // El ResultList que devuelve la query es de tipo Vector ...
        Vector<Persona> listaPersonas = (Vector<Persona>) q.getResultList();
        return listaPersonas;
    }

    
}
