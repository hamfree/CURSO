package es.nom.juanfranciscoruiz;

/**
 * Constantes utilizadas en la aplicacion
 *
 * @author hamfree
 */
public class C_Tablon_Anuncios {

    public static final String URL = "jdbc:mysql://localhost:3306/world";
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String USUARIO = "dummy";
    public static final String PASS = "dummy";

    public static final String T_ANUNCIO = "anuncio";
    public static final String IDANUNCIO = "id_anuncio";
    public static final String TEMA = "tema";
    public static final String MENSAJE = "mensaje";

    public static final String T_USUARIO = "usuario";
    public static final String IDUSUARIO = "id_usuario";
    public static final String PASSWORD = "password";
    public static final String NOMBRE = "nombre_pila";
    public static final String APELLIDO = "apellido";

    // Cambiar el nombre JNDI adecuadamente y/o crearlo en el servidor de aplicaciones
    public static final String JNDI = "jdbc/world";

    public static final String SL = System.getProperty("line.separator");

    @Override
    public String toString() {
        return "URL='" + C_Tablon_Anuncios.URL + "'," + SL
                + "DRIVER='" + C_Tablon_Anuncios.DRIVER + "'," + SL
                + "USUARIO='" + C_Tablon_Anuncios.USUARIO + "'," + SL
                + "PASS='" + C_Tablon_Anuncios.PASS + "'," + SL
                + "T_ANUNCIO='" + C_Tablon_Anuncios.T_ANUNCIO + "'," + SL
                + "IDANUNCIO='" + C_Tablon_Anuncios.IDANUNCIO + "'," + SL
                + "TEMA='" + C_Tablon_Anuncios.TEMA + "'," + SL
                + "T_USUARIO='" + C_Tablon_Anuncios.T_USUARIO + "'," + SL
                + "IDUSUARIO='" + C_Tablon_Anuncios.IDUSUARIO + "'," + SL
                + "PASSWORD='" + C_Tablon_Anuncios.PASSWORD + "'," + SL
                + "NOMBRE='" + C_Tablon_Anuncios.NOMBRE + "'," + SL
                + "APELLIDO='" + C_Tablon_Anuncios.APELLIDO + "'";
    }

}
