/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author curso
 */
public class GestorEmpleados {

    public Empleado dameEmpleado(String nombre) {
        Empleado e1 = new Empleado();
        e1.setNombre(nombre);
        Telefono[] tefs = new Telefono[2];
        tefs[0] = new Telefono("fijo", "222222");
        tefs[1] = new Telefono("movil", "333333");
        e1.setTelefonos(tefs);
        return e1;
    }
}
