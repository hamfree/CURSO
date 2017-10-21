package controller;

import domain.Product;
import form.ProductForm;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import validator.ProductValidator;

public class SaveProductController
    implements Controller
{
    private static final Log logger = LogFactory
        .getLog( SaveProductController.class );

    @Override
    public ModelAndView handleRequest( HttpServletRequest request,
        HttpServletResponse response ) throws Exception
    {
        logger.info( "se invoca a SaveProductController" );

        ProductForm productForm = new ProductForm();

        productForm.setName( request.getParameter( "name" ) );
        productForm.setDescription( request.getParameter( "description" ) );
        productForm.setPrice( request.getParameter( "price" ) );

        ProductValidator productValidator = new ProductValidator();
        List<String> errors
            = productValidator.validate( productForm );

        if ( errors.isEmpty() ) {
            Product product = new Product();
            product.setName( productForm.getName() );
            product.setDescription( productForm.getDescription() );
            product.setPrice( Float.parseFloat( productForm.getPrice() ) );

            return new ModelAndView( "ProductDetails", "product",
                product );
        }
        else {
            Map<String, Object> model = new HashMap<>();
            model.put( "errors", errors );
            model.put( "form", productForm );
            return new ModelAndView( "ProductForm", model );
        }
    }
}
