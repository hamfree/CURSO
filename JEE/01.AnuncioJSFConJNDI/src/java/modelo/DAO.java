package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import utiles.C;

public class DAO {

    static DAO g = new DAO();
    private Connection con = null;
    private Statement stmt = null;

    private DAO() {
    }

    public static DAO getInstance() {
        return getG();
    }

    public static DAO getG() {
        return g;
    }

    private static javax.sql.DataSource obtenerDS() {
        DataSource ds = null;
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup(C.JNDI);
        } catch (NamingException e) {
            System.out.println("Excepción al obtener la fuente de datos: " + e);
        }
        return ds;
    }

    public Usuario dameUsuario(String nombre, String password) {
        Usuario u = null;
        StringBuilder sb = new StringBuilder();
        try {
            conectar();
            sb.setLength(0);
            sb.append("SELECT ")
                    .append(C.IDUSUARIO)
                    .append(", ")
                    .append(C.PASSWORD)
                    .append(", ")
                    .append(C.NOMBRE)
                    .append(", ")
                    .append(C.APELLIDO)
                    .append(" FROM ")
                    .append(C.T_USUARIO)
                    .append(" WHERE ")
                    .append(C.NOMBRE).append(" = '").append(nombre)
                    .append("' AND ")
                    .append(C.PASSWORD).append(" = '").append(password).append("'");
            ResultSet rs = stmt.executeQuery(sb.toString());
            while (rs.next()) {
                u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                System.out.println("Usuario encontrado : " + u.toString());
            }
            cerrarConexion();

        } catch (SQLException e) {
            System.out.println("Error en DAO : " + e);

        } finally {
            try {
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error en DAO : " + ex);
            }
        }
        return u;
    }

    public boolean crearAnuncio(String tema, String texto, String nombre_pila) {
        Usuario u = null;
        boolean resultado = false;
        int registros = 0;

        StringBuilder sb = new StringBuilder();
        try {
            conectar();
            sb.setLength(0);
             sb.append("SELECT ")
                    .append(C.IDUSUARIO)
                    .append(", ")
                    .append(C.PASSWORD)
                    .append(", ")
                    .append(C.NOMBRE)
                    .append(", ")
                    .append(C.APELLIDO)
                    .append(" FROM ")
                    .append(C.T_USUARIO);
            sb.append(" WHERE ")
                    .append("nombre_pila").append(" = '").append(nombre_pila).append("'");
            ResultSet rs = stmt.executeQuery(sb.toString());
            while (rs.next()) {
                u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                System.out.println("Usuario encontrado : " + u.toString());
            }

            if (u == null) {
                System.out.println("El usuario con nombre '" + nombre_pila + "' no existe en la BD");
                resultado = false;
                return resultado;
            }

            sb.setLength(0);
            sb.append("INSERT INTO ").append(C.T_ANUNCIO)
                    .append(" (")
                    .append(C.TEMA)
                    .append(",")
                    .append(C.MENSAJE)
                    .append(",")
                    .append(C.IDUSUARIO)
                    .append(") ")
                    .append("VALUES ('")
                    .append(tema).append("','")
                    .append(texto).append("','")
                    .append(u.getUser())
                    .append("')");
            registros = stmt.executeUpdate(sb.toString());
            if (registros == 1) {
                resultado = true;
            }
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error en DAO : " + e);

        } finally {
            try {
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error en DAO : " + ex);
            }
        }
        return resultado;
    }

    public void conectar() throws SQLException {
        con = obtenerDS().getConnection();
        setStmt(getCon().createStatement());
    }

    public void cerrarConexion() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
}
