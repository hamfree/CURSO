/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paq1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesus
 */
@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet", "/resultado"})
public class MiServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getServletPath().equals("/MiServlet")) {

            String[] a = new String[30];
            int i = 0;
            a[i] = "Anna";
            i++;
            a[i] = "Brittany";
            i++;
            a[i] = "Cinderella";
            i++;
            a[i] = "Diana";
            i++;
            a[i] = "Eva";
            i++;
            a[i] = "Fiona";
            i++;
            a[i] = "Gunda";
            i++;
            a[i] = "Hege";
            i++;
            a[i] = "Inga";
            i++;
            a[i] = "Johanna";
            i++;
            a[i] = "Kitty";
            i++;
            a[i] = "Linda";
            i++;
            a[i] = "Nina";
            i++;
            a[i] = "Ophelia";
            i++;
            a[i] = "Petunia";
            i++;
            a[i] = "Amanda";
            i++;
            a[i] = "Raquel";
            i++;
            a[i] = "Cindy";
            i++;
            a[i] = "Doris";
            i++;
            a[i] = "Eve";
            i++;
            a[i] = "Evita";
            i++;
            a[i] = "Sunniva";
            i++;
            a[i] = "Tove";
            i++;
            a[i] = "Unni";
            i++;
            a[i] = "Violet";
            i++;
            a[i] = "Liza";
            i++;
            a[i] = "Elizabeth";
            i++;
            a[i] = "Ellen";
            i++;
            a[i] = "Wenche";
            i++;
            a[i] = "Vicky";
            i++;
           
            String parq = request.getParameter("q");
            //buscar sugerencias
            String hint = null;
            if (parq.length() > 0) {
                hint = "";
                for (i = 0; i < a.length; i++) {

                    if (a[i].toLowerCase().startsWith(parq.toLowerCase())) {
                        if (hint.equals("")) {
                            hint = a[i];
                        } else {
                            hint = hint + " , " + a[i];
                        }
                    }
                }
            }

            // Pon la salida a "No hay sugerencias" si no se encuentran
            // o a los valores correctos
            String sugerencia = null;
            if (hint.equals("")) {
                sugerencia = "No hay sugerencias";
            } else {
                 sugerencia = hint;
            }

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MiServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println(sugerencia);
                out.println("</body>");
                out.println("</html>");
            }
        } else if (request.getServletPath().equals("/resultado")) {
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet MiServlet</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Hola " + request.getParameter("txt1") + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
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
