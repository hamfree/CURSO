package com.spring.ioc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuscadorWeb
    implements Buscador
{
    private static final List<Local> LUGARES = new ArrayList<>();

    static {
        LUGARES.add( new Local( "Servidor A", Arrays.asList( "Forest Gump", "Speed" ) ) );
        LUGARES.add( new Local( "Servidor B", Arrays.asList( "Jaws", "Ghost" ) ) );
        LUGARES.add( new Local( "Servidor C", Arrays.asList( "Forest Gump", "Hook" ) ) );
    }

    @Override
    public List<Local> find( String zipcode, int radius )
    {
        return LUGARES;
    }
}
