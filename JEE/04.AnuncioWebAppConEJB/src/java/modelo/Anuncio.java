package modelo;

public class Anuncio {
    private String tema;
    private String texto;

    public Anuncio() {
    }

    public Anuncio(String tema, String texto) {
        this.tema = tema;
        this.texto = texto;
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

}
