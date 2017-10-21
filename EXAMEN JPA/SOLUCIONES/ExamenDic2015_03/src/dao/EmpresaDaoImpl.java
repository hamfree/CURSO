package dao;

import entidad.Empresa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class EmpresaDaoImpl
    implements EmpresaDao
{
    private final EntityManagerFactory emf;

    public EmpresaDaoImpl()
    {
        emf = Persistence.createEntityManagerFactory( "empresaPU" );
    }

    @Override
    public Empresa leeEmpresa( long id )
    {
        EntityManager em = emf.createEntityManager();
        Empresa emp = em.find( Empresa.class, id );

        return emp;
    }

    @Override
    public Empresa creaEmpresa( Empresa emp )
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist( emp );
        em.getTransaction().commit();

        return emp;
    }

    @Override
    public List<Empresa> getTodasLasEmpresas()
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT e FROM Empresa e";
        TypedQuery<Empresa> query = em.createQuery( jpql, Empresa.class );

        return query.getResultList();
    }
}
