package controller;

import domain.Product;
import form.ProductForm;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ProductService;

@Controller
public class ProductController
{
    private static final Log logger = LogFactory.getLog( ProductController.class );

    @Autowired
    private ProductService productService;

    @RequestMapping( "/product_input" )
    public String inputProduct()
    {
        logger.info( "se llama a inputProduct" );
        return "ProductForm";
    }

    @RequestMapping( "/product_save" )
    public String saveProduct( ProductForm productForm, Model model )
    {
        logger.info( "se llama a saveProduct" );

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
        Product newProduct = productService.add( product );
        model.addAttribute( "product", newProduct );
        model.addAttribute( "message", "El producto se guardó correctamente" );
        return "ProductDetails";
    }
}
