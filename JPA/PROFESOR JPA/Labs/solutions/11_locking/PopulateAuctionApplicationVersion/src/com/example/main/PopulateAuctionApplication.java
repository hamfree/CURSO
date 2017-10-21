package com.example.main;

import com.example.model.Auction;
import com.example.model.AuctionUser;
import com.example.model.Bid;
import com.example.model.Image;
import com.example.model.Item;
import com.example.stub.StubbedAuctionUsers;
import com.example.stub.StubbedAuctions;
import com.example.stub.StubbedBids;
import com.example.stub.StubbedImages;
import com.example.stub.StubbedItems;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PopulateAuctionApplication
{
    private final EntityManagerFactory emf;
    private final ConcurrentHashMap<Integer, Image> images = StubbedImages.getImages();
    private final ConcurrentHashMap<Integer, Item> items = StubbedItems.getItems();
    private final ConcurrentHashMap<String, AuctionUser> users = StubbedAuctionUsers.getAuctionUsers();
    private final ConcurrentHashMap<Integer, Auction> auctions = StubbedAuctions.getAuctions();
    private final ConcurrentHashMap<Integer, Bid> bids = StubbedBids.getBids();

    public PopulateAuctionApplication()
    {
        emf = Persistence.createEntityManagerFactory( "AuctionPU" );
    }

    public static void main( String[] args )
    {
        System.out.println( "Starting populating..." );
        PopulateAuctionApplication p = new PopulateAuctionApplication();
        p.populateImages();
        p.populateItems();
        p.populateAuctionUsers();
        p.populateAuctions();
        p.populateBids();
        System.out.println( "Complete!" );
    }

    public void populateImages()
    {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Enumeration<Image> list = images.elements();
            while( list.hasMoreElements() ) {
                em.persist( list.nextElement() );
            }
            em.getTransaction().commit();
        }
        catch( Exception e ) {
            System.out.println( "populateImages: " + e );
        }
        finally {
            if ( em != null ) {
                em.close();
            }
        }
    }

    public void populateItems()
    {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Enumeration<Item> list = items.elements();
            while( list.hasMoreElements() ) {
                em.persist( list.nextElement() );
            }
            em.getTransaction().commit();
        }
        catch( Exception e ) {
            System.out.println( "populateItems: " + e );
        }
        finally {
            if ( em != null ) {
                em.close();
            }
        }
    }

    public void populateAuctionUsers()
    {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Enumeration<AuctionUser> list = users.elements();
            while( list.hasMoreElements() ) {
                em.persist( list.nextElement() );
            }
            em.getTransaction().commit();
        }
        catch( Exception e ) {
            System.out.println( "populateAuctionUsers: " + e );
        }
        finally {
            if ( em != null ) {
                em.close();
            }
        }
    }

    public void populateAuctions()
    {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Enumeration<Auction> list = auctions.elements();
            while( list.hasMoreElements() ) {
                em.persist( list.nextElement() );
            }
            em.getTransaction().commit();
        }
        catch( Exception e ) {
            System.out.println( "populateAuctions: " + e );
        }
        finally {
            if ( em != null ) {
                em.close();
            }
        }
    }

    public void populateBids()
    {
        EntityManager em = null;
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            Enumeration<Bid> list = bids.elements();
            while( list.hasMoreElements() ) {
                em.persist( list.nextElement() );
            }
            em.getTransaction().commit();
        }
        catch( Exception e ) {
            System.out.println( "populateBids: " + e );
        }
        finally {
            if ( em != null ) {
                em.close();
            }
        }
    }
}
