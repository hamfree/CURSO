package com.spring.idolo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfiguracionIdolo
{
    @Bean
    public Actuante duke()
    {
        return new Malabarista2( 12 );
    }

    @Bean
    @Scope( "prototype" )
    public ControladorTiempo controlador()
    {
        return new ControladorTiempo();
    }
}
