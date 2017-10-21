/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;


public class DAO {

    
    private static DataSource obtenerDS(){
        DataSource ds = null;
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/ejMysql");
        } catch (NamingException ex) {
            System.out.println("Horror en el contexto "+ex);
        }
        return ds;
    }
    

    public static Usuario seleccionarUsuario(String user, String password) {

        Usuario usuRetorno = null;
        String query = "SELECT * "
                + " FROM usuario WHERE id_usuario='" + user + "'"
                + "AND password='" + password + "'";
        System.out.println(query);
        try (Connection con = obtenerDS().getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                usuRetorno = new Usuario(rs.getString(1),
                        rs.getString(2));
                usuRetorno.setIdUser(rs.getString(3));
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return usuRetorno;
    }

    public static void insertarUsuario(String idUser, Anuncio a) {
        String query
                = "INSERT INTO Anuncio VALUES ('" + idUser + "','"
                + a.getTema() + "','" + a.getMensaje() + "')";
        System.out.println(query);
        try (Connection con = obtenerDS().getConnection();
                Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
}
