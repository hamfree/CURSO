/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.ejercicio01.main;

import java.util.List;
import jpa.ejercicio01.dao.LibroDao;
import jpa.ejercicio01.dao.LibroDaoImpl;
import jpa.ejercicio01.model.Libro;

/**
 *
 * @author curso
 */
public class Ejercicio01JPA {

    public static void main(String[] args) {
        List<Libro> libros;
        LibroDao dao;
        try {
            dao = new LibroDaoImpl();

            // Creamos un libro
            String isbn;
            Libro libro = new Libro("2001, una odisea del espacio", "2", "1967");
            System.out.format("Creando %s%n",libro);
            dao.createLibro(libro);
            isbn = libro.getIsbn();

            // Buscamos un libro               
            Libro libroBuscado = dao.getLibro("1234567890");

            System.out.println("Buscando libro 1234567890 : ");
            System.out.format("%s%n",libroBuscado);

            // Buscamos todos los libros
            libros = dao.listAllLibros();
            System.out.format("Lista de libros:%n");

            for (Libro l : libros) {
                System.out.format("\t%s%n", l);
            }
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex.getLocalizedMessage());
        } 
    }
}
