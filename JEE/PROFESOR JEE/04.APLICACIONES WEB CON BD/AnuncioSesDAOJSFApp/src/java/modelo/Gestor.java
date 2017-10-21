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
    private static Gestor gestor = new Gestor();
    
    private Gestor(){
        
    }
    public static Gestor dameInstancia(){
        return gestor;
    }
    // Si devuelve null es porque no existe el usuario o el password está mal
    public Usuario dameUsuario(String user, String password){
        // se delega  para consulta en BD con user y pass.
        // y que me entregara un objeto Usuario con su nombre y apellido
         
        Usuario usu = DAO.seleccionarUsuario(user, password);

        return usu;
    }
    public void insertarAnuncio(String idUser, Anuncio a){
       DAO.insertarUsuario(idUser, a);
       
    }
}
