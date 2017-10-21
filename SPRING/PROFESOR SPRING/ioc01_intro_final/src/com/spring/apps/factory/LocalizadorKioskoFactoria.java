package com.spring.apps.factory;

import com.spring.ioc.BuscadorKiosko;

public class LocalizadorKioskoFactoria
{
    public static BuscadorKiosko createInstance( String key )
    {
        return new BuscadorKiosko( key );
    }
}
