package com.spring.bean00_02;

public class HolaMundo
{
    private String message = null;

    public HolaMundo()
    {
    }

    public HolaMundo( String message )
    {
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
