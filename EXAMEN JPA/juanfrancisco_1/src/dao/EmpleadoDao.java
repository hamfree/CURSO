package dao;

import entidad.Empleado;
import java.util.List;

public interface EmpleadoDao {

    Empleado leeEmpleado(long id);

    public void borraEmpleado(long id);

    public Empleado creaEmpleado(Empleado emp);

    List<Empleado> leeTodosLosEmpleados();
}
