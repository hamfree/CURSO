/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paq1;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("persona")
public class PersonaService {

    public PersonaService() {
        System.out.println("Creado ");
    }

    @POST
    @Consumes({"application/xml"})
    public void crearEntidad(Persona entity) {
        System.out.println("Se crea persona (persist) "+entity);
    }
    
    @DELETE
    @Path("{id}")
    public void borrar(@PathParam("id") Integer id) {
       System.out.println("Se borra persona (remove) "+id);
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml"})
    public Persona find(@PathParam("id") Integer id) {
        System.out.println("Se busca persona (find) "+id);
        return new Persona(id,"pepe","perez");
    }

}
