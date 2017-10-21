/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author curso
 */
@Stateless
@DeclareRoles(value = {"jefe","currito"})
public class FachadaBeanSecurity implements FachadaBeanSecurityLocal {
@Resource SessionContext ctx;

    @Override
    @RolesAllowed(value = {"jefe","currito"})
    public String dameInfo() {
        String pral = ctx.getCallerPrincipal().getName();
        if (ctx.isCallerInRole("jefe")){
            return pral + " tu eres jefe";
        }else {
             return pral + " tu eres currito";
        }
       
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
