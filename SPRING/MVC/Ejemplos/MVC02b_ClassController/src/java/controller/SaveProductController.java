package controller;

import domain.Product;
import form.ProductForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveProductController
    implements Controller
{
    @Override
    public String handleRequest( HttpServletRequest request,
        HttpServletResponse response )
    {
        /*
         * ProductForm
         */
        ProductForm productForm = new ProductForm();

        productForm.setName( request.getParameter( "name" ) );
        productForm.setDescription( request.getParameter( "description" ) );
        productForm.setPrice( request.getParameter( "price" ) );

        /*
         * Product
         */
        Product product = new Product();

        product.setName( productForm.getName() );
        product.setDescription( productForm.getDescription() );
        try {
            product.setPrice( Float.parseFloat(
                productForm.getPrice() ) );
        }
        catch( NumberFormatException e ) {
        }

        /*
         * Añadir el producto a la base de datos
         */
        //
        /*
         * Datos para la vista
         */
        request.setAttribute( "product", product );

        return "/WEB-INF/jsp/ProductDetails.jsp";
    }
}
