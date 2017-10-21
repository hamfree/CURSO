package com.acme.modelo;

import com.acme.utiles.C;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Clase que implementa el patrón DAO y que gestiona la persistencia de los
 * datos introducidos por los usuarios en la BBDD
 *
 * @author hamfree
 */
public class DAO {

    // Es un singleton
    static DAO g = new DAO();
    private Connection con = null;
    private Statement stmt = null;

    private DAO() {
    }

    public static DAO getInstance() {
        return getG();
    }

    public static DAO getG() {
        return g;
    }

    public Connection getCon() {
        return con;
    }

    public Statement getStmt() {
        return stmt;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }

    private static javax.sql.DataSource obtenerDS() {
        DataSource ds = null;
        try {
            Context ctx = new InitialContext();
            ds = (DataSource) ctx.lookup(C.JNDI);
        } catch (NamingException e) {
            System.out.println("Error al obtener la fuente de datos. Excepcion :" + e.getLocalizedMessage());
        }
        return ds;
    }

    public void conectar() throws SQLException {
        con = obtenerDS().getConnection();
        setStmt(getCon().createStatement());
    }

    public void cerrarConexion() throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public Usuario dameUsuario(String nombre, String password) {
        C.dbg(this.getClass(), ".dameUsuario(" + nombre + "," + password + ") - INICIO");
        Usuario u = null;
        StringBuilder sb = new StringBuilder();
        try {
            conectar();
            sb.setLength(0);
            sb.append("SELECT ").append(C.ID_USU).append(", ").append(C.PASS).append(", ").append(C.NOMB).append(", ").append(C.APEL)
                    .append(" FROM ")
                    .append(C.USER)
                    .append(" WHERE ")
                    .append(C.NOMB).append(" = '").append(nombre)
                    .append("' AND ")
                    .append(C.PASS).append(" = '").append(password).append("'");
            ResultSet rs = stmt.executeQuery(sb.toString());
            while (rs.next()) {
                u = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
            }
            cerrarConexion();

        } catch (SQLException e) {
            System.out.println("Error en DAO : " + e);

        } finally {
            try {
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error en DAO : " + ex);
            }
        }
        C.dbg(this.getClass(), ".dameUsuario() - FIN");
        return u;
    }

    public boolean insertarDVD(Dvd unDvd, int id_usuario) {
        C.dbg(this.getClass(), ".insertarDVD(" + unDvd + "," + id_usuario + ") - INICIO");
        boolean resultado = false;
        int registros = 0;
        int id_peli = -1;

        StringBuilder sb = new StringBuilder();
        try {
            conectar();
            sb.append("SELECT ").append(C.ID_PEL)
                    .append(" FROM ")
                    .append(C.DVDS)
                    .append(" WHERE ")
                    .append(C.TITU).append(" = '").append(unDvd.getTitulo()).append("'");
            String query1 = sb.toString();
            ResultSet rs = stmt.executeQuery(query1);

            if (rs.next()) {
                id_peli = rs.getInt(1);
                C.dbg(this.getClass(), "\tla película ya existe en la base de datos con el id '" + id_peli + ". La asociaremos además con el usuario " + id_usuario);
                // Sólo nos queda asociarla al usuario ....
                if (id_peli > 0) {
                    sb.setLength(0);
                    sb.append("INSERT INTO ").append(C.USERSDVDS).append(" (").append(C.ID_USU).append(",").append(C.ID_PEL).append(")")
                            .append(" VALUES (")
                            .append(id_usuario).append(",").append(id_peli).append(")");
                    String query4 = sb.toString();
                    registros = stmt.executeUpdate(query4);
                    if (registros == 1) {
                        C.dbg(this.getClass(), "\tse insertó un registro con la asociación " + id_usuario + "," + id_peli + " en la tabla");
                        resultado = true;
                    } else {
                        resultado = false;
                        C.dbg(this.getClass(), "\thay algún problema para insertar la asociación id_usuario/id_peli en la Base de Datos");
                    }
                }
            } else {
                sb.setLength(0);
                sb.append("INSERT INTO ").append(C.DVDS)
                        .append(" (").append(C.TITU).append(",").append(C.DTOR)
                        .append(") VALUES ('")
                        .append(unDvd.getTitulo()).append("','").append(unDvd.getDirector())
                        .append("')");
                String query2 = sb.toString();
                id_peli = -2;
                registros = stmt.executeUpdate(query2);
                if (registros == 1) {
                    sb.setLength(0);
                    sb.append("SELECT ").append(C.ID_PEL).append(",").append(C.TITU).append(",").append(C.DTOR)
                            .append(" FROM ")
                            .append(C.DVDS)
                            .append(" WHERE ")
                            .append(C.TITU).append(" = '").append(unDvd.getTitulo())
                            .append("' AND ")
                            .append(C.DTOR).append(" = '").append(unDvd.getDirector()).append("'");
                    String query3 = sb.toString();
                    ResultSet rs2 = stmt.executeQuery(query3);
                    if (rs2.next()) {
                        id_peli = rs2.getInt("id_pelicula");
                    } else {
                        C.dbg(this.getClass(), "\thay algún problema para insertar el DVD en la Base de Datos");
                        resultado = false;
                    }
                }
                if (id_peli > 0) {
                    sb.setLength(0);
                    sb.append("INSERT INTO ").append(C.USERSDVDS).append(" (").append(C.ID_USU).append(",").append(C.ID_PEL).append(")")
                            .append(" VALUES (")
                            .append(id_usuario).append(",").append(id_peli).append(")");
                    String query4 = sb.toString();
                    registros = stmt.executeUpdate(query4);
                    if (registros == 1) {
                        C.dbg(this.getClass(), "\tse insertó un registro con la asociación " + id_usuario + "," + id_peli + " en la tabla");
                        resultado = true;
                    } else {
                        resultado = false;
                        C.dbg(this.getClass(), "\thay algún problema para insertar la asociación id_usuario/id_peli en la Base de Datos");
                    }
                } else {
                    C.dbg(this.getClass(), "\tno ties ni pi....idea");
                    resultado = false;
                }
            }
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error en DAO : " + e);

        } finally {
            try {
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error en DAO : " + ex);
            }
        }
        C.dbg(this.getClass(), ".insertarDVD() - FIN");
        return resultado;
    }

