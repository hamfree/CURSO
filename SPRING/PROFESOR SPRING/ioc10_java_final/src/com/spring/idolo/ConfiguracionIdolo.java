package com.spring.idolo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionIdolo
{
    @Bean
    Instrumento pianoDeCola()
    {
        return new Piano();
    }

    @Bean
    Actuante duke()
    {
        return new Malabarista();
    }

    @Bean
    Actuante duke15()
    {
        return new Malabarista( 15 );
    }

    @Bean
    Instrumento armonica()
    {
        return new Armonica();
    }

    @Bean
    Actuante lucas()
    {
        Instrumentalista instrumentalista = new Instrumentalista();
        instrumentalista.setSong( "Hotel California" );
        instrumentalista.setInstrumento( pianoDeCola() );

        return instrumentalista;
    }
}
