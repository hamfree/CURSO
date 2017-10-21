package controlador;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import modelo.Empleado;
import modelo.GestorEmpleados;

@WebServlet("/EjControlador")
public class EjControlador extends HttpServlet {

    public void procesarRequest(HttpServletRequest request, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("Procesando request");
        GestorEmpleados g = new GestorEmpleados();
        Empleado epl = g.dameEmpleado("pepe");
        request.setAttribute("empleado", epl);

        String url = "fin.jsp";
        request.getRequestDispatcher(url).forward(request, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        procesarRequest(req, resp);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        procesarRequest(req, resp);
    }
}
