package controller;

import domain.Product;
import form.ProductForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController
{
    private static final Log logger = LogFactory.getLog( ProductController.class );

    @RequestMapping( "/product_input" )
    public String inputProduct()
    {
        logger.info( "inputProduct called" );
        return "ProductForm";
    }

    @RequestMapping( "/product_save" )
    public String saveProduct( ProductForm productForm, Model model )
    {
        logger.info( "saveProduct called" );

        Product product = new Product();

        // ProductForm lo rellena Spring automáticamente
        product.setName( productForm.getName() );
        product.setDescription( productForm.getDescription() );
        try {
            product.setPrice( Float.parseFloat(
                productForm.getPrice() ) );
        }
        catch( NumberFormatException e ) {
        }

        // Añadir producto
        model.addAttribute( "product", product );
        return "ProductDetails";
    }
}
