/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author curso
 */
public class MiMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Date fi = new Date(System.currentTimeMillis());
        String url = "jdbc:mysql://localhost:3306/world";
        String usuario = "root";
        String password = "welcome1";
        String controlador = "com.mysql.jdbc.Driver";
        int contador = 0;

        try {
            Class.forName(controlador);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MiMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        StringBuilder sb = new StringBuilder();
        try (Connection con = DriverManager.getConnection(url, usuario, password);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT name, countrycode, population FROM city");) {
            while (rs.next()) {
                contador++;
                sb.setLength(0);
                sb.append(rs.getString("name")).append(", ").append(rs.getString("countrycode")).append(", ").append(rs.getString("population"));
                System.out.println( sb.toString() );
            }
            System.out.println("Total de registros:" + contador);
        } catch (SQLException e) {
            System.out.println("--- Error : " + e);
        }
        Date ff = new Date(System.currentTimeMillis());
        System.out.println("Inicio:" + fi + ",Fin:" + ff);
    }
}


