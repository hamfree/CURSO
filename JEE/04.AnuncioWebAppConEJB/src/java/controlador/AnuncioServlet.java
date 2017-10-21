package controlador;

import modelo.Anuncio;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Delegado;
import modelo.Usuario;

@WebServlet(name = "AnuncioServlet", urlPatterns = {"/usuario", "/anuncio"})
public class AnuncioServlet extends HttpServlet {

    private static final long serialVersionUID = -1160805394105279400L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getServletPath();
        System.out.println("-->" + accion);

        if (accion.equals("/usuario")) {
            String u = request.getParameter("user");
            String p = request.getParameter("pass");

            // Delega en la clase Delegado para la comprobación del usuario y del password y que me de los datos de user
            Delegado gestor = Delegado.getInstance();
            Usuario usu = gestor.dameUsuario(u, p);

            HttpSession ses = request.getSession(true);
            ses.setAttribute("atusuario", usu);

            request.getRequestDispatcher("anuncio.jsp").forward(request, response);

        } else if (accion.equals("/anuncio")) {
            String tem = request.getParameter("tema");
            String txt = request.getParameter("texto");
            // delegaria en LN para insertar en anuncio

            Anuncio anuncio = new Anuncio();
            anuncio.setTema(tem);
            anuncio.setTexto(txt);

            request.setAttribute("atanuncio", anuncio);

            HttpSession ses = request.getSession(false);
            Usuario u = (Usuario) ses.getAttribute("atusuario");
            request.setAttribute("atusuario", u);
            ses.invalidate();

            request.getRequestDispatcher("fin.jsp").forward(request, response);

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

}
