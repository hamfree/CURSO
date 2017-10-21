package modelo;

import javax.ejb.Local;

@Local
public interface GestorAnuncioLocal {

    void enviarMensaje(String tema, String texto);

    void insertarAnuncio(Anuncio anuncio);
}
