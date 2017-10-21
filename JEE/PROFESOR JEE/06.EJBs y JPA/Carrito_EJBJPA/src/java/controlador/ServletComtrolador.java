/*
Ejemplo de carrito en el que se guarda en sesion el objeto servicio
 */
package controlador;

import java.io.IOException;
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


/**
 *
 * @author jesus
 */
@WebServlet(name = "ServletComtrolador", urlPatterns = {"/comprar", "/finalizar", "/confirmar"})
public class ServletComtrolador extends HttpServlet {
    

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        FachadaBeanLocal servicio = null;
        String destino = null;
        String accion = request.getServletPath();
        
        if (accion.equals("/comprar")) {
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            String auxp = request.getParameter("precio");
            float precio = Float.parseFloat(auxp);
            Articulo art = new Articulo(codigo,nombre, precio);
            HttpSession session = request.getSession();
             servicio = (FachadaBeanLocal)session.getAttribute("servicio");
             
            if (servicio == null) {
                servicio = lookupFachadaBeanLocal();
                System.out.println("---->Consigo SB primero "+servicio);
                session.setAttribute("servicio", servicio);
            }
            System.out.println("---->servicio en comprar: "+ servicio);
            servicio.comprar(art);
            
            // en lñas JSP se podria manejar el Servicio pero
            // usamos mejor Cesta, obj del modelo
            CestaCompra cesta = servicio.getCesta();

            session.setAttribute("cesta", cesta);

            destino = "/index.jsp";
        } else if (accion.equals("/finalizar")) {
            destino = "/tomadatos.jsp";
        } else if (accion.equals("/confirmar")) {
            String nombre = request.getParameter("nombre");
            String dir = request.getParameter("direccion");
            Comprador comprador = new Comprador(nombre, dir);
 
            HttpSession session = request.getSession();
            servicio = (FachadaBeanLocal) session.getAttribute("servicio");
            System.out.println("---->servicio en confirmar: "+ servicio);
            
            servicio.confirmar(comprador);
            session.invalidate();
            request.setAttribute("pedidofinal", servicio.getCesta());
            request.setAttribute("comprador", comprador);
            destino = "/gracias.jsp";
        }



        getServletContext().getRequestDispatcher(destino).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private FachadaBeanLocal lookupFachadaBeanLocal() {
        FachadaBeanLocal retorno=null;
        try {
            Context c = new InitialContext();
            retorno= (FachadaBeanLocal) c.lookup("java:module/FachadaBean");
        } catch (NamingException ne) {
            System.out.println("Horrrror en lookup"+ne);
        } 
        return retorno;
    }
}
