package es.nom.juanfranciscoruiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfiguraTablas_Tablon_Anuncios {

    static int error = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date fi = new Date(System.currentTimeMillis());
        int error = 0;

        System.out.println("Configuración de base de datos para las prácticas del curso");
        System.out.println("===========================================================");
        System.out.println("Inicio:" + fi);

        System.out.println("Configuración de conexión a la BD y nombres de tablas y columnas.");
        System.out.println(new C_Tablon_Anuncios().toString());
        
        if (crearTablaUsuarios()) {
            System.out.println("\tOK: Tabla de usuarios creada.");
        } else {
            error++;
            System.out.println("\tERROR: No se pudo crear la tabla de usuarios.");
        }

        pausar(1000);
        
        if (insertarUsuarios()) {
            System.out.println("\tOK: Usuarios creados.");

        } else {
            error++;
            System.out.println("\tERROR: No se crearon los usuarios.");
        }

        pausar(1000);
        
        if (consultarTablaUsuarios()) {
            System.out.println("\tOK: Usuarios mostrados.");
        } else {
            error++;
            System.out.println("\tERROR: No se pudieron mostrar los usuarios.");
        }
        
        pausar(1000);

        if (crearTablaAnuncios()) {
            System.out.println("\tOK: Tabla de anuncios creada.");
        } else {
            error++;
            System.out.println("\tERROR: No se pudo crear la tabla de anuncios");
        }

        Date ff = new Date(System.currentTimeMillis());
        System.out.println("Errores encontrados: " + error);
        System.out.println("Fin:" + ff);
        System.out.println("===========================================================");
        System.exit(error);
    }

    public static boolean crearTablaUsuarios() {
        System.out.println("\tCreando la tabla de usuarios ...");
        boolean resultado = true;
        Connection con;
        Statement stmt;
        StringBuilder sb = new StringBuilder();

        try {
            Class.forName(C_Tablon_Anuncios.DRIVER);

            con = DriverManager.getConnection(C_Tablon_Anuncios.URL, C_Tablon_Anuncios.USUARIO, C_Tablon_Anuncios.PASS);
            stmt = con.createStatement();

            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS ").append(C_Tablon_Anuncios.T_USUARIO);
            System.out.println("\t\tQuery : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());

            // Creamos la tabla user
            sb.setLength(0);
            sb.append("CREATE TABLE ").append(C_Tablon_Anuncios.T_USUARIO).append(" (")
                    .append(C_Tablon_Anuncios.IDUSUARIO).append(" INT(10) NOT NULL AUTO_INCREMENT,")
                    .append(C_Tablon_Anuncios.PASSWORD).append(" VARCHAR(20),")
                    .append(C_Tablon_Anuncios.NOMBRE).append(" VARCHAR(20),")
                    .append(C_Tablon_Anuncios.APELLIDO).append(" VARCHAR(20),")
                    .append("PRIMARY KEY(id_usuario)")
                    .append(")");
            System.out.println("\t\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            stmt.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            resultado = false;
            System.out.println("Error: " + ex.getLocalizedMessage());
        } catch (SQLException e) {
            resultado = false;
            System.out.println("Error : " + e.getLocalizedMessage());
        } finally {
            return resultado;
        }
    }

    public static boolean crearTablaAnuncios() {
        System.out.println("\tCreando la tabla de anuncios en la BD...");
        Connection con;
        Statement stmt;
        String createString;
        String dropString;
        boolean resultado = true;
        int res = 0;

        createString = "CREATE TABLE "
                + C_Tablon_Anuncios.T_ANUNCIO
                + " ("
                + C_Tablon_Anuncios.IDANUNCIO
                + " int(10) NOT NULL AUTO_INCREMENT, "
                + C_Tablon_Anuncios.TEMA
                + " VARCHAR(50) NOT NULL, "
                + C_Tablon_Anuncios.MENSAJE
                + " VARCHAR(250) NOT NULL ,"
                + C_Tablon_Anuncios.IDUSUARIO
                + " int(10) NOT NULL, "
                + // clave foreign
                "PRIMARY KEY("
                + C_Tablon_Anuncios.IDANUNCIO
                + ")" + ")";

        dropString = "DROP TABLE IF EXISTS " + C_Tablon_Anuncios.T_ANUNCIO;

        try {
            Class.forName(C_Tablon_Anuncios.DRIVER);
            con = DriverManager.getConnection(C_Tablon_Anuncios.URL, C_Tablon_Anuncios.USUARIO, C_Tablon_Anuncios.PASS);
            stmt = con.createStatement();

            // Primero borro la tabla si existe
            System.out.println("\t\tQuery: " + dropString);
            res = stmt.executeUpdate(dropString);

            // Ahora creamos la tabla 'anuncio'
            System.out.println("\t\tQuery: " + createString);
            res = stmt.executeUpdate(createString);
            stmt.close();
            con.close();
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: " + e.getLocalizedMessage());
            resultado = false;
        } catch (SQLException ex) {
            resultado = false;
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            return resultado;
        }
    }

    public static boolean insertarUsuarios() {
        Connection con;
        Statement stmt;
        StringBuilder sb = new StringBuilder();
        boolean resultado = true;
        int res;

        try {
            Class.forName(C_Tablon_Anuncios.DRIVER);
            con = DriverManager.getConnection(C_Tablon_Anuncios.URL, C_Tablon_Anuncios.USUARIO, C_Tablon_Anuncios.PASS);
            stmt = con.createStatement();

            // Insertamos dos registros en la tabla user
            sb.setLength(0);
            sb.append("INSERT INTO ").append(C_Tablon_Anuncios.T_USUARIO).append(" VALUES ")
                    .append("(1,'pass1','Juan Francisco','Ruiz'),")
                    .append("(2,'pass2','Roberto','Mena'),")
                    .append("(3,'pass3','Carlos','Sánchez')");

            System.out.println("\t\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            System.out.println("\t\tRegistros insertados :" + res);
            stmt.close();
            con.close();
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: " + e.getLocalizedMessage());
            resultado = false;
        } catch (SQLException ex) {
            resultado = false;
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            return resultado;
        }
    }

    public static boolean consultarTablaUsuarios() {
        Connection con;
        Statement stmt;
        StringBuilder sb = new StringBuilder();
        boolean resultado = true;

        try {
            Class.forName(C_Tablon_Anuncios.DRIVER);
            con = DriverManager.getConnection(C_Tablon_Anuncios.URL, C_Tablon_Anuncios.USUARIO, C_Tablon_Anuncios.PASS);
            stmt = con.createStatement();
            // Consulta de la inserción realizada
            sb.setLength(0);
            sb.append("SELECT ")
                    .append(C_Tablon_Anuncios.IDUSUARIO).append(",")
                    .append(C_Tablon_Anuncios.PASSWORD).append(",")
                    .append(C_Tablon_Anuncios.NOMBRE).append(",")
                    .append(C_Tablon_Anuncios.APELLIDO)
                    .append(" FROM ").append(C_Tablon_Anuncios.T_USUARIO);
            System.out.println("\t\tQuery: " + sb.toString());
            ResultSet rs = stmt.executeQuery(sb.toString());
            StringBuilder sbr = new StringBuilder();

            while (rs.next()) {
                sbr.setLength(0);
                sbr.append("\t\t\t");
                sbr.append(rs.getString(1))
                        .append(",")
                        .append(rs.getString(2))
                        .append(",")
                        .append(rs.getString(3))
                        .append(",")
                        .append(rs.getString(4));
                System.out.println(sbr.toString());
            }

            stmt.close();
            con.close();
        } catch (ClassNotFoundException ex) {
            resultado = false;
            System.out.println("Error: " + ex.getLocalizedMessage());
        } catch (SQLException ex) {
            resultado = false;
            System.err.println("SQLException: " + ex.getLocalizedMessage());
        } finally {
            return resultado;
        }
    }

    public static void pausar(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConfiguraTablas_Tablon_Anuncios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
