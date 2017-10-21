package entidad;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlazaGaraje
    implements Serializable
{
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private long id;

    private String ubicacion;

    public PlazaGaraje()
    {
    }

    public PlazaGaraje( String ubicacion )
    {
        this.ubicacion = ubicacion;
    }

    public long getId()
    {
        return id;
    }

    public String getUbicacion()
    {
        return ubicacion;
    }

    public void setUbicacion( String ubicacion )
    {
        this.ubicacion = ubicacion;
    }
}
