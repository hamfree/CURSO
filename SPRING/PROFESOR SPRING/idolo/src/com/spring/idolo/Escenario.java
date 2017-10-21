package com.spring.idolo;

public class Escenario
{
    private Escenario()
    {
    }

    private static class StageSingletonHolder
    {
        static Escenario instance = new Escenario();
    }

    public static Escenario getInstance()
    {
        return StageSingletonHolder.instance;
    }

    @Override
    public String toString()
    {
        return "Escenario para representar";
    }
}
