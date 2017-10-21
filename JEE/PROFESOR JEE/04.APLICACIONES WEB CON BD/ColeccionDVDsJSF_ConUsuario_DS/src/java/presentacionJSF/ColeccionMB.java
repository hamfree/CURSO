/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionJSF;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import modelo.DVD;
import modelo.GestorColeccion;

@ManagedBean(name = "coleccionMB")
@SessionScoped
public class ColeccionMB {

    List<DVD> lista;

    public ColeccionMB() {

    }

    public String irAAgregar() {
        return "nuevoDVD";
    }

    public String listar(UsuarioMBean u) {
        GestorColeccion g = GestorColeccion.dameInstancia();

        lista = g.getLista(u.getUsuario());
        return "coleccion";
    }

    public String agregarDVD(DVDMB dvdmb, UsuarioMBean u) {
        System.out.println("-->agregar "+dvdmb.getTitulo());
        DVD dvd = new DVD(dvdmb.getTitulo(), dvdmb.getDirector());
        GestorColeccion g = GestorColeccion.dameInstancia();
        g.agregarDVD(dvd, u.getUsuario());
        listar(u);
        return "coleccion";
    }

    public String borrarDVD(DVDMB dvdmb, UsuarioMBean u) {
        DVD dvd = new DVD(dvdmb.getTitulo(), dvdmb.getDirector());
        GestorColeccion g = GestorColeccion.dameInstancia();
        g.borrarDVD(dvd, u.getUsuario());
        listar(u);
        return "coleccion";
    }
    
    public String modificarDVD(DVDMB dvdmb, UsuarioMBean u) {
        DVD dvd = new DVD(dvdmb.getTitulo(), dvdmb.getDirector());
        GestorColeccion g = GestorColeccion.dameInstancia();
        g.modificarDVD(dvd);
        listar(u);
        return "coleccion";
    }

        public String buscarDVD(DVDMB dvdmb, UsuarioMBean u) {
       
        GestorColeccion g = GestorColeccion.dameInstancia();
        
        DVD d2 = g.buscarDVD(dvdmb.getTitulo());
        //dvdmb.setTitulo(d2.getTitulo());
        dvdmb.setDirector(d2.getDirector());
        
        return "nuevoDVD";
    }
        
    public List<DVD> getLista() {
        return lista;
    }

    public String salir() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();

        return "index";
    }
}
