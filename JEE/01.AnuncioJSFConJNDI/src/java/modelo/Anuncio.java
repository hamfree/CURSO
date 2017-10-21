package modelo;

import java.io.Serializable;

public class Anuncio implements Serializable{
    private static final long serialVersionUID = -6665332016011410562L;
    private String tema;
    private String mensaje;

    public Anuncio() {
    }

    public Anuncio(String tema, String mensaje) {
        this.tema = tema;
        this.mensaje = mensaje;
    }

    /**
     * @return the tema
     */
    public String getTema() {
        return tema;
    }

    /**
     * @param tema the tema to set
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "Anuncio{" + "tema=" + tema + ", mensaje=" + mensaje + '}';
    }
    
    
}
