package entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa
    implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

    @OneToMany( mappedBy = "empresa", cascade = CascadeType.PERSIST )
    private List<Empleado> empleados = new ArrayList<>();

    private String nombre;

    public Empresa()
    {
    }

    public Empresa( String nombre )
    {
        this.nombre = nombre;
    }

    public long getId()
    {
        return id;
    }

    public void setId( long id )
    {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre( String nombre )
    {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados( List<Empleado> empleados )
    {
        this.empleados = empleados;
    }

    public void contratarEmpleado( Empleado empleado )
    {
        empleados.add( empleado );
    }

    @Override
    public String toString()
    {
        return "Empresa[" + "id=" + id + ", nombre=" + nombre + ']';
    }
}
