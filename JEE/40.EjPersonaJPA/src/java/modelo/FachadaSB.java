package modelo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FachadaSB implements FachadaSBLocal {
    @PersistenceContext(unitName = "EjPersonaJPAPU")
    private EntityManager em;

    @Override
    public void agregarPersona(Persona per) {
        em.persist(per);
    }
    
   
}
