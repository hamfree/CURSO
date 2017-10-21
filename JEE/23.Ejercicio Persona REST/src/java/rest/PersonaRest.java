/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import modelo.Persona;

@Path("persona")
public class PersonaRest {

    @Context
    private UriInfo context;


    public PersonaRest() {
    }


    @GET
    @Path("{id}")
    @Produces("application/xml")
    public Persona getXml(@PathParam("id") String id) {
        Persona p = new Persona();
        p.setId(id);
        p.setNombre("Juan Francisco");
        p.setApellido("Ruiz Fernandez");
        return p;
    }

    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
    
    @POST
    @Consumes("application/xml")
    public void creaPersona(Persona entidad){
        System.out.println("holaaaaa");
        Persona p = new Persona();
        p.setId(entidad.getId());
        p.setNombre(entidad.getNombre());
        p.setApellido(entidad.getApellido());
        System.out.println("p ->"  + p.toString());
    }
    
    @DELETE
    @Path("{id}")
    public void borrar(@PathParam("id") Integer id){
        System.out.println("Se borra la persona (remove) " + id);
    }
}
