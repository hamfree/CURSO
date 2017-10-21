package com.example.ejb;

import com.example.model.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ImageFacade
{
    
    private static final Logger LOG = Logger.getLogger( ImageFacade.class.getName() );
    @PersistenceContext(unitName = "AuctionPU")
    private EntityManager em;

    public ImageFacade()
    {
    }

    public Image findImageById( int imageId )
    {
        Image image = null;
        // Practice 6-1 code goes here
        try {
            image = em.find(Image.class, imageId);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
        return image;
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
