package com.spring.ioc;

import java.util.List;

public interface Buscador
{
    public abstract List<Local> find( String zipcode, int radius );
}
