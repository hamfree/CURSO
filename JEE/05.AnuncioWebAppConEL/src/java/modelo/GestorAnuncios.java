package modelo;

public class GestorAnuncios {
    public   Usuario   dameUsuario(String user, String password){
        Usuario u = new Usuario();
        if (user.equals("pepe")){
            u.setNombre("Jose");
            u.setApellido("Fernandez");
        } else {
             u.setNombre("Francisco");
            u.setApellido("Ramirez");
        }
        return u;
    }
}
