package dao;

import entidad.Empresa;
import java.util.List;

public interface EmpresaDao
{
    Empresa leeEmpresa( long id );

    public Empresa creaEmpresa( Empresa emp );

    List<Empresa> getTodasLasEmpresas();
}
