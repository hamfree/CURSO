package jpa.ejercicio01.dao;

import java.util.List;
import jpa.ejercicio01.model.Libro;

public interface LibroDao {

    public void createLibro(Libro libro);

    public Libro getLibro(String isbn);

    public List<Libro> listAllLibros();
}
