package com.spring.control;

import com.spring.services.BookService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ViewAllBooksController
    implements Controller
{
    private BookService bookService;

    public void setBookService( BookService bookService )
    {
        this.bookService = bookService;
    }

    @Override
    public ModelAndView handleRequest( HttpServletRequest req,
        HttpServletResponse resp ) throws Exception
    {
        return null;
    }
}
