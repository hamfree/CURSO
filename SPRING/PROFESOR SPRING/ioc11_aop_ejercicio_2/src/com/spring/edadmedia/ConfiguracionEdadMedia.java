package com.spring.edadmedia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ConfiguracionEdadMedia {

    @Bean
    public Juglar juglar(){
        return new Juglar();
    }
    
    
    @Bean
    @Scope("prototype")
    public Juglar controlador() {
        return (juglar());
    }

    @Bean
    public Gesta gesta() {
        return new RescatarDamaGesta();
    }

    @Bean
    public Caballero caballero() {
        return new CaballeroValiente(gesta());
    }
}
