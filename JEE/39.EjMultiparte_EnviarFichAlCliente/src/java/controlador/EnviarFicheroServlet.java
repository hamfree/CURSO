/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author curso
 */
@WebServlet(name = "EnviarFicheroServlet", urlPatterns = {"/enviarFichero"})
public class EnviarFicheroServlet extends HttpServlet {

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

        String nombre = request.getParameter("nombre");

        if (nombre.length() == 0) {
            nombre = "desconocido.dat";
        }

        // Comprobamos que existe el fichero....
        Path path = FileSystems.getDefault().getPath("c:\\temporal\\", nombre);
        if (Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
            // He de poner una cabecera en la respuesta para indicar que se le manda un attachment con un fichero al cliente:
            response.setHeader("Content-Disposition", "attachment; filename=" + nombre);
            response.setContentType("application/octet-stream");

            // Localizar el fichero que me dice el cliente y abrir un flujo de entrada para leerlo (FileInputStream)
            // Seguún lo lea, lo enchufo a la salida del servlet
            try (ServletOutputStream out = response.getOutputStream()) {
                // Localizar el fichero que me dice el cliente y abrir un flujo de entrada para leerlo (FileInputStream)
                // Seguún lo lea, lo enchufo a la salida del servlet
                File f = new File("c:\\temporal\\" + nombre);
                try (FileInputStream fin = new FileInputStream(f)) {
                    byte buffer[] = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = fin.read(buffer)) > 0) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
            }
        } else {
            response.setContentType("text/html");
            request.setAttribute("nombre", nombre);
            request.getRequestDispatcher("noexiste.jsp").forward(request, response);
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
