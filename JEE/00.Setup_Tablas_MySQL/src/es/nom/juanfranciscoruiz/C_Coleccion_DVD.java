package es.nom.juanfranciscoruiz;

/**
 * Constantes usadas en la aplicación. Contiene los datos de acceso JDBC a la BBDD world de MySQL así como los nombres de las
 * tablas, campos y otras constantes que se repiten a lo largo de la aplicación
 *
 * @author hamfree
 */
public class C_Coleccion_DVD {

    /**
     * Indica si se muestran por la consola mensajes de traza o no. Si vale true se mostrarán mensajes de traza en la consola. Si
     * vale false no se mostrarán mensajes de traza por la consola
     */
    public static final boolean DGB = true;
    /**
     * URL de conexión JDBC
     */
    public static final String URL = "jdbc:mysql://localhost:3306/world";
    /**
     * Clase controladora JDBC para MySQL
     */
    public static final String CONTROLADOR = "com.mysql.jdbc.Driver";
    /**
     * Usuario de base de datos
     */
    public static final String USUARIO = "dummy";
    /**
     * Contraseña para base de datos
     */
    public static final String CLAVE = "dummy";

    /**
     * Nombre JNDI del datasource en el servidor de aplicaciones
     */
    public static final String JNDI = "jdbc/world";

    /**
     * Separador de lineas del sistema operativo
     */
    public static final String LS = System.getProperty("line.separator");

    /**
     * Nombre de la tabla de usuarios en la BBDD
     */
    public static final String USER = "users";
    /**
     * Campo clave id_usuario
     */
    public static final String ID_USU = "id_usuario";
    /**
     * Campo password
     */
    public static final String PASS = "password";
    /**
     * Campo nombre
     */
    public static final String NOMB = "nombre_pila";
    /**
     * Campo apellido
     */
    public static final String APEL = "apellido";

    /**
     * Nombre de la Tabla de relación de usuarios y dvds en la BBDD
     */
    public static final String USERSDVDS = "usersdvds";

    /**
     * Nombre de la Tabla de dvds en la BBDD
     */
    public static final String DVDS = "dvds";
    /**
     * Campo clave id_pelicula
     */
    public static final String ID_PEL = "id_pelicula";
    /**
     * Campo titulo
     */
    public static final String TITU = "titulo";
    /**
     * Campo director
     */
    public static final String DTOR = "director";

    // Palabras reservadas de SQL y tamaños campos que se repiten
    public static final int TAM_KEY = 10;
    public static final int TAM_STR = 50;
    public static final String NOTNULL = " NOT NULL ";
    public static final String AUTINC = " AUTO_INCREMENT ";

    /**
     * Para mostrar mensajes de depuración por la consola. Depende de la constante DBG. Si vale true se mostrará el mensaje y no
     * hará nada en caso contrario.
     *
     * @param clase La clase desde la que emitimos el mensaje.
     * @param msg El mensaje de depuración que mostramos por consola ...
     */
    public static void dbg(Class clase, String msg) {
        if (DGB) {
            if (clase != null) {
                System.out.println(clase.getSimpleName() + msg);
            } else {
                System.out.println(msg);
            }
        }
    }

}
