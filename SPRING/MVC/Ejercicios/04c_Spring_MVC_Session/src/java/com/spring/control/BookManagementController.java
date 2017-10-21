package com.spring.control;

import com.spring.domain.Book;
import com.spring.domain.ShoppingCart;
import com.spring.services.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookManagementController
{
    private ShoppingCart cart = new ShoppingCart();

    @Autowired
    private BookService bookService;

    @RequestMapping( "/viewAllBooks" )
    public ModelAndView viewAllBooks()
    {
        List<Book> allBooks = bookService.getEntireCatalogue();
        return new ModelAndView( "/displayAllBooks.jsp", "allBooks", allBooks );
    }

    @RequestMapping( "/findByAuthor" )
    public ModelAndView findByAuthor( @RequestParam( "AUTHOR" ) String author )
    {
        List<Book> books = bookService.getAllBooksByAuthor( author );
        return new ModelAndView( "/displayAllBooks.jsp", "allBooks", books );
    }

    //@RequestMapping( "/addToCart2" )
    public ModelAndView addToCart( @RequestParam( "id" ) int id )
    {
        Book requiredBook = bookService.getBookById( id );

        cart.addItem( requiredBook );
        return new ModelAndView( "/bookAddedToCart.jsp", "title", requiredBook.getTitle() );
    }
}
