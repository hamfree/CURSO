package modelo;

import javax.ejb.Local;

@Local
public interface FachadaSBLocal {

    public Usuario dameUsuario(String user, String password);

    public void insertarAnuncio(int idUser, Anuncio a);

    public long dameCantidadAnuncios();
}
