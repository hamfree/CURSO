/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Infomática
 */
@Entity
public class Anuncio implements Serializable{
        @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
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


}
