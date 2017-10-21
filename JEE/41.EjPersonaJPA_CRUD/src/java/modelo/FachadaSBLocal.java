/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author curso
 */
@Local
public interface FachadaSBLocal {

    void agregarPersona(Persona per);

    Persona buscarPersona(String dni);

    void borrarPersona(final String dni);

    Persona modificarPersona(final String dni, final String nombre, final String apellido);

    List<Persona> buscarPorNombre(final String nombre);
    
}
