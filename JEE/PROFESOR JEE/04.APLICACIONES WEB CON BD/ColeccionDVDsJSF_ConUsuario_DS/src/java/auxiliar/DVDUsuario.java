package auxiliar;

// Antes de nada, si usamos MS Access debemos dar de alta una
// Base da Datos. Entramos en Access y creamos una BD en blanco 
// llamada Videos.mdb y luego configuramos el ODBC

import static auxiliar.UsuarioCreacion.cads;
import java.sql.*;

public class DVDUsuario {
    public static void main(String args[]) {
               String url = "jdbc:mysql://localhost:3306/world";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String pass = "welcome1";
        Connection con;
        String createString;

        createString = "create table DVD_USUARIO " +
                  "(id_dvd INT NOT NULL, " +
               "id_usuario VARCHAR(10) NOT NULL  )" ;
        
       
          Statement stmt;

        try {
            Class.forName(driver);
        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, usuario, pass);
            stmt = con.createStatement();
            
            // Primero borro la tabla si existe
            try {
                System.out.println("Borro tabla si existe");
                stmt.executeUpdate("drop table DVD_USUARIO");
            } catch(SQLException ex) {
                System.err.println("SQLException al borrar tabla: " + ex.getMessage());
             }
            System.out.println(createString);
            stmt.executeUpdate(createString);
              
           // Comienzo la insercion
            for (int i = 0; i < cads.length; i++) {
                    System.out.println(cads[i]);
               int nci = stmt.executeUpdate(cads[i]);           
            }        
            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
    
      static String cads[] = {
        "INSERT INTO DVD_USUARIO  VALUES (1,'pepe')",
          "INSERT INTO DVD_USUARIO  VALUES (1,'paco')",
          "INSERT INTO DVD_USUARIO  VALUES (2,'pepe')",
          "INSERT INTO DVD_USUARIO  VALUES (2,'paco')"
    };
    
}
