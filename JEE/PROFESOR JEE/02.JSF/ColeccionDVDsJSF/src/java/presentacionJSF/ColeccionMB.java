/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacionJSF;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.ColeccionDVDs;
import modelo.DVD;

@ManagedBean(name = "coleccionMB")
@SessionScoped
public class ColeccionMB {

    ColeccionDVDs col;

    public ColeccionMB() {
        System.out.println("--> contructor ColeccionMB");
        col = new ColeccionDVDs();
    }

    public String irAAgregar() {
        return "nuevoDVD";
    }

    public String listar() {
        return "coleccion";
    }

    public String agregarDVD(DVDMB dvdmb) {
        DVD dvd = new DVD(dvdmb.getTitulo(), dvdmb.getDirector());
        col.agregarDVD(dvd);
        return "coleccion";
    }

    public List<DVD> getLista() {
        return col.getLista();
    }
}
