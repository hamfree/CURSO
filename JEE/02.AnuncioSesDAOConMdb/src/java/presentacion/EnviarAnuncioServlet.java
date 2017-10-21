package presentacion;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Delegado;


@WebServlet(name = "enviarAnuncioServlet", urlPatterns = {"/enviarAnuncio"})
public class EnviarAnuncioServlet extends HttpServlet {
    private static final long serialVersionUID = 962293884334505382L;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("EnviarAnuncioServlet.processRequest() - INICIO");
        String tema = request.getParameter("tema");
        String texto = request.getParameter("texto");
        Delegado dlg = Delegado.dameInstancia();
        if (tema.length() > 0 && texto.length() > 0){
            System.out.println("....llamando al EJB e");
            dlg.enviarMensaje(tema, texto);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Portal de Anuncios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Su anuncio con el contenido:</h1> ");
            out.println("<h2>Tema: '" + tema + "' y Texto: '" + texto + "'</h2>");
            out.println("<h3>ha sido enviado al portal de anuncios. Se publicará en breve...</h3> ");
            out.println("<a href='index.html'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
        }
        System.out.println("EnviarAnuncioServlet.processRequest() - FIN");
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

}
