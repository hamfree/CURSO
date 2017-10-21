package utiles;

/**
 * Constantes utilizadas en la aplicacion
 * @author hamfree
 */
public class C {

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

}
