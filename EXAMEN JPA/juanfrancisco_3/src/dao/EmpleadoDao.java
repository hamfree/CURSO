package dao;

import exception.EmpleadoNoEncontradoException;
import entidad.Empleado;
import java.util.List;

public interface EmpleadoDao {

    Empleado leeEmpleado(long id) throws EmpleadoNoEncontradoException;

    public void borraEmpleado(long id)throws EmpleadoNoEncontradoException;

    public Empleado creaEmpleado(Empleado emp);

    List<Empleado> leeTodosLosEmpleados();
}
