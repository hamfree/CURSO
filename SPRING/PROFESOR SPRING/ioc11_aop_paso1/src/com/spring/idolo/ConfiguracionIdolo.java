package com.spring.idolo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionIdolo
{
    @Bean
    public Actuante duke()
    {
        return new ActuanteProxy( dukeOriginal() );
    }

    @Bean
    public Actuante dukeOriginal()
    {
        return new Malabarista2( 12 );
    }
}
