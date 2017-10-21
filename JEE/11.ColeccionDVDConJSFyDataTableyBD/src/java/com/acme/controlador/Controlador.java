package com.acme.controlador;

import com.acme.modelo.ColeccionDVD;
import com.acme.modelo.DAO;
import com.acme.modelo.Dvd;
import com.acme.modelo.Usuario;
import com.acme.utiles.C;
import com.acme.vista.DvdBean;
import java.util.ArrayList;

/**
 * Clase que gestiona las operaciones de negocio. Es llamada por los distintos
 * beans de la vista para realizar la persistencia en la BBDD.
 *
 * @author hamfree
 */
public class Controlador {

    public Controlador() {
    }

    public Usuario dameUsuario(String nombre, String password) {
        C.dbg(this.getClass(), ".dameUsuario(" + nombre  + "," + password + ") - INICIO");
        DAO g = DAO.getInstance();
        C.dbg(this.getClass(), ".dameUsuario() - FIN");
        return (g.dameUsuario(nombre, password));
    }

    public boolean crearDvd(DvdBean unDvdBean, int id_usuario) {
        C.dbg(this.getClass(), ".crearDvd(" + unDvdBean  + "," + id_usuario + ") - INICIO");
        DAO g = DAO.getInstance();
        Dvd unDvd = new Dvd(unDvdBean.getTitulo(), unDvdBean.getDirector());
        C.dbg(this.getClass(), ".crearDvd() - FIN");
        return (g.insertarDVD(unDvd, id_usuario));
    }

    public boolean borrarDvd(DvdBean unDvdBean, int id_usuario) {
        C.dbg(this.getClass(), ".borrarDvd(" + unDvdBean  + "," + id_usuario + ") - INICIO");
        DAO g = DAO.getInstance();
        Dvd unDvd = new Dvd(unDvdBean.getTitulo(), unDvdBean.getDirector());
        C.dbg(this.getClass(), ".borrarDvd() - FIN");
        return (g.borrarDVD(unDvd, id_usuario));
    }

    public boolean modificarDVD(DvdBean unDvdBean, int id_usuario) {
        C.dbg(this.getClass(), ".modificarDVD(" + unDvdBean  + "," + id_usuario + ") - INICIO");
        DAO g = DAO.getInstance();
        Dvd unDvd = new Dvd(unDvdBean.getTitulo(), unDvdBean.getDirector());
        C.dbg(this.getClass(), ".modificarDVD() - FIN");
        return (g.modificarDVD(unDvd, id_usuario));
    }

    public ColeccionDVD listarDvds(int id_usuario) {
        C.dbg(this.getClass(), ".listarDvds(" + id_usuario + ") - INICIO");
        DAO g = DAO.getInstance();
        ArrayList<Dvd> alDvd = (ArrayList<Dvd>) g.listarDVD(id_usuario);
        ColeccionDVD colDvd = new ColeccionDVD(alDvd);
        C.dbg(this.getClass(), ".listarDvds() - FIN");
        return colDvd;
    }

    public DvdBean buscar(DvdBean dvd) {
        C.dbg(this.getClass(), ".buscar(" + dvd  + ") - INICIO");
        DvdBean dvdRes = null;
        DAO g = DAO.getInstance();
        Dvd unDvd = new Dvd(dvd.getTitulo(), dvd.getDirector());
        Dvd dvdEncontrado = g.consultar(unDvd);
        if (dvdEncontrado != null) {
            dvdRes = new DvdBean(dvdEncontrado.getTitulo(), dvdEncontrado.getDirector());
            dvdRes.setMensaje("");
        }
        C.dbg(this.getClass(), ".buscar() - FIN");
        return dvdRes;
    }
    
    public DvdBean buscarDvdDeUsuario(DvdBean dvd, int id_usuario) {
        C.dbg(this.getClass(), ".buscarDvdDeUsuario(" + dvd  + "," + id_usuario + ") - INICIO");
        DvdBean dvdRes = null;
        DAO g = DAO.getInstance();
        Dvd unDvd = new Dvd(dvd.getTitulo(), dvd.getDirector());
        Dvd dvdEncontrado = g.consultarDvdDeUsuario(unDvd,id_usuario);
        if (dvdEncontrado != null) {
            dvdRes = new DvdBean(dvdEncontrado.getTitulo(), dvdEncontrado.getDirector());
            dvdRes.setMensaje("");
        }
        C.dbg(this.getClass(), ".buscarDvdDeUsuario() - FIN");
        return dvdRes;
    }

}
