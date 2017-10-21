package com.spring.control;

import com.spring.domain.Book;
import com.spring.services.BookService;
import java.util.List;
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
        List<Book> allBooks = bookService.getEntireCatalogue();
        return new ModelAndView( "/displayAllBooks.jsp", "allBooks", allBooks );
    }
}
