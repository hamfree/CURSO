/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.ejb.Local;
import javax.persistence.EntityExistsException;
import java.util.List;

@Local
public interface FachadaSBLocal {
    public void agregarPersona(Persona usu);
public List<Persona> buscarPersonaPorNombre(String nombre);
    public Persona buscarPersonaPorId(String dni);
    public void borrarPersona(String dni) ;

    public void actualizarPersona(Persona usu) ;
}
