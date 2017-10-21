package com.spring.bean08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionAnuncio
{
    @Bean
    public ProductorMensaje lavadora()
    {
        return new Lavadora();
    }
}
