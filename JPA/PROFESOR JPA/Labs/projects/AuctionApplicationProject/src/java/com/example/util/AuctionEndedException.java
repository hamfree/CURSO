package com.example.util;

public class AuctionEndedException
    extends Exception
{

    public AuctionEndedException()
    {
    }

    public AuctionEndedException( String message )
    {
        super( message );
    }

}
