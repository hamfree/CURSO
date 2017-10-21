package modelo;

import java.io.Serializable;

public class Empleado implements Serializable{
 
  private String nombre;
  private Telefono [] telefonos;
  
  public Empleado() {
  }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the telefonos
     */
    public Telefono[] getTelefonos() {
        return telefonos;
    }

    /**
     * @param telefonos the telefonos to set
     */
    public void setTelefonos(Telefono[] telefonos) {
        this.telefonos = telefonos;
    }
  



}


