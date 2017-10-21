/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author curso
 */
public class GestorAnuncios {

    public Usuario dameUsuario(String user, String password) {
        Usuario u = new Usuario();
        if (user.equals("pepe")) {
            u.setNombre("José");
            u.setApellido("Fernandez");
        } else {
            u.setNombre("Francisco");
            u.setApellido("Ramírez");
        }
        return u;
    }
}
