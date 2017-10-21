package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado
    implements Serializable
{

    private static final long serialVersionUID = 8562596322208132130L;
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private long id;

    private String nombre;
    private int edad;

    public Empleado()
    {
    }

    public Empleado( String nombre, int edad )
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad( int edad )
    {
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return "Empleado[" + "id=" + id + ", nombre=" + nombre + ", edad=" + edad + ']';
    }

}
