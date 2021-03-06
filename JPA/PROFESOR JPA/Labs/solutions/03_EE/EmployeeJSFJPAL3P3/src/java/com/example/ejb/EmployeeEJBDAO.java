package com.example.ejb;

import com.example.dao.DAOException;
import com.example.dao.EmployeeDAO;
import com.example.entity.Employee;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class EmployeeEJBDAO
    implements EmployeeDAO
{
    @PersistenceContext( unitName = "EmployeePU" )
    private EntityManager em;

    @Override
    public void add( Employee emp ) throws DAOException
    {
        // Does this employee already exist?
        if ( findById( emp.getId() ) != null ) {
            throw new DAOException( "Employee id: " + emp.getId() + " already exists." );
        }
        try {
            em.persist( emp );
        }
        catch( Exception e ) {
            throw new DAOException( "Exception thrown in add method: ", e.getCause() );
        }
    }

    @Override
    public void update( Employee emp ) throws DAOException
    {
        if ( findById( emp.getId() ) == null ) {
            throw new DAOException( "Employee id: " + emp.getId() + " does not exist to update." );
        }
        try {
            em.merge( emp );  // merge returns the managed entity, but you don't need it
        }
        catch( Exception e ) {
            throw new DAOException( "Exception thrown in update method: ", e.getCause() );
        }
    }

    @Override
    public void delete( int id ) throws DAOException
    {
        try {
            Employee emp = em.find( Employee.class, id );
            if ( emp == null ) {
                throw new DAOException( "Employee id: " + id + " does not exist to delete." );
            }
            em.remove( emp );
        }
        catch( Exception e ) {
            throw new DAOException( "Exception thrown in delete method: ", e.getCause() );
        }
    }

    @Override
    public Employee findById( int id ) throws DAOException
    {
        Employee emp;
        try {
            emp = em.find( Employee.class, id );
        }
        catch( Exception e ) {
            throw new DAOException( "Exception thrown in findById method: ", e.getCause() );
        }
        return emp;
    }

    @Override
    public Employee[] getAllEmployees() throws DAOException
    {
        Employee[] empArray;
        try {
            TypedQuery<Employee> query = em.createQuery( "SELECT e FROM Employee e", Employee.class );
            List<Employee> emps = query.getResultList();
            empArray = emps.toArray( new Employee[ 0 ] );
        }
        catch( Exception e ) {
            throw new DAOException( "Exception thrown in getAllEmployees method: ", e.getCause() );
        }

        return empArray;
    }
}
