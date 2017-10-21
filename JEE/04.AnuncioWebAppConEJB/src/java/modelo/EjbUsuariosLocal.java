package modelo;

import javax.ejb.Local;

@Local
public interface EjbUsuariosLocal {

    Usuario dameUsuario(String usuario, String password);
    
}