    public boolean borrarDVD(Dvd unDvd, int id_usuario) {
        C.dbg(this.getClass(), ".borrarDVD(" + unDvd + "," + id_usuario + ") - INICIO ");
        boolean resultado = false;
        int registros = 0;
        StringBuilder sb = new StringBuilder();
        try {
            Dvd d = consultar(unDvd);
            if (d != null) {
                if (d.getId_dvd() > 0) {
                    conectar();
                    sb.setLength(0);
                    sb.append("DELETE FROM ").append(C.USERSDVDS)
                            .append(" WHERE ").append(C.ID_USU).append(" = ").append(id_usuario)
                            .append(" AND ")
                            .append(C.ID_PEL).append(" = ").append(d.getId_dvd());
                    String query4 = sb.toString();
                    registros = stmt.executeUpdate(query4);
                    cerrarConexion();
                    if (registros != 0) {
                        resultado = true;
                    } else {
                        C.dbg(this.getClass(), "\thubo algún problema al borrar el registro en la Base de datos (" + id_usuario + "," + d.getId_dvd() + ")");
                        resultado = false;
                    }

                } else {
                    C.dbg(this.getClass(), "\tno existe el DVD " + unDvd.toString() + " en la Base de Datos");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error en DAO : " + e);
        } finally {
            try {
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error en DAO : " + ex);
            }
        }
        C.dbg(this.getClass(), ".borrarDVD() - FIN");
        return resultado;
    }

    public List<Dvd> listarDVD(int id_usuario) {
        C.dbg(this.getClass(), ".listarDVD(" + id_usuario + ") - INICIO");
        List<Integer> idsPeliculas = null;
        List<Dvd> listaDvds = null;
        Dvd d = null;
        int registros = 0;

        StringBuilder sb = new StringBuilder();
        try {
            conectar();
            sb.append("SELECT ").append(C.ID_PEL)
                    .append(" FROM ").append(C.USERSDVDS)
                    .append(" WHERE ")
                    .append(C.ID_USU).append(" = ").append(id_usuario);
            ResultSet rs = stmt.executeQuery(sb.toString());
            idsPeliculas = new ArrayList<>();
            while (rs.next()) {
                Integer i = rs.getInt(1);
                idsPeliculas.add(i);
            }

            listaDvds = new ArrayList<>();

            for (Integer i : idsPeliculas) {
                sb.setLength(0);
                sb.append("SELECT ").append(C.ID_PEL).append(",").append(C.TITU).append(",").append(C.DTOR)
                        .append(" FROM ").append(C.DVDS)
                        .append(" WHERE ")
                        .append(C.ID_PEL).append(" = ").append(i.intValue());
                rs = stmt.executeQuery(sb.toString());
                if (rs.next()) {
                    d = new Dvd(rs.getInt(1), rs.getString(2), rs.getString(3));
                    listaDvds.add(d);
                }
            }
            cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error en DAO : " + e);

        } finally {
            try {
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error en DAO : " + ex);
            }
        }
        C.dbg(this.getClass(), ".listarDVD() - FIN");
        return listaDvds;
    }

    public Dvd consultar(Dvd dvd) {
        C.dbg(this.getClass(), ".consultar(" + dvd + ") - INICIO");
        Dvd d = null;
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);

        sb.append("SELECT * FROM ").append(C.DVDS).append(" WHERE ");
        if (dvd.getId_dvd() > 0) {
            sb.append(C.ID_PEL).append(" = ").append(dvd.getId_dvd()).append(" ");
        } else {
            try {
                if (dvd.getTitulo() != null && dvd.getTitulo().length() > 0) {
                    sb.append(C.TITU).append(" = '").append(dvd.getTitulo()).append("' ");
                } else {
                    sb.append(C.DTOR).append(" = '").append(dvd.getDirector()).append("' ");
                }
                conectar();
                String query3 = sb.toString();
                ResultSet rs = stmt.executeQuery(query3);
                if (rs.next()) {
                    d = new Dvd(rs.getInt(1), rs.getString(2), rs.getString(3));
                }
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error :" + ex);
            } finally {
                try {
                    cerrarConexion();
                } catch (SQLException ex) {
                    System.out.println("Error en DAO : " + ex);
                }
            }
        }
        C.dbg(this.getClass(), ".consultar() - FIN");
        return d;
    }

    public Dvd consultarDvdDeUsuario(Dvd dvd, int id_usuario) {
        C.dbg(this.getClass(), ".consultarDvdDeUsuario(" + dvd + "," + id_usuario + ") - INICIO");
        Dvd d = null;
        StringBuilder sb = new StringBuilder();
        sb.setLength(0);

        sb.append("SELECT * FROM ").append(C.DVDS).append(" WHERE ");
        if (dvd.getId_dvd() > 0) {
            sb.append(C.ID_PEL).append(" = ").append(dvd.getId_dvd()).append(" ");
        } else {
            try {
                if (dvd.getTitulo() != null && dvd.getTitulo().length() > 0) {
                    sb.append(C.TITU).append(" = '").append(dvd.getTitulo()).append("' ");
                } else {
                    sb.append(C.DTOR).append(" = '").append(dvd.getDirector()).append("' ");
                }
                conectar();
                String query3 = sb.toString();
                ResultSet rs = stmt.executeQuery(query3);
                if (rs.next()) {
                    d = new Dvd(rs.getInt(1), rs.getString(2), rs.getString(3));
                    // Ahora debemos encontrar el id de este dvd asociado al id de
                    // usuario que nos han pasado...
                    sb.setLength(0);
                    sb.append("SELECT ").append(C.ID_USU).append(",").append(C.ID_PEL)
                            .append(" FROM ").append(C.USERSDVDS)
                            .append(" WHERE ")
                            .append(C.ID_USU).append(" = ").append(id_usuario)
                            .append(" AND ")
                            .append(C.ID_PEL).append(" = ").append(d.getId_dvd());
                    String query4 = sb.toString();
                    ResultSet rs2 = stmt.executeQuery(query4);
                    if (!rs2.next()) {
                        // No se ha encontrado el DVD en la colección del usuario...
                        C.dbg(this.getClass(), "\tNo se encontró el DVD " + dvd + "en la coleccion del usuario con id " + id_usuario);
                        d = null;
                    } else {
                        C.dbg(this.getClass(), "\tDVD " + dvd + " encontrado en la coleccion del usuario con id " + id_usuario);
                    }
                }
                cerrarConexion();
            } catch (SQLException ex) {
                System.out.println("Error :" + ex);
            } finally {
                try {
                    cerrarConexion();
                } catch (SQLException ex) {
                    System.out.println("Error en DAO : " + ex);
                }
            }
        }
        C.dbg(this.getClass(), ".consultarDvdDeUsuario() - FIN");
        return d;
    }

    public boolean modificarDVD(Dvd unDvd, int id_usuario) {
        boolean resultado = false;
        C.dbg(this.getClass(), ".modificarDVD(" + unDvd + "," + id_usuario + ") - INICIO");

        if (consultarDvdDeUsuario(unDvd, id_usuario) != null){
            
        }
        
        C.dbg(this.getClass(), ".modificarDVD() - FIN");
        return resultado;
    }
}
