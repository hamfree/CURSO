package com.spring.apps.factory;

import com.spring.ioc.Buscador;
import com.spring.ioc.BuscadorWeb;

public class LocalizadorMedioDigitalFactoria
{
    public static Buscador createInstance()
    {
        return new BuscadorWeb();
    }
}
