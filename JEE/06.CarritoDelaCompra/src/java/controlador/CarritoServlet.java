package controlador;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Articulo;
import modelo.CestaCompra;
import modelo.Comprador;
import modelo.FachadaBeanLocal;

@WebServlet(name = "CarritoServlet", urlPatterns = {"/carrito"})
public class CarritoServlet extends HttpServlet {

    FachadaBeanLocal fachadaBean = lookupFachadaBeanLocal();

    private FachadaBeanLocal servicio;
    private static final long serialVersionUID = 5558656089098983572L;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        long codigo = 0;
        String nombre = null;
        double precio = 0.0f;
        String accion = request.getParameter("accion");
        servicio = (FachadaBeanLocal) session.getAttribute("servicio");

        // Obtenemos la referencia al EJB
        if (servicio == null) {
            servicio = lookupFachadaBeanLocal();
            session.setAttribute("servicio", servicio);
        } 

        // Comprobamos la accion y obramos en consecuencia...
        if (accion == null) { 
            // El usuario hace una compra...
            if ((request.getParameter("codigo") != null && request.getParameter("codigo").length() > 0)
                    && (request.getParameter("nombre") != null && request.getParameter("nombre").length() > 0)
                    && (request.getParameter("precio") != null && request.getParameter("precio").length() > 0)) {
                try {
                    codigo = Long.parseLong(request.getParameter("codigo"));
                } catch (NumberFormatException numberFormatException) {
                    String msg = "Error: El código no es un numero...";
                    request.setAttribute("mensaje", msg);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                nombre = request.getParameter("nombre");
                try {
                    precio = Double.parseDouble(request.getParameter("precio"));
                } catch (NumberFormatException numberFormatException) {
                    String msg = "Error: El precio no es un valor numérico monetario...";
                    request.setAttribute("mensaje", msg);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }

                Articulo a = new Articulo(codigo, nombre, precio);

                servicio.agregarArticulo(a);
                session.setAttribute("carrito", servicio.getCc());
                request.setAttribute("mensaje", "Articulo añadido al carrito");

            } else {
                request.setAttribute("mensaje", "Error al introducir datos");
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (accion.equalsIgnoreCase("confirmar")) { 
            // El usuario quiere mostrar la pantalla de confirmacion
            session.setAttribute("carrito", servicio.getCc());
            request.getRequestDispatcher("confirmar.jsp").forward(request, response);

        } else if (accion.equalsIgnoreCase("finalizar")) {
            // El usuario quiere finalizar, confirmando la compra...
            CestaCompra cesta = (CestaCompra) session.getAttribute("carrito");
            String nombreComprador = request.getParameter("nombre");
            String direccionComprador = request.getParameter("direccion");
            Comprador comprador = new Comprador(nombreComprador, direccionComprador);
            servicio.hacerCompra(cesta, comprador);
            request.setAttribute("comprador", comprador);
            request.getRequestDispatcher("gracias.jsp").forward(request, response);
        } else if (accion.equalsIgnoreCase("limpiar")){
            // el usuario se arrepiente de la cesta y la borra...
            servicio.limpiar();
            session.removeAttribute("carrito");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private FachadaBeanLocal lookupFachadaBeanLocal() {
        try {
            Context c = new InitialContext();
            return (FachadaBeanLocal) c.lookup("java:global/06.CarritoDelaCompra/FachadaBean!modelo.FachadaBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
