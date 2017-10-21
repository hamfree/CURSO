package com.spring.control;

import com.spring.domain.Book;
import com.spring.domain.ShoppingCart;
import com.spring.services.BookService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope( "session" )
public class CartManagementController
    implements Serializable
{
    @Autowired
    private BookService bookService;

    @Autowired
    private ShoppingCart cart;

    @RequestMapping( "/addToCart" )
    public ModelAndView addToCart( @RequestParam( "id" ) int id )
    {
        Book requiredBook = bookService.getBookById( id );

        cart.addItem( requiredBook );
        return new ModelAndView( "/bookAddedToCart.jsp", "title",
            requiredBook.getTitle() );
    }

    @RequestMapping( "/viewCart" )
    public ModelAndView viewCart()
    {
        List<Book> allBooks = cart.getAllItems();
        return new ModelAndView( "/cartContents.jsp", "cart", allBooks );
    }
}
