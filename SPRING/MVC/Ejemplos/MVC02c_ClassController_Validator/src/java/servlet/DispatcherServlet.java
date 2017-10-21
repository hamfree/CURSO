package servlet;

import controller.Controller;
import controller.InputProductController;
import controller.SaveProductController;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "DispatcherServlet", urlPatterns = { "*.action" } )
public class DispatcherServlet
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
        String action = getAction( request );

        Controller controller;
        switch( action ) {
            case "product_input.action":
                controller = new InputProductController();
                break;

            case "product_save.action":
                controller = new SaveProductController();
                break;
            default:
                return;
        }

        String dispatchUrl = controller.handleRequest( request, response );
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
