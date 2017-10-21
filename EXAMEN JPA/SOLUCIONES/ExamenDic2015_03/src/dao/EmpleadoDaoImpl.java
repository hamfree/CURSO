package dao;

import entidad.Empleado;
import excepcion.EmpleadoNoEncontradoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class EmpleadoDaoImpl
    implements EmpleadoDao
{
    private final EntityManagerFactory emf;

    public EmpleadoDaoImpl()
    {
        emf = Persistence.createEntityManagerFactory( "empresaPU" );
    }

    @Override
    public Empleado leeEmpleado( long id ) throws EmpleadoNoEncontradoException
    {
        EntityManager em = emf.createEntityManager();
        Empleado emp = em.find( Empleado.class, id );
        if ( emp == null ) {
            throw new EmpleadoNoEncontradoException( "" + id );
        }

        return emp;
    }

    @Override
    public void borraEmpleado( long id ) throws EmpleadoNoEncontradoException
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Empleado emp = em.find( Empleado.class, id );
        if ( emp == null ) {
            throw new EmpleadoNoEncontradoException( "" + id );
        }

        em.remove( emp );

        em.getTransaction().commit();
    }

    @Override
    public Empleado creaEmpleado( Empleado emp )
    {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist( emp );
        em.getTransaction().commit();

        return emp;
    }

    @Override
    public List<Empleado> leeTodosLosEmpleados()
    {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT e FROM Empleado e";
        TypedQuery<Empleado> query = em.createQuery( jpql, Empleado.class );

        return query.getResultList();
    }
}
