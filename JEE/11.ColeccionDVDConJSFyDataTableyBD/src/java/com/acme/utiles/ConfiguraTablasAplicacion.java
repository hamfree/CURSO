package com.acme.utiles;

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
public class ConfiguraTablasAplicacion {

    Connection con;
    Statement stmt;

    public ConfiguraTablasAplicacion() {
        try {
            Class.forName(C.CONTROLADOR);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al instanciar el controlador MySQL: " + ex.getLocalizedMessage());
        }
    }

    public void conectar() {
        try {
            con = DriverManager.getConnection(C.URL, C.USUARIO, C.CLAVE);
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
        ConfiguraTablasAplicacion cta = new ConfiguraTablasAplicacion();
        cta.crearTablaUsuarios();
        cta.crearTablaUsuariosDvds();
        cta.crearTablaDvds();
    }

    public void crearTablaUsuarios() {
        C.dbg(ConfiguraTablasAplicacion.class,"\tCreando la tabla de usuarios en la BD e insertando tres usuarios...");

        conectar();
        StringBuilder sb = new StringBuilder();
        try {
            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS ").append(C.USER);

            C.dbg(ConfiguraTablasAplicacion.class,"\tQuery : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());
            C.dbg(ConfiguraTablasAplicacion.class,"\tResultado : " + res);

            // Creamos la tabla user
            sb.setLength(0);
            sb.append("CREATE TABLE ").append(C.USER).append(" (")
                    .append(C.ID_USU).append(" INT(").append(C.TAM_KEY).append(")").append(C.NOTNULL).append(C.AUTINC).append(",")
                    .append(C.PASS).append(" VARCHAR(").append(C.TAM_STR).append("),")
                    .append(C.NOMB).append(" VARCHAR(").append(C.TAM_STR).append("),")
                    .append(C.APEL).append(" VARCHAR(").append(C.TAM_STR).append("),")
                    .append("PRIMARY KEY(").append(C.ID_USU).append(")")
                    .append(")");
            C.dbg(ConfiguraTablasAplicacion.class,"\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            C.dbg(ConfiguraTablasAplicacion.class,"\tResultado : " + res);

            sb.setLength(0);

            // Insertamos dos registros en la tabla user
            sb.append("INSERT INTO ").append(C.USER)
                    .append(" (")
                    .append(C.PASS).append(",").append(C.NOMB).append(",").append(C.APEL)
                    .append(") VALUES ")
                    .append("('juib','Julian','Ibañez'),")
                    .append("('rome','Roberto','Mena'),")
                    .append("('juru','Juan','Ruiz')");

            C.dbg(ConfiguraTablasAplicacion.class,"\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            C.dbg(ConfiguraTablasAplicacion.class,"\tResultado : " + res);

            // Consulta de la inserción realizada
            sb.setLength(0);
            sb.append("SELECT ").append(C.ID_USU).append(",")
                    .append(C.PASS).append(",")
                    .append(C.NOMB).append(",")
                    .append(C.APEL)
                    .append(" FROM ")
                    .append(C.USER);
            C.dbg(ConfiguraTablasAplicacion.class,"\tQuery: " + sb.toString());
            ResultSet rs = stmt.executeQuery(sb.toString());
            
            StringBuilder sbr = new StringBuilder();
            sbr.setLength(0);
            C.dbg(ConfiguraTablasAplicacion.class,C.LS);
            C.dbg(ConfiguraTablasAplicacion.class,C.LS + "TABLA DE USUARIOS");
            sbr.setLength(0);
            while (rs.next()) {
                sbr.append(rs.getString(1))
                        .append(",")
                        .append(rs.getString(2))
                        .append(",")
                        .append(rs.getString(3))
                        .append(",")
                        .append(rs.getString(4))
                        .append(C.LS);
            }
            C.dbg(ConfiguraTablasAplicacion.class,sbr.toString());

        } catch (SQLException e) {
            System.out.println("Error : " + e);
        }
    }

    public void crearTablaUsuariosDvds() {
        C.dbg(ConfiguraTablasAplicacion.class,"\tCreando la tabla de UsuariosPeliculas en la BD...");

        StringBuilder sb = new StringBuilder();
        try {
            conectar();
            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS ").append(C.USERSDVDS);

            C.dbg(ConfiguraTablasAplicacion.class,"\tQuery : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());
            C.dbg(ConfiguraTablasAplicacion.class,"\tResultado : " + res);

            // Creamos la tabla user
            sb.setLength(0);
            sb.append("CREATE TABLE ").append(C.USERSDVDS).append(" (")
                    .append(C.ID_USU).append(" INT(").append(C.TAM_KEY).append(")").append(C.NOTNULL).append(",")
                    .append(C.ID_PEL).append(" INT(").append(C.TAM_KEY).append(")").append(C.NOTNULL).append(",")
                    .append("PRIMARY KEY(").append(C.ID_USU).append(",").append(C.ID_PEL).append(")")
                    .append(")");
            C.dbg(ConfiguraTablasAplicacion.class,"\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            C.dbg(ConfiguraTablasAplicacion.class,"\tResultado : " + res);
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
        C.dbg(ConfiguraTablasAplicacion.class,"\tCreando la tabla de DVDs en la BD...");
        StringBuilder sb = new StringBuilder();

        try {
            conectar();
            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS ").append(C.DVDS);

            C.dbg(ConfiguraTablasAplicacion.class,"\tQuery : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());
            C.dbg(ConfiguraTablasAplicacion.class,"\tResultado : " + res);

            sb.setLength(0);
            sb.append("CREATE TABLE ").append(C.DVDS).append(" (")
                    .append(C.ID_PEL).append(" INT(").append(C.TAM_KEY).append(")").append(C.AUTINC).append(C.NOTNULL).append(", ")
                    .append(C.TITU).append(" VARCHAR(").append(C.TAM_STR).append("), ")
                    .append(C.DTOR).append(" VARCHAR(").append(C.TAM_STR).append("), ")
                    .append("PRIMARY KEY (").append(C.ID_PEL).append(")")
                    .append(")");
            C.dbg(ConfiguraTablasAplicacion.class,"\tQuery : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            C.dbg(ConfiguraTablasAplicacion.class,"\tResultado : " + res);
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