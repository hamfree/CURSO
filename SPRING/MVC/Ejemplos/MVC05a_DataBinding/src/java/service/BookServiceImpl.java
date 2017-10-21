package service;

import domain.Book;
import domain.Category;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl
    implements BookService
{
    /*
     * this implementation is not thread-safe
     */
    private final List<Category> categories;
    private final List<Book> books;

    public BookServiceImpl()
    {
        categories = new ArrayList<>();
        Category category1 = new Category( 1, "Informática" );
        Category category2 = new Category( 2, "Viajes" );
        Category category3 = new Category( 3, "Novela negra" );
        categories.add( category1 );
        categories.add( category2 );
        categories.add( category3 );

        books = new ArrayList<>();
        books.add( new Book( 1L, "9780980839623",
            "Spring básico",
            category1, "Juan Zancada" ) );
        books.add( new Book( 2L, "9780980839630",
            "La muerte acecha",
            category3, "Vega González" ) );
    }

    @Override
    public List<Category> getAllCategories()
    {
        return categories;
    }

    @Override
    public Category getCategory( int id )
    {
        for ( Category category : categories ) {
            if ( id == category.getId() ) {
                return category;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks()
    {
        return books;
    }

    @Override
    public Book save( Book book )
    {
        book.setId( getNextId() );
        books.add( book );
        return book;
    }

    @Override
    public Book get( long id )
    {
        for ( Book book : books ) {
            if ( id == book.getId() ) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book update( Book book )
    {
        int bookCount = books.size();
        for ( int i = 0; i < bookCount; i++ ) {
            Book savedBook = books.get( i );
            if ( savedBook.getId() == book.getId() ) {
                books.set( i, book );
                return book;
            }
        }
        return book;
    }

    @Override
    public long getNextId()
    {
        // needs to be locked
        long id = 0L;
        for ( Book book : books ) {
            long bookId = book.getId();
            if ( bookId > id ) {
                id = bookId;
            }
        }
        return id + 1;
    }
}
