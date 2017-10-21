package com.example.stub;

import com.example.model.Auction;
import com.example.model.AuctionUser;
import com.example.model.Item;
import com.example.util.AuctionStatus;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Create an in-memory set of Auction instances for use in the
 * AuctionApplication
 *
 * @author tmcginn
 */
public class StubbedAuctions
{
    private static final ConcurrentHashMap<Integer, Auction> auctions;
    private static Auction auction;
    private static ConcurrentHashMap<String, AuctionUser> users;
    private static AuctionUser seller;
    private static ConcurrentHashMap<Integer, Item> items;
    private static Item item;
    private static int auctionID = 100;

    static {
        // Auction(int auctionID, int sellerID, int itemID, float currPrice, float increment, int status, Date endDate)
        auctions = new ConcurrentHashMap<>();
        items = StubbedItems.getItems();
        users = StubbedAuctionUsers.getAuctionUsers();

        // All Auctions have the same start and end date (roughly)
        GregorianCalendar future = new GregorianCalendar();
        future.add( Calendar.DAY_OF_MONTH, 7 );
        Date endDate = future.getTime();
        int status = AuctionStatus.ACTIVE.ordinal();

        item = items.get( 100 ); // Phone stand
        seller = users.get( "cchurch" );
        float startPrice = 10.49f;
        float increment = 1.00f;
        auction = new Auction( auctionID, seller, item, startPrice, increment, status, endDate );
        auctions.put( StubbedAuctions.getNextId(), auction );

        item = items.get( 101 ); // American Girl
        seller = users.get( "tmcginn" );
        startPrice = 0.99f;
        increment = 1.00f;
        auction = new Auction( auctionID, seller, item, startPrice, increment, status, endDate );
        auctions.put( StubbedAuctions.getNextId(), auction );

        item = items.get( 102 ); // Coffe grinder
        seller = users.get( "cchurch" );
        startPrice = 51.00f;
        increment = 10.00f;
        auction = new Auction( auctionID, seller, item, startPrice, increment, status, endDate );
        auctions.put( StubbedAuctions.getNextId(), auction );

        item = items.get( 103 ); // Salt and Pepper
        seller = users.get( "mheimer" );
        startPrice = 1.00f;
        increment = 1.00f;
        auction = new Auction( auctionID, seller, item, startPrice, increment, status, endDate );
        auctions.put( StubbedAuctions.getNextId(), auction );

        item = items.get( 104 ); // Lil'Kinz
        seller = users.get( "tmcginn" );
        startPrice = 9.99f;
        increment = 1.00f;
        auction = new Auction( auctionID, seller, item, startPrice, increment, status, endDate );
        auctions.put( StubbedAuctions.getNextId(), auction );

        item = items.get( 105 ); // North Face Backpack
        seller = users.get( "pfernandez" );
        startPrice = 9.99f;
        increment = 1.00f;
        auction = new Auction( auctionID, seller, item, startPrice, increment, status, endDate );
        auctions.put( StubbedAuctions.getNextId(), auction );

        item = items.get( 106 ); // Horse
        seller = users.get( "cchurch" );
        startPrice = 19.99f;
        increment = 1.00f;
        auction = new Auction( auctionID, seller, item, startPrice, increment, status, endDate );
        auctions.put( StubbedAuctions.getNextId(), auction );

        item = items.get( 107 ); // Hp Printer
        seller = users.get( "mheimer" );
        startPrice = 9.99f;
        increment = 1.00f;
        auction = new Auction( auctionID, seller, item, startPrice, increment, status, endDate );
        auctions.put( StubbedAuctions.getNextId(), auction );
    }

    /**
     * Returns the current in-memory ConcurrentHashMap of Auction instances.
     *
     * @return ConcurrentHashMap<String, AuctionUser> users
     */
    public static ConcurrentHashMap<Integer, Auction> getAuctions()
    {
        return auctions;
    }

    /**
     * Returns the next Id value
     *
     * @return int
     */
    private static int getNextId()
    {
        return auctionID++;
    }
}
