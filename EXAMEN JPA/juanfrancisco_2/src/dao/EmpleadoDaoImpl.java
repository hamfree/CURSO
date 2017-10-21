/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Empleado;
import exception.EmpleadoNoEncontradoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author curso
 */
public class EmpleadoDaoImpl implements EmpleadoDao {

    private EntityManagerFactory emf;

    public EmpleadoDaoImpl() {
        emf = Persistence.createEntityManagerFactory("juanfrancisco_1PU");
    }

    @Override
    public Empleado leeEmpleado(long id) throws EmpleadoNoEncontradoException {
        Empleado emp = null;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            emp = em.find(Empleado.class, id);
            if (emp == null){
                throw new EmpleadoNoEncontradoException("No se encuentra el empleado con id " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Excepcion al leer el empleado con id '" + id + "'. Causa : " + e.getLocalizedMessage());
        } finally {
            em.close();
        }

        return emp;
    }

    @Override
    public void borraEmpleado(long id) throws EmpleadoNoEncontradoException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Empleado emp = em.find(Empleado.class,id);
            if (emp != null) {
                em.remove(emp);
            } else {
                throw new EmpleadoNoEncontradoException("No se encuentra el empleado con id " + id);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Excepcion al borrar el empleado con id '" + id + "'. Causa : " + e.getLocalizedMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public Empleado creaEmpleado(Empleado emp) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(emp);
            emp = em.find(Empleado.class,emp.getId());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Excepcion al crear el empleado '" + emp.toString() + "'. Causa : " + e.getLocalizedMessage());
        } finally {
            em.close();
        }
        return emp;
    }

    @Override
    public List<Empleado> leeTodosLosEmpleados() {
        List<Empleado> empleados = null;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Empleado> query = em.createQuery("SELECT e FROM Empleado e", Empleado.class);
            empleados = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Excepcion al obtener todas los empleados" + "'. Causa : " + e.getLocalizedMessage());
        } finally {
            em.close();
        }
        return empleados;
    }

}
