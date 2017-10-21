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

    public Empleado dameEmpleado(String nombre){
                Empleado e1 = new Empleado();
        e1.setNombre("Jesús García Rodriguez");
        Telefono[] tfnos = new Telefono[2];
        
        tfnos[0] = new Telefono("Fijo", "00 34 91 123 45 67");
        tfnos[1] = new Telefono("Movil", "00 34 666 123 456");
        
        e1.setTelefonos(tfnos);
        
        return e1;
    }
}
