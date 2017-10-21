package com.example.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Table(name = "BID")
@Entity
public class Bid implements Serializable
{
    private static final long serialVersionUID = 5653646601840527858L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int bidId;
    @ManyToOne
    @JoinColumn(name = "BIDDERID")
    private AuctionUser bidder;
    @ManyToOne
    @JoinColumn(name = "AUCTIONID")
    private Auction auction;
    private float amount;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
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
}
