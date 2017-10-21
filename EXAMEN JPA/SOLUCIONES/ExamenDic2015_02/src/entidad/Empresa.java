package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empresa
    implements Serializable
{

    private static final long serialVersionUID = -7199508618784577552L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private long id;

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

    @Override
    public String toString()
    {
        return "Empresa[" + "id=" + id + ", nombre=" + nombre + ']';
    }
}
