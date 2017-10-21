package entidad;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Empleado implements Serializable {

    private static final long serialVersionUID = 556866945686166480L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String nombre;
    private int edad;
    @ManyToOne(targetEntity = Empresa.class,cascade = CascadeType.PERSIST)
    @JoinColumn(name="idEmpresa")
    private Empresa empresa;

    public Empleado() {
    }

    public Empleado(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Empleado(String nombre, int edad, Empresa empresa) {
        this.nombre = nombre;
        this.edad = edad;
        this.empresa = empresa;
    }
    
    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    

    @Override
    public String toString() {
        if (empresa != null){
            return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", empresa=" + empresa + '}';
        } else {
            return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + "'}'";
        }
        
    }

}
