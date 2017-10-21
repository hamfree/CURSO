package paq1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
@MultipartConfig
public class MiServletRecibirFichero extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = null;
        
        // Como se leerian las cabecers HTTP que estan llegando al servlet
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements()){
            String h = headers.nextElement();
            System.out.println("->"+h + " - "+ request.getHeader(h));
        }
        
        Part nameField = request.getPart("name");
        BufferedReader reader = new BufferedReader(new InputStreamReader(nameField.getInputStream()));
        name = reader.readLine();
        // Alternativa:
        // name = request.getParameter("name");
        reader.close();
        if (name == null || name.trim().length() == 0) {
            name = "unknown";
        }
        
        Part part = request.getPart("filename");
        FileOutputStream ficheroSalida = new FileOutputStream("C:\\jesus\\" + name);
        InputStream in = part.getInputStream();

        byte buffer[] = new byte[4048];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) > 0) {
            ficheroSalida.write(buffer, 0, bytesRead);
        }
        in.close();
        ficheroSalida.close();
        System.out.println("Tipo contenido: " + part.getContentType());
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.write("<html><head></head><body>");
        writer.write("<h1>Upload completo</h1>");
        writer.write("<a href=\"index.html\">Volver</a>");
        writer.write("</body></html>");

    }
}
