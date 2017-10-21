package modelo;

import javax.ejb.Stateless;

@Stateless
public class EjbUsuarios implements EjbUsuariosLocal {

    @Override
    public Usuario dameUsuario(String usuario, String password) {
        Usuario u = new Usuario();
        if (usuario.equals("pepe")) {
            u.setNombre("Jose");
            u.setApellido("Fernandez");
        } else {
            u.setNombre("Francisco");
            u.setApellido("Ramirez");
        }
        return u;
    }

}
