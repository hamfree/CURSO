package entidad;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa implements Serializable {

    private static final long serialVersionUID = 2879670859555896192L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long idEmpresa;
    private String nombre;
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Empleado> empleados = new ArrayList<>();

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Empresa() {
    }

    public Empresa(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return idEmpresa;
    }

    public void contratarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (int) (this.idEmpresa ^ (this.idEmpresa >>> 32));
        hash = 31 * hash + Objects.hashCode(this.nombre);
        hash = 31 * hash + Objects.hashCode(this.empleados);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        if (this.idEmpresa != other.idEmpresa) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.empleados, other.empleados)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + idEmpresa + ", nombre=" + nombre + "'}'";

    }

}
