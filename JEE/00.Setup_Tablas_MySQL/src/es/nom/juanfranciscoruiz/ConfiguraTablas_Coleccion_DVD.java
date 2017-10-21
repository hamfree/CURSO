package es.nom.juanfranciscoruiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Crea las tablas necesasarias para la aplicación en la BBDD así como los
 * usuarios de la aplicación.
 * 
 * @author hamfree
 */
public class ConfiguraTablas_Coleccion_DVD {

    Connection con;
    Statement stmt;

    public ConfiguraTablas_Coleccion_DVD() {
        try {
            Class.forName(C_Coleccion_DVD.CONTROLADOR);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al instanciar el controlador MySQL: " + ex.getLocalizedMessage());
        }
    }

    public void conectar() {
        try {
            con = DriverManager.getConnection(C_Coleccion_DVD.URL, C_Coleccion_DVD.USUARIO, C_Coleccion_DVD.CLAVE);
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error al obtener la conexión a la BD :" + ex.getLocalizedMessage());
        }
    }

    public void cerrarConexion() {
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión a la BD :" + ex.getLocalizedMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    public static void main(String[] args) {
        ConfiguraTablas_Coleccion_DVD cta = new ConfiguraTablas_Coleccion_DVD();
        cta.crearTablaUsuarios();
        cta.crearTablaUsuariosDvds();
        cta.crearTablaDvds();
    }

    public void crearTablaUsuarios() {
        C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tCreando la tabla de usuarios en la BD e insertando tres usuarios...");

        conectar();
        StringBuilder sb = new StringBuilder();
        try {
            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS ").append(C_Coleccion_DVD.USER);

            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tQuery : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tResultado : " + res);

            // Creamos la tabla user
            sb.setLength(0);
            sb.append("CREATE TABLE ").append(C_Coleccion_DVD.USER).append(" (")
                    .append(C_Coleccion_DVD.ID_USU).append(" INT(").append(C_Coleccion_DVD.TAM_KEY).append(")").append(C_Coleccion_DVD.NOTNULL).append(C_Coleccion_DVD.AUTINC).append(",")
                    .append(C_Coleccion_DVD.PASS).append(" VARCHAR(").append(C_Coleccion_DVD.TAM_STR).append("),")
                    .append(C_Coleccion_DVD.NOMB).append(" VARCHAR(").append(C_Coleccion_DVD.TAM_STR).append("),")
                    .append(C_Coleccion_DVD.APEL).append(" VARCHAR(").append(C_Coleccion_DVD.TAM_STR).append("),")
                    .append("PRIMARY KEY(").append(C_Coleccion_DVD.ID_USU).append(")")
                    .append(")");
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tResultado : " + res);

            sb.setLength(0);

            // Insertamos dos registros en la tabla user
            sb.append("INSERT INTO ").append(C_Coleccion_DVD.USER)
                    .append(" (")
                    .append(C_Coleccion_DVD.PASS).append(",").append(C_Coleccion_DVD.NOMB).append(",").append(C_Coleccion_DVD.APEL)
                    .append(") VALUES ")
                    .append("('juib','Julian','Ibañez'),")
                    .append("('rome','Roberto','Mena'),")
                    .append("('juru','Juan','Ruiz')");

            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tResultado : " + res);

            // Consulta de la inserción realizada
            sb.setLength(0);
            sb.append("SELECT ").append(C_Coleccion_DVD.ID_USU).append(",")
                    .append(C_Coleccion_DVD.PASS).append(",")
                    .append(C_Coleccion_DVD.NOMB).append(",")
                    .append(C_Coleccion_DVD.APEL)
                    .append(" FROM ")
                    .append(C_Coleccion_DVD.USER);
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tQuery: " + sb.toString());
            ResultSet rs = stmt.executeQuery(sb.toString());
            
            StringBuilder sbr = new StringBuilder();
            sbr.setLength(0);
            C_Coleccion_DVD.dbg(null,C_Coleccion_DVD.LS + "TABLA DE USUARIOS");
            sbr.setLength(0);
            while (rs.next()) {
                sbr.append(rs.getString(1))
                        .append(",")
                        .append(rs.getString(2))
                        .append(",")
                        .append(rs.getString(3))
                        .append(",")
                        .append(rs.getString(4))
                        .append(C_Coleccion_DVD.LS);
            }
            C_Coleccion_DVD.dbg(null,sbr.toString());

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }

    public void crearTablaUsuariosDvds() {
        C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tCreando la tabla de UsuariosPeliculas en la BD...");

        StringBuilder sb = new StringBuilder();
        try {
            conectar();
            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS ").append(C_Coleccion_DVD.USERSDVDS);

            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tQuery : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tResultado : " + res);

            // Creamos la tabla user
            sb.setLength(0);
            sb.append("CREATE TABLE ").append(C_Coleccion_DVD.USERSDVDS).append(" (")
                    .append(C_Coleccion_DVD.ID_USU).append(" INT(").append(C_Coleccion_DVD.TAM_KEY).append(")").append(C_Coleccion_DVD.NOTNULL).append(",")
                    .append(C_Coleccion_DVD.ID_PEL).append(" INT(").append(C_Coleccion_DVD.TAM_KEY).append(")").append(C_Coleccion_DVD.NOTNULL).append(",")
                    .append("PRIMARY KEY(").append(C_Coleccion_DVD.ID_USU).append(",").append(C_Coleccion_DVD.ID_PEL).append(")")
                    .append(")");
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tResultado : " + res);
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error : " + e);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    public void crearTablaDvds() {
        C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tCreando la tabla de DVDs en la BD...");
        StringBuilder sb = new StringBuilder();

        try {
            conectar();
            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS ").append(C_Coleccion_DVD.DVDS);

            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tQuery : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tResultado : " + res);

            sb.setLength(0);
            sb.append("CREATE TABLE ").append(C_Coleccion_DVD.DVDS).append(" (")
                    .append(C_Coleccion_DVD.ID_PEL).append(" INT(").append(C_Coleccion_DVD.TAM_KEY).append(")").append(C_Coleccion_DVD.AUTINC).append(C_Coleccion_DVD.NOTNULL).append(", ")
                    .append(C_Coleccion_DVD.TITU).append(" VARCHAR(").append(C_Coleccion_DVD.TAM_STR).append("), ")
                    .append(C_Coleccion_DVD.DTOR).append(" VARCHAR(").append(C_Coleccion_DVD.TAM_STR).append("), ")
                    .append("PRIMARY KEY (").append(C_Coleccion_DVD.ID_PEL).append(")")
                    .append(")");
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            C_Coleccion_DVD.dbg(ConfiguraTablas_Coleccion_DVD.class,"\tResultado : " + res);
            cerrarConexion();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
            }
        }
    }
}