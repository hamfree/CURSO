package com.spring.bean;

import com.spring.idolo.ActuacionException;
import com.spring.idolo.Actuante;

public class Coordinador
{
    Actuante actuante1;
    Actuante actuante2;

    public Actuante getActuante1()
    {
        return actuante1;
    }

    public void setActuante1( Actuante actuante1 )
    {
        this.actuante1 = actuante1;
    }

    public Actuante getActuante2()
    {
        return actuante2;
    }

    public void setActuante2( Actuante actuante2 )
    {
        this.actuante2 = actuante2;
    }

    public void coordinar() throws ActuacionException
    {
        actuante1.actuar();
        actuante2.actuar();
    }
}
