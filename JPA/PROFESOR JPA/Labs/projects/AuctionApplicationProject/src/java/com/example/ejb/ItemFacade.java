package com.example.ejb;

import com.example.model.Item;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ItemFacade {

    private static final Logger LOG = Logger.getLogger(ItemFacade.class.getName());
    @PersistenceContext(unitName = "AuctionPU")
    private EntityManager em;

    public ItemFacade() {
    }

    public Item findByItemId(int itemId) {
        Item item = null;
        // Practice 6-1 code goes here
        try {
            item = em.find(Item.class, itemId);
        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }

        return item;
    }

    public void addItemTags(int itemId, String tags) {
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
