package paq1;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "MiServlet", urlPatterns = {"/MiServlet"})
public class MiServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/octet-stream");
       
        String name = request.getParameter("name");
        
         System.out.println("-->"+getServletContext().getMimeType(name));
         
        response.setHeader("Content-Disposition", "attachment; filename=" + name);

        try(FileInputStream in = new FileInputStream("C:\\jesus\\" + name);

        ServletOutputStream out = response.getOutputStream();){

        byte buffer[] = new byte[4048];
        int bytesRead;
       
        while ((bytesRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, bytesRead);
            
        }
        }
       
    }

}
