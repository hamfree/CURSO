package com.spring.ioc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuscadorKiosko
    implements Buscador
{
    private static final List<Local> LUGARES = new ArrayList<>();

    public BuscadorKiosko( String key )
    {
    }

    static {
        LUGARES.add( new Local( "Kiosk A", Arrays.asList( "Forest Gump", "Speed" ) ) );
        LUGARES.add( new Local( "Kiosk B", Arrays.asList( "Jaws", "Ghost" ) ) );
        LUGARES.add( new Local( "Kiosk C", Arrays.asList( "Forest Gump", "Hook" ) ) );
    }

    @Override
    public List<Local> find( String zipcode, int radius )
    {
        return LUGARES;
    }
}
