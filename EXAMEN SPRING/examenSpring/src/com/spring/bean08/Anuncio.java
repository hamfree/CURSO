package com.spring.bean08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Anuncio
{
    ProductorMensaje productor;

    @Autowired
    public void setProductor( ProductorMensaje productor )
    {
        this.productor = productor;
    }

    public String getMensaje()
    {
        return productor.getMensaje();
    }
}
