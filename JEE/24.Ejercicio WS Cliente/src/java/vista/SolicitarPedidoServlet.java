package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import ws.Pedido;
import ws.WS1_Service;

@WebServlet(name = "SolicitarPedidoServlet", urlPatterns = {"/solicitarInfo"})
public class SolicitarPedidoServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/curso-pc_8080/Ejercicio_WS_WS1/WS1.wsdl")
    private WS1_Service service;
    private static final long serialVersionUID = 5256398583991804912L;

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
        System.out.println("Servlet.processRequest() - INICIO");
        StringBuilder sb = new StringBuilder();
        Pedido p = new Pedido();
        String codPedido = request.getParameter("codPedido");
        if (!codPedido.isEmpty()) {
            System.out.println("...llamando a WS1.damePedido()...");
            p = damePedido(codPedido);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                sb.append("<!DOCTYPE html>")
                        .append("<html>")
                        .append("<head>")
                        .append("<title>Ejercicio Web Service. Cliente</title>")
                        .append("</head>")
                        .append("<body style='font-family:monospace'>")
                        .append("<h1>Información sobre su pedido : ")
                        .append(codPedido)
                        .append("</h1>")
                        .append("<p>")
                        .append("Codigo de pedido..:")
                        .append(p.getCodPedido())
                        .append("<br/>")
                        .append("Estado............:")
                        .append(p.getEstado())
                        .append("<br/>")
                        .append("Distribuido por ..:")
                        .append(p.getDistribuidoPor())
                        .append("<br/>")
                        .append("</p>")
                        .append("<p><a href='index.html'>Volver al inicio</p>")
                        .append("</body>")
                        .append("</html>");
                out.println(sb.toString());
            }
        } else {
            sb.append("<!DOCTYPE html>")
                    .append("<html>")
                    .append("<head>")
                    .append("<title>Ejercicio Web Service. Cliente</title>")
                    .append("</head>")
                    .append("<body>")
                    .append("<h1>Indicame un codigo de pedido, criatura...")
                    .append("</h1>")
                    .append("<p><a href='index.html'>Volver al inicio</p>")
                    .append("</body>").append("</html>");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println(sb.toString());
            }

        }
        System.out.println("Servlet.processRequest() - FIN");
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
    }// </editor-fold>// </editor-fold>

    private Pedido damePedido(java.lang.String idPedido) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        ws.WS1 port = service.getWS1Port();
        return port.damePedido(idPedido);
    }

}
