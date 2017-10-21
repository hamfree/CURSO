package com.spring.bean;

import com.spring.idolo.Poema;


public class Pareado implements Poema {
    private String pareado;

    public Pareado(String pareado) {
        this.pareado = pareado;
    }

    public String getPareado() {
        return pareado;
    }

    public void setPareado(String pareado) {
        this.pareado = pareado;
    }
            
    
    @Override
    public void recitar() {
        System.out.println(pareado);
    }
    
}
