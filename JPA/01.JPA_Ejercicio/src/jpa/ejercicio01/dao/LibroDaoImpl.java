/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio01.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import jpa.ejercicio01.model.Libro;

/**
 *
 * @author curso
 */
public class LibroDaoImpl implements LibroDao {

    private EntityManagerFactory emf;
    private final EntityManager em;

    public LibroDaoImpl() {
        emf = Persistence.createEntityManagerFactory("01.JPA_EjercicioPU");
        em = emf.createEntityManager();
    }

    @Override
    public void createLibro(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    @Override
    public Libro getLibro(String isbn) {
        return (em.find(Libro.class, isbn));
    }

    @Override
    public List<Libro> listAllLibros() {
        TypedQuery<Libro> query;
        query = em.createQuery("SELECT l from Libro l", Libro.class);
        return query.getResultList();
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize()");
        em.close();
        emf.close();
        super.finalize();
    }

}
