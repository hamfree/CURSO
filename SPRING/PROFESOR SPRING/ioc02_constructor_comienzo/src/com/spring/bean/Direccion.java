
package com.spring.bean;

public class Direccion {
    private String calle;

    public Direccion(String calle) {
        this.calle = calle;
    }

   
    @Override
    public String toString() {
        return "Direccion{" + "calle=" + calle + '}';
    }
    
    
}
