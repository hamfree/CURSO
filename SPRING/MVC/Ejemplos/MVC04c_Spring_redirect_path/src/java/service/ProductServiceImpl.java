package service;

import domain.Product;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl
    implements ProductService
{

    private final Map<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong generator = new AtomicLong();

    public ProductServiceImpl()
    {
        createSampleProduct();
    }

    private void createSampleProduct()
    {
        Product product = new Product();
        product.setName( "JX1 Power Drill" );
        product.setDescription( "Powerful hand drill, made to perfection" );
        product.setPrice( 129.99F );
        add( product );
    }

    @Override
    public Product add( Product product )
    {
        long newId = generator.incrementAndGet();
        product.setId( newId );
        products.put( newId, product );
        return product;
    }

    @Override
    public Product get( long id )
    {
        return products.get( id );
    }
}
