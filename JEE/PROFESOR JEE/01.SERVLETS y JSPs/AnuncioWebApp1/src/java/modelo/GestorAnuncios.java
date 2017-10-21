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
    public   Usuario   dameUsuario(String user, String password){
        Usuario u = new Usuario();
        if (user.equals("pepe")){
            u.setNombre("jose");
            u.setApellido("Fdedz");
        } else {
             u.setNombre("paco");
            u.setApellido("Ramirez");
        }
        return u;
    }
}
