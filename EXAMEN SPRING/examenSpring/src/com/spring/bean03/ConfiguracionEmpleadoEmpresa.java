package com.spring.bean03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionEmpleadoEmpresa
{
    @Bean
    public Empleado emp01Java()
    {
        return new Empleado( "Adriana" );
    }

    @Bean
    public Direccion dir01Java()
    {
        return new Direccion( "Vallehermoso 52", "Madrid" );
    }

    @Bean
    Empleado emp02Java()
    {
        Empleado empleado = new Empleado( "Max" );
        empleado.setDireccion( dir01Java() );

        return empleado;
    }
}
