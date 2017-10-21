package com.spring.idolo;

import com.spring.bean.Coordinador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionIdolo
{
    @Bean
    public Actuante duke()
    {
        return new Malabarista( 10 );
    }

    @Bean
    public Actuante musico()
    {
        Instrumentalista instrumentalista
            = new Instrumentalista();
        instrumentalista.setSong( "Diana" );
        instrumentalista.setInstrumento( piano() );

        return instrumentalista;
    }

    @Bean
    public Instrumento piano()
    {
        return new Piano();
    }

    @Bean
    Coordinador coordinador()
    {
        Coordinador coordinador = new Coordinador();
        coordinador.setActuante1( duke() );
        coordinador.setActuante2( musico() );

        return coordinador;
    }
}
