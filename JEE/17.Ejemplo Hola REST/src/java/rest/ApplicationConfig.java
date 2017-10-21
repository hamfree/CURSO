package rest;

import java.util.Set;
import javax.ws.rs.core.Application;

// Conjunto de clases que son servicios REST (hay que añadirlas aquí según se crean, en el método addRestResourceClasses()
@javax.ws.rs.ApplicationPath("webresources")  // http://servidor:puerto/contexto_aplicacion/webresources/...
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(rest.HolaResource.class);
    }
    
}
