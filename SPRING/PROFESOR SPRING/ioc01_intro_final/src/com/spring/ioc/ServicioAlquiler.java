package com.spring.ioc;

import java.util.ArrayList;
import java.util.List;

public class ServicioAlquiler
{
    private final Buscador localizador;

    public ServicioAlquiler( Buscador localizador )
    {
        this.localizador = localizador;
    }

    public List<Local> find( String titulo, String codigoPostal,
        int kms )
    {
        List<Local> lugares = localizador.find( codigoPostal, kms );

        List<Local> resultado = new ArrayList<>();
        for ( Local l : lugares ) {
            if ( l.getTitulos().contains( titulo ) ) {
                resultado.add( l );
            }
        }

        return resultado;
    }
}
