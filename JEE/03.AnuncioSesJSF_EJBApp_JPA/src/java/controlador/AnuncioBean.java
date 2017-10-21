/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Anuncio;
import modelo.FachadaSBLocal;

/**
 *
 * @author Jesus
 */
@ManagedBean
@RequestScoped
public class AnuncioBean {

    private String tema;
    private String mensaje;

    @EJB
    private FachadaSBLocal ln;

    public AnuncioBean() {
    }

    public String anunciar(UsuarioBean u) {
        System.out.println(u.toString());
        ln.insertarAnuncio(u.getIdUsuario(), new Anuncio(tema, mensaje, u.getIdUsuario()));
        return "ultimo";
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
