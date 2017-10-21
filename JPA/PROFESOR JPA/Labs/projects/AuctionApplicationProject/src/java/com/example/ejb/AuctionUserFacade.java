package com.example.ejb;

import com.example.model.AuctionUser;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AuctionUserFacade {

    private static final Logger LOG = Logger.getLogger(AuctionUserFacade.class.getName());

    @PersistenceContext(unitName = "AuctionPU")
    private EntityManager em;

    public AuctionUserFacade() {
    }

    // Return true if this is a valid AuctionUser
    public AuctionUser isValidAuctionUser(String displayName, String password) {
        AuctionUser checkUser = null;
        // Practice 6-1 code goes here
        try {
            checkUser = em.find(AuctionUser.class, displayName);
            if (checkUser != null) {
                if (!checkUser.getPassword().equals(password)) {
                    checkUser = null;
                }
            }
        } catch (Exception e) {
             LOG.log(Level.SEVERE, e.getMessage());
        }

        return checkUser;
    }

    // Return true if the add was successful - note the user must be new
    public void addNewAuctionUser(AuctionUser user) throws EJBException {
        // Practice 6-1 code goes here
        if (em.find(AuctionUser.class,user.getDisplayName()) != null){
            throw new EJBException("El nombre de usuario " + user.getDisplayName() + " ya está utilizado.");
        }
        em.persist(user);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
