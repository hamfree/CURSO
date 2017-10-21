package auxiliar;

// Antes de nada, si usamos MS Access debemos dar de alta una
// Base da Datos. Entramos en Access y creamos una BD en blanco 
// llamada Videos.mdb y luego configuramos el ODBC

import java.sql.*;

public class UsuarioInsercion {
    public static void main(String args[]) {
        String url = "jdbc:mysql://localhost:3306/world";
        Connection con;
   
          Statement stmt;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(url, "root", "welcome1");
            stmt = con.createStatement();
            
              
            // Comienzo la insercion
            for (int i = 0; i < cads.length; i++) {
                    System.out.println(cads[i]);
               int nci = stmt.executeUpdate(cads[i]);
            
            }        
            System.out.println("cols insertadas: " + cads.length);
            stmt.close();
            con.close();

        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
    
    static String cads [] = {
    "INSERT INTO usuario VALUES ('pepe','fdez','jose', 'password')",
    "INSERT INTO usuario VALUES ('paco','glez','francisco', 'password')",
    "INSERT INTO usuario VALUES ('maribel','pelaez','Maria Isabel', 'password')"
    };
}
