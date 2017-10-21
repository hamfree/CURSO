/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;

/**
 *
 * @author Infomática
 */
public class GestorColeccion {
    private static GestorColeccion gestor = new GestorColeccion();
    private GestorColeccion(){}
    public static GestorColeccion dameInstancia(){
        return gestor;
    }

        // Si devuelve null es porque no existe el usuario o el password está mal
    public Usuario dameUsuario(String user, String password){
        // se delega  para consulta en BD con user y pass.
        // y que me entregara un objeto Usuario con su nombre y apellido
         
        Usuario usu = DVDDao.seleccionarUsuario(user, password);

        return usu;
    }
    
    public void agregarDVD(DVD dvd, String idUser) {
       DVDDao.insertarDVD(dvd, idUser);
    }

    public List<DVD> getLista(String idUser) {
         return DVDDao.seleccionarDVDs(idUser);
    }

    public void borrarDVD(DVD dvd, String idUser) {
        DVDDao.borrarDVD(dvd, idUser);
    }

    public void modificarDVD(DVD dvd) {
         DVDDao.modificarDVD(dvd);
    }

    public DVD buscarDVD(String titulo) {
        
        return DVDDao.buscarDVD(titulo);
    }
    
}
