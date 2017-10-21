package com.spring.bean00_02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionHolaMundo
{
    @Bean
    public HolaMundo hola02()
    {
        return new HolaMundo( "Abracadabra" );
    }
}
