package com.example.util;

public enum ItemCondition
{

    NEW( "New" ), USED( "Used" ), PARTS( "Parts" );

    private final String label;

    private ItemCondition( String label )
    {
        this.label = label;
    }

    public String getLabel()
    {
        return this.label;
    }
}
