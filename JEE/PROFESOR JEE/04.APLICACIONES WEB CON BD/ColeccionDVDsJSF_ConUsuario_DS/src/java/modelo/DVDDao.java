/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author Jesus
 */
public class DVDDao {

    private static DataSource obtenerDS() {
        DataSource ds = null;
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("jdbc/ejMysql");
            System.out.println("datasource: " + ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    public static Usuario seleccionarUsuario(String user, String password) {

        Usuario usuRetorno = null;
        String query = "SELECT NOMBRE_PILA, APELLIDO "
                + " FROM usuario WHERE id_usuario='" + user + "'"
                + " AND password='" + password + "'";
        System.out.println(query);
        try (Connection con = obtenerDS().getConnection();
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);) {

            while (rs.next()) {
                usuRetorno = new Usuario(rs.getString(1),
                        rs.getString(2));
                usuRetorno.setUser(user);
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

        return usuRetorno;
    }

    public static void insertarDVD(DVD dvd, String idUser) {
        try {
            Connection con = obtenerDS().getConnection();
            Statement stmt = con.createStatement();

            // Mirariamos en la coleccion si existe ya el titulo 
            // Spongamos que 
            boolean existeTitulo = false;
            String ins = "SELECT id_dvd FROM ColeccionDVDS WHERE titulo='" + dvd.getTitulo() + "'";
            System.out.println(ins);
            ResultSet rs = stmt.executeQuery(ins);
            String iddvd = null;
            if (rs.next()) {
                iddvd = rs.getString(1);
                existeTitulo = true;
            }
            // si no existe titulo, lo insertamos en ColeccionDVDs y en la tabla enlace
            if (!existeTitulo) {
                ins = "INSERT INTO ColeccionDVDS (titulo, director) VALUES ('"
                        + dvd.getTitulo() + "','" + dvd.getDirector() + "')";
                System.out.println(ins);
                stmt.executeUpdate(ins);
                // Para ver con que id se ha puesto
                ins = "SELECT id_dvd FROM ColeccionDVDS WHERE titulo='" + dvd.getTitulo() + "'";
                System.out.println(ins);
                rs = stmt.executeQuery(ins);
                iddvd = null;
                if (rs.next()) {
                    iddvd = rs.getString(1);
                }

                ins = "INSERT INTO DVD_USUARIO (id_dvd, id_usuario) VALUES ("
                        + iddvd + ",'" + idUser + "')";
                System.out.println(ins);
                stmt.executeUpdate(ins);
            } else {
                // Si existe titulo, o si ya esta en la tabla de enlace no hago nada
                // y si no existe lo agrego
                ins = "SELECT id_dvd, id_usuario FROM dvd_usuario WHERE "
                        + "id_dvd=" + iddvd + " AND id_usuario='" + idUser + "'";
                System.out.println(ins);
                rs = stmt.executeQuery(ins);
                boolean dvdEnTablaEnlace = false;
                if (rs.next()) {
                    dvdEnTablaEnlace = true;
                }
                if (!dvdEnTablaEnlace) {
                    ins = "INSERT INTO DVD_USUARIO (id_dvd, id_usuario) VALUES ("
                            + iddvd + ",'" + idUser + "')";
                    System.out.println(ins);
                    stmt.executeUpdate(ins);
                }
            }
            con.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    public static List<DVD> seleccionarDVDs(String iduser) {
        List<DVD> lista = null;
        try {
            Connection con = obtenerDS().getConnection();
            Statement stmt = con.createStatement();

            String query = "select * from colecciondvds "
                    + " where id_dvd IN "
                    + "(select id_dvd from dvd_usuario where id_usuario='"
                    + iduser + "')";
            System.out.println(query);
            // Nota: Si quisiera averiguar los titulos que no tiene ningun usuario diria:
            // select titulo from colecciondvds where id_dvd not in (select id_dvd from dvd_usuario where id_dvd = colecciondvds.id_dvd);)
            lista = new ArrayList<DVD>();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DVD d = new DVD(rs.getString(2), rs.getString(3));
                lista.add(d);
            }

            con.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return lista;
    }

    static void borrarDVD(DVD dvd, String idUser) {
        try {
            Connection con = obtenerDS().getConnection();
            Statement stmt = con.createStatement();

            String ins = "SELECT id_dvd FROM ColeccionDVDS WHERE titulo='" + dvd.getTitulo() + "'";
            System.out.println(ins);
            ResultSet rs = stmt.executeQuery(ins);
            String iddvd = null;
            if (rs.next()) {
                iddvd = rs.getString(1);
            }

            ins = "DELETE FROM DVD_USUARIO WHERE id_dvd=" + iddvd
                    + " AND id_usuario='" + idUser + "'";
            System.out.println(ins);
            stmt.executeUpdate(ins);

            con.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    static void modificarDVD(DVD dvd) {
        try {
            Connection con = obtenerDS().getConnection();
            Statement stmt = con.createStatement();

            String ins = "UPDATE ColeccionDVDS SET director='" + dvd.getDirector() + "' WHERE titulo='" + dvd.getTitulo() + "'";
            System.out.println(ins);

            stmt.executeUpdate(ins);

            con.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    static DVD buscarDVD(String tit) {
        DVD dvdret = null;
        try {
            Connection con = obtenerDS().getConnection();
            Statement stmt = con.createStatement();

            String query = "select * from colecciondvds "
                    + " where titulo = '"
                    + tit + "'";
            System.out.println(query);

            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                dvdret = new DVD(rs.getString(2), rs.getString(3));
            }

            con.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return dvdret;
    }
}
