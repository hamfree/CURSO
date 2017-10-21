/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 *
 * @author curso
 */
public class CrearTablas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date fi = new Date(System.currentTimeMillis());

        crearTablaUsuarios();
        crearTablaAnuncios();

        Date ff = new Date(System.currentTimeMillis());
        System.out.println("Inicio:" + fi + ",Fin:" + ff);
    }

    public static void crearTablaUsuarios() {
        String url = "jdbc:mysql://localhost:3306/world";
        String usuario = "root";
        String password = "welcome1";
        String controlador = "com.mysql.jdbc.Driver";
        Connection con;
        Statement stmt;

        try {
            Class.forName(controlador);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
        StringBuilder sb = new StringBuilder();
        try {
            con = DriverManager.getConnection(url, usuario, password);
            stmt = con.createStatement();

            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS user");

            System.out.println("Query : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());
            System.out.println("Resultado : " + res);

            // Creamos la tabla user
            sb.setLength(0);
            sb.append("CREATE TABLE user (")
                    .append("id_usuario INT(10) NOT NULL AUTO_INCREMENT,")
                    .append("password VARCHAR(20),")
                    .append("nombre_pila VARCHAR(20),")
                    .append("apellido VARCHAR(20),")
                    .append("PRIMARY KEY(id_usuario)")
                    .append(")");
            System.out.println("Query : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            System.out.println("Resultado : " + res);

            sb.setLength(0);

            // Insertamos dos registros en la tabla user
            sb.append("INSERT INTO user VALUES ")
                    .append("(1,'pass1','Juan Francisco','Ruiz'),")
                    .append("(2,'pass2','Roberto','Mena')");

            System.out.println("Query : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            System.out.println("Resultado : " + res);

            // Consulta de la inserción realizada
            sb.setLength(0);
            sb.append("SELECT id_usuario, password, nombre_pila, apellido FROM user");
            System.out.println("Query: " + sb.toString());
            ResultSet rs = stmt.executeQuery("SELECT id_usuario, password, nombre_pila, apellido FROM user");
            StringBuilder sbr = new StringBuilder();
            sbr.setLength(0);
            while (rs.next()) {
                sbr.append(rs.getString(1))
                        .append(",")
                        .append(rs.getString(2))
                        .append(",")
                        .append(rs.getString(3))
                        .append(",")
                        .append(rs.getString(4));
                System.out.println(sbr.toString());
            }

        } catch (SQLException e) {
            System.out.println("Error : " + e);

        }
    }

    public static void crearTablaAnuncios() {
        String url = "jdbc:mysql://localhost:3306/world";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "welcome1";
        Connection con;
        String createString;

        createString = "CREATE TABLE anuncio "
                + "(id_anuncio VARCHAR(10) NOT NULL, "
                + "tema VARCHAR(10) NOT NULL, "
                + "anuncio VARCHAR(50) NOT NULL ,"
                + "id_usuario VARCHAR(10) NOT NULL, " + // clave foreign
                "PRIMARY KEY(id_anuncio)" + ")";

        Statement stmt;

        try {
            Class.forName(driver);
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, usuario, password);
            stmt = con.createStatement();

            // Primero borro la tabla si existe
            try {
                System.out.println("Borro la tabla 'anuncio' si existe");
                stmt.executeUpdate("DROP TABLE IF EXISTS anuncio");
            } catch (SQLException ex) {
                System.err.println("SQLException al borrar tabla: " + ex.getMessage());
            }
            System.out.println(createString);

            // Ahora creamos la tabla 'anuncio'
            stmt.executeUpdate(createString);

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
