/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/world";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String pass = "welcome1";

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("--->Horror "+ex);
        }

        try (Connection con = java.sql.DriverManager.getConnection(url, usuario, pass);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT name, countrycode, population FROM city");) {

            while (rs.next()) {
                System.out.println(rs.getString(1) + " - " + rs.getString(2)
                        + " - " + rs.getString(3));
            }
        }catch (SQLException e){
            System.out.println("--->Horror "+e);
        }
    }

}
