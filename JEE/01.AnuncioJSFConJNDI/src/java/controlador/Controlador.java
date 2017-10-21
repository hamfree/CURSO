package controlador;

import modelo.DAO;
import modelo.Usuario;

public class Controlador {

    public Controlador() {
    }
    
    public Usuario dameUsuario(String nombre, String password){
        DAO g = DAO.getInstance();
        return (g.dameUsuario(nombre, password));
    }
    
    public boolean crearAnuncio(String tema, String texto, String id_usuario){
        DAO g = DAO.getInstance();
        return (g.crearAnuncio(tema, texto, id_usuario));
    }
}
