package com.spring.edadmedia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionEdadMedia
{
    @Bean
    public Juglar juglar()
    {
        return new Juglar();
    }

    @Bean
    public Gesta gesta()
    {
        return new RescatarDamaGesta();
    }

    @Bean
    public Caballero caballero()
    {
        return new CaballeroValiente( gesta(), juglar() );
    }
}
