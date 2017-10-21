package com.example.util;

/**
 *
 * @author tmcginn
 */
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
