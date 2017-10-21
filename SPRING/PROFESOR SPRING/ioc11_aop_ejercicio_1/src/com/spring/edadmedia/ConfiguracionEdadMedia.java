
package com.spring.edadmedia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionEdadMedia {
    @Bean
    public Gesta gesta(){
        return new RescatarDamaGesta();
    }
    
    public Caballero caballeroOriginal() {
        return new CaballeroValiente(gesta());
    }
    
    @Bean
    public Juglar juglar(){
        return new Juglar();
    }
    
    @Bean
    public Caballero caballero(){
        return new CaballeroProxy(juglar(),caballeroOriginal());
    }
}
