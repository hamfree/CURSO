package rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("generic")   // <--- http://servidor:puerto/contexto_aplicacion/webresources/generic
public class HolaResource {

    @Context
    private UriInfo context;

    public HolaResource() {
    }

    @GET
    @Produces("application/xml")
    public String getXml() {
        return "<tio>pepe</tio>";
    }
    
    @PUT
    @Consumes("application/xml")
    public void setXml(){
        
    }

}
