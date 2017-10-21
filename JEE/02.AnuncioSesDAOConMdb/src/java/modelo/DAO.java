/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import auxiliar.C;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;

public class DAO {

    private static DataSource obtenerDS() {
        DataSource ds = null;
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup(C.JNDI);
        } catch (NamingException ex) {
            System.out.println("Error JNDI " + ex);
        }
        return ds;
    }

    public static void insertarAnuncio(Anuncio a) {
        System.out.println("DAO.insertarAnuncio(" + a.toString() + ") - INICIO");
        int idUser = 15;

        String query
                = "INSERT INTO "
                + C.T_ANUNCIO
                + " ("
                + C.TEMA
                + ", "
                + C.MENSAJE
                + ", "
                + C.IDUSUARIO
                + ") "
                + " VALUES ('" + a.getTema() + "','" + a.getMensaje() + "'," + idUser + ")";
        System.out.println(query);
        try (Connection con = obtenerDS().getConnection();
                Statement stmt = con.createStatement()) {

            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        System.out.println("DAO.insertarAnuncio() - FIN");
    }
}
