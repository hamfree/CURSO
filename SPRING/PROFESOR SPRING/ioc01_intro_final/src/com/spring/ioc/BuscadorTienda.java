package com.spring.ioc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuscadorTienda
    implements Buscador
{
    private static final List<Local> LUGARES = new ArrayList<>();

    static {
        LUGARES.add( new Local( "Blockbuster", Arrays.asList( "Forest Gump", "Speed" ) ) );
        LUGARES.add( new Local( "Gary's Video", Arrays.asList( "Jaws", "Ghost" ) ) );
        LUGARES.add( new Local( "West Coast Video", Arrays.asList( "Forest Gump", "Hook" ) ) );
    }

    @Override
    public List<Local> find( String codigoPostal, int radio )
    {
        return LUGARES;
    }
}
