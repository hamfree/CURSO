package dao;

import entidad.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class EmpresaDaoImpl implements EmpresaDao {

    private EntityManagerFactory emf;

    public EmpresaDaoImpl() {
        emf = Persistence.createEntityManagerFactory("juanfrancisco_1PU");
    }

    @Override
    public Empresa leeEmpresa(long id) {
        Empresa epsa = null;
        EntityManager em = emf.createEntityManager();
        try {
            epsa = em.find(Empresa.class, id);
        } catch (Exception e) {
            System.out.println("Excepcion al leer la empresa con id '" + id + "'. Causa : " + e.getLocalizedMessage());
        } finally {
            em.close();
        }
        return epsa;
    }

    @Override
    public Empresa creaEmpresa(Empresa epsa) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(epsa);
            em.flush();
            epsa = em.find(Empresa.class,epsa.getId());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Excepcion al crear la empresa '" + epsa.toString() + "'. Causa : " + e.getLocalizedMessage());
        } finally {
            em.close();
        }
        return epsa;
    }

    @Override
    public List<Empresa> getTodasLasEmpresas() {
        List<Empresa> epsas = null;
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Empresa> query = em.createQuery("SELECT e FROM Empresa e", Empresa.class);
            epsas = query.getResultList();
        } catch (Exception e) {
            System.out.println("Excepcion al obtener todas las empresas" + "'. Causa : " + e.getLocalizedMessage());
        } finally {
            em.close();
        }

        return epsas;
    }

}
