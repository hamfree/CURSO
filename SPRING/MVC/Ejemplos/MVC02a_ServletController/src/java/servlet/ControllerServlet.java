package servlet;

import domain.Product;
import form.ProductForm;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "ControllerServlet", urlPatterns = { "*.action" } )
public class ControllerServlet
    extends HttpServlet
{
    @Override
    public void doGet( HttpServletRequest request,
        HttpServletResponse response )
        throws IOException, ServletException
    {
        processRequest( request, response );
    }

    @Override
    public void doPost( HttpServletRequest request,
        HttpServletResponse response )
        throws IOException, ServletException
    {
        processRequest( request, response );
    }

    private void processRequest( HttpServletRequest request,
        HttpServletResponse response )
        throws IOException, ServletException
    {
        // Obtener el último campo de la petición.  Por ejemplo, product_input.action
        String action = getAction( request );

        String dispatchUrl = null;

        // ejecutar action
        switch( action ) {
            case "product_input.action":
                dispatchUrl = "/WEB-INF/jsp/ProductForm.jsp";
                break;
            case "product_save.action":
                /*
                 * Crear formulario
                 */
                ProductForm productForm = new ProductForm();
                // Rellenar las propiedades
                productForm.setName( request.getParameter( "name" ) );
                productForm.setDescription(
                    request.getParameter( "description" ) );
                productForm.setPrice( request.getParameter( "price" ) );

                /*
                 * Crear modelo
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
                 * Guardar el producto en la base de datos.
                 */
                // no está implementado
                /*
                 * Guardar producto en el request para la vista
                 */
                request.setAttribute( "product", product );

                dispatchUrl = "/WEB-INF/jsp/ProductDetails.jsp";
                break;
        }

        /*
         * Enviar a la vista
         */
        if ( dispatchUrl != null ) {
            RequestDispatcher rd
                = request.getRequestDispatcher( dispatchUrl );
            rd.forward( request, response );
        }
    }

    private String getAction( HttpServletRequest request )
    {
        String uri = request.getRequestURI();
        String[] path = uri.split( "/" );
        String action = path[path.length - 1];

        return action;
    }
}
