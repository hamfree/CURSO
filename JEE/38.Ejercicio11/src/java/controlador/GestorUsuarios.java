/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Usuario;

/**
 *
 * @author curso
 */
public class GestorUsuarios {

    public Usuario dameUsuario(String user, String password) {
        Usuario u = new Usuario();
        switch (user) {
            case "jfernandez":
                u.setNombre("Jose");
                u.setApellido("Fernandez");
                u.setUser(user);
                u.setPassword(password);
                break;
            case "jfruiz":
                u.setNombre("Juan Francisco");
                u.setApellido("Ruiz");
                u.setUser(user);
                u.setPassword(password);
                break;
            case "pbarea":
                u.setNombre("Pedro");
                u.setApellido("Barea");
                u.setUser(user);
                u.setPassword(password);
                break;
            case "rmena":
                u.setNombre("Roberto");
                u.setApellido("Mena");
                u.setUser(user);
                u.setPassword(password);
                break;
            default:
                return null;
        }
            
        return u;
    }
}
