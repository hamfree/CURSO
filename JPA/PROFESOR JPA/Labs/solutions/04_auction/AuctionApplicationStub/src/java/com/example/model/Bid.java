package com.example.model;

import java.util.Date;

public class Bid
{

    private int bidId;
    private AuctionUser bidder;
    private Auction auction;
    private float amount;
    private Date bidTime; // Stored as TIMESTAMP

    public Bid()
    {
    }

    public Bid( int bidId, AuctionUser bidderId, Auction auction, float amount,
        Date bidTime )
    {
        this.bidId = bidId;
        this.bidder = bidderId;
        this.auction = auction;
        this.amount = amount;
        this.bidTime = bidTime;
    }

    public int getBidId()
    {
        return bidId;
    }

    public void setBidId( int bidId )
    {
        this.bidId = bidId;
    }

    public AuctionUser getBidder()
    {
        return bidder;
    }

    public void setBidder( AuctionUser bidderId )
    {
        this.bidder = bidderId;
    }

    public Auction getAuction()
    {
        return auction;
    }

    public void setAuction( Auction auction )
    {
        this.auction = auction;
    }

    public float getAmount()
    {
        return amount;
    }

    public void setAmount( float amount )
    {
        this.amount = amount;
    }

    public Date getBidTime()
    {
        return bidTime;
    }

    public void setBidTime( Date bidTime )
    {
        this.bidTime = bidTime;
    }

    @Override
    public String toString()
    {
        return "Bid{" + "bidId=" + bidId + ", bidderId=" + bidder + ", auction=" + auction + ", amount=" + amount + ", bidTime=" + bidTime + '}';
    }
}
