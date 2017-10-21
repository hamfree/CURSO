package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "anuncio")
@Entity
public class Anuncio implements Serializable {
  
    private static final long serialVersionUID = -6665332016011410562L;

    @Column(name = "id_anuncio")
    @Id
    private int id_anuncio;
    @Column(name = "tema")
    private String tema;
    @Column(name = "mensaje")
    private String mensaje;
    @Column(name = "id_usuario")
    private int id_usuario;

    public Anuncio() {
    }

    public Anuncio(String tema, String mensaje) {
        this.tema = tema;
        this.mensaje = mensaje;
    }

    public Anuncio(String tema, String mensaje, int id_usuario) {
        this.tema = tema;
        this.mensaje = mensaje;
        this.id_usuario = id_usuario;
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

    public int getId_anuncio() {
        return id_anuncio;
    }

    public void setId_anuncio(int id_anuncio) {
        this.id_anuncio = id_anuncio;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.id_anuncio;
        hash = 79 * hash + Objects.hashCode(this.tema);
        hash = 79 * hash + Objects.hashCode(this.mensaje);
        hash = 79 * hash + this.id_usuario;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Anuncio other = (Anuncio) obj;
        if (this.id_anuncio != other.id_anuncio) {
            return false;
        }
        if (!Objects.equals(this.tema, other.tema)) {
            return false;
        }
        if (!Objects.equals(this.mensaje, other.mensaje)) {
            return false;
        }
        if (this.id_usuario != other.id_usuario) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Anuncio{" + "id_anuncio=" + id_anuncio + ", tema=" + tema + ", mensaje=" + mensaje + ", id_usuario=" + id_usuario + '}';
    }

}
