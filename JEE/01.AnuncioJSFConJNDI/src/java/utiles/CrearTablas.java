package utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

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
        System.out.println("Creando la tabla de usuarios en la BD e insertando dos usuarios...");
        
        Connection con;
        Statement stmt;

        try {
            Class.forName(C.DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: " + ex);
        }
        StringBuilder sb = new StringBuilder();
        try {
            con = DriverManager.getConnection(C.URL, C.USUARIO, C.PASS);
            stmt = con.createStatement();

            // Borramos la tabla user si existe...
            sb.append("DROP TABLE IF EXISTS ").append(C.T_USUARIO);

            System.out.println("Query : " + sb.toString());
            int res = stmt.executeUpdate(sb.toString());
            System.out.println("Resultado : " + res);

            // Creamos la tabla user
            sb.setLength(0);
            sb.append("CREATE TABLE ").append(C.T_USUARIO).append(" (")
                    .append(C.IDUSUARIO).append(" INT(10) NOT NULL AUTO_INCREMENT,")
                    .append(C.PASSWORD).append(" VARCHAR(20),")
                    .append(C.NOMBRE).append(" VARCHAR(20),")
                    .append(C.APELLIDO).append(" VARCHAR(20),")
                    .append("PRIMARY KEY(id_usuario)")
                    .append(")");
            System.out.println("Query : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            System.out.println("Resultado : " + res);

            sb.setLength(0);

            // Insertamos dos registros en la tabla user
            sb.append("INSERT INTO ").append(C.T_USUARIO).append(" VALUES ")
                    .append("(1,'pass1','Juan Francisco','Ruiz'),")
                    .append("(2,'pass2','Roberto','Mena')");

            System.out.println("Query : " + sb.toString());
            res = stmt.executeUpdate(sb.toString());
            System.out.println("Resultado : " + res);

            // Consulta de la inserción realizada
            sb.setLength(0);
            sb.append("SELECT ")
                    .append(C.IDUSUARIO).append(",")
                    .append(C.PASSWORD).append(",")
                    .append(C.NOMBRE).append(",")
                    .append(C.APELLIDO)
                    .append(" FROM ").append(C.T_USUARIO);
            System.out.println("Query: " + sb.toString());
            ResultSet rs = stmt.executeQuery(sb.toString());
            StringBuilder sbr = new StringBuilder();
            
            while (rs.next()) {
                sbr.setLength(0);
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
        System.out.println("Creando la tabla de anuncios en la BD...");
        Connection con;
        String createString;

        createString = "CREATE TABLE "
                + C.T_ANUNCIO
                + " ("
                + C.IDANUNCIO
                + " int(10) NOT NULL AUTO_INCREMENT, "
                + C.TEMA
                + " VARCHAR(50) NOT NULL, "
                + C.MENSAJE
                + " VARCHAR(250) NOT NULL ,"
                + C.IDUSUARIO
                + " int(10) NOT NULL, " + // clave foreign
                "PRIMARY KEY("
                + C.IDANUNCIO
                + ")" + ")";

        Statement stmt;

        try {
            Class.forName(C.DRIVER);
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            con = DriverManager.getConnection(C.URL, C.USUARIO, C.PASS);
            stmt = con.createStatement();

            // Primero borro la tabla si existe
            try {
                System.out.println("Borro la tabla 'anuncio' si existe");
                stmt.executeUpdate("DROP TABLE IF EXISTS "
                        + C.T_ANUNCIO);
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
