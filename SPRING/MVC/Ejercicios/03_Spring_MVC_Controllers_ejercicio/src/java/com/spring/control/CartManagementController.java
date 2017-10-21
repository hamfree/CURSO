package com.spring.control;

import com.spring.domain.Book;
import com.spring.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartManagementController
{
    @Autowired
    private BookService bookService;

    @RequestMapping( "/addToCart" )
    public ModelAndView addToCart( @RequestParam( "id" ) int id )
    {
        Book requiredBook = bookService.getBookById( id );

        // BUT HOW DO WE ADD IT TO THE USER'S SESSION?
        return new ModelAndView( "/bookAddedToCart.jsp", "title", requiredBook.getTitle() );
    }

}
