/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Infomática
 */
public class Gestor {
    public Usuario dameUsuario(String user, String password){
        // se delega  para consulta en BD con user y pass.
        // y que me entregara un objeto Usuario con su nombre y apellido
         
         Usuario usu = new Usuario(user, password,"Jose Luis", "fdez");
            
        return usu;
    }
}
