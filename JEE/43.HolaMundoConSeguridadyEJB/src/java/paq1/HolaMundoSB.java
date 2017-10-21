/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.AccessLocalException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@DeclareRoles({"jefe","currito"})
@Stateless
public class HolaMundoSB implements HolaMundoSBLocal {
    @Resource SessionContext ctx;

    @RolesAllowed("jefe")
    @Override
    public String saludar(String usuario) throws AccessLocalException {
        String res = null;
        
        String nombre = ctx.getCallerPrincipal().getName();
        boolean isInRoleJefe = ctx.isCallerInRole("jefe");
        if (usuario != null) {
            res = "Hola, " + usuario + ". Su nombre es '" + nombre + "'. ¿Tiene el rol \"jefe\"? " + isInRoleJefe;
        }
        return res;
    }

    @RolesAllowed({"jefe","currito"})
    @Override
    public String dameDatosUsuario() {
        String datosUsuario;
        String nombre = ctx.getCallerPrincipal().getName();
        String rol;
        boolean isInRoleJefe = ctx.isCallerInRole("jefe");
        if (isInRoleJefe) {
            rol = "jefe";
        } else {
            rol = "currito";
        }
        datosUsuario = "nombre = '" + nombre + "',rol = '" + rol + "'.";
        return datosUsuario;
    }
}
