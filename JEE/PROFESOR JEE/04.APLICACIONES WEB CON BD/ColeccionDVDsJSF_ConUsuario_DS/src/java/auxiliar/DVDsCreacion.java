package auxiliar;

// Antes de nada, si usamos MS Access debemos dar de alta una
// Base da Datos. Entramos en Access y creamos una BD en blanco 
// llamada Videos.mdb y luego configuramos el ODBC
import java.sql.*;

public class DVDsCreacion {

    public static void main(String args[]) {
                String url = "jdbc:mysql://localhost:3306/world";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String pass = "welcome1";
        Connection con;
        String createString;
        // Detras de cada tipo se puede poner NOT NULL, 
        // pero Text Files no lo admite
        createString = "create table ColeccionDVDS "
                + "(id_dvd INT NOT NULL AUTO_INCREMENT, "
                + "titulo VARCHAR(50) NOT NULL, "
                + "director VARCHAR(20) NOT NULL,"
                + " PRIMARY KEY(id_dvd)" + ")";

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
                stmt.executeUpdate("drop table ColeccionDVDS");
            } catch (SQLException ex) {
                System.err.println("SQLException al borrar tabla: " + ex.getMessage());
            }
            System.out.println("Creo tabla");
            System.out.println(createString);
            stmt.executeUpdate(createString);

            // Comienzo la insercion
            System.out.println("comienza la insercion");
            for (int i = 0; i < cads.length; i++) {
                int nci = stmt.executeUpdate(cads[i]);
            }
            System.out.println("cols insertadas: " + cads.length);
            stmt.close();
            con.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    static String cads[] = {
        "INSERT INTO ColeccionDVDS (titulo, director) VALUES ('La Diligencia','John Ford')",
        "INSERT INTO ColeccionDVDS (titulo, director) VALUES ('Lo que el viento se llevo','Victor Fleming')"
    };
}
