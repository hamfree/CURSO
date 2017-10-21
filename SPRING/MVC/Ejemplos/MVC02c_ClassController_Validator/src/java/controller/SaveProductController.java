package controller;

import domain.Product;
import form.ProductForm;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import validator.ProductValidator;

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
         * Validar parámetros
         */
        ProductValidator productValidator = new ProductValidator();
        List<String> errors
            = productValidator.validate( productForm );

        if ( errors.isEmpty() ) {
            /*
             * Product
             */
            Product product = new Product();

            product.setName( productForm.getName() );
            product.setDescription( productForm.getDescription() );
            product.setPrice( Float.parseFloat( productForm.getPrice() ) );

            /*
             * Añadir el producto a la base de datos
             */
            //
            /*
             * Datos del producto para la vista
             */
            request.setAttribute( "product", product );

            return "/WEB-INF/jsp/ProductDetails.jsp";
        }
        else {
            /*
             * Datos del error para la vista
             */
            request.setAttribute( "errors", errors );
            request.setAttribute( "form", productForm );
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
    }
}
