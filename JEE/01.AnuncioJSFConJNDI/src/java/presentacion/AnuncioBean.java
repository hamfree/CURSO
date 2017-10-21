package presentacion;

import controlador.Controlador;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AnuncioBean {

    private String tema;
    private String mensaje;

    public AnuncioBean() {
    }

    public String anunciar(UsuarioMBean usuario) {
        Controlador ctl = new Controlador();
        if (ctl.crearAnuncio(tema, mensaje, usuario.getNombre()) ) {
            return "ultimo";
        } else {
            return null;
        }
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
