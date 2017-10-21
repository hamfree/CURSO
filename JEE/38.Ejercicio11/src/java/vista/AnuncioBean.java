package vista;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "anuBean")
@RequestScoped
public class AnuncioBean implements Serializable {

    private String tema;
    private String texto;

    public AnuncioBean() {
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
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String enviar(){
        String respuesta = null;
        if (getTema().length() > 0 && getTexto().length() > 0) {
            respuesta = "fin";
        } 
        return respuesta;
    }
}
