package auxiliar;

// Antes de nada, si usamos MS Access debemos dar de alta una
// Base da Datos. Entramos en Access y creamos una BD en blanco 
// llamada Videos.mdb y luego configuramos el ODBC
import java.sql.*;

public class AnuncioCreacion {

    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/world";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String pass = "welcome1";
        Connection con;
        String createString;

        createString = "create table ANUNCIO "
                + "(id_usuario VARCHAR(10) NOT NULL, "
                + "tema VARCHAR(10) NOT NULL, "
                + "anuncio VARCHAR(20) NOT NULL )";

        Statement stmt;

        try {
            Class.forName(driver);
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, usuario, pass);
            stmt = con.createStatement();

            // Primero borro la tabla si existe
            try {
                System.out.println("Borro tabla si existe");
                stmt.executeUpdate("drop table ANUNCIO");
            } catch (SQLException ex) {
                System.err.println("SQLException al borrar tabla: " + ex.getMessage());
            }
            System.out.println(createString);
            stmt.executeUpdate(createString);

            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

}
