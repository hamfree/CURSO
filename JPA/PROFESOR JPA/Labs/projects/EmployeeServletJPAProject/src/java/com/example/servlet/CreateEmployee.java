package com.example.servlet;

import com.example.entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "CreateEmployee", urlPatterns = { "/CreateEmployee" } )
public class CreateEmployee
    extends HttpServlet
{
    @Override
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response )
        throws ServletException, IOException
    {
        response.setContentType( "text/html;charset=UTF-8" );
        try( PrintWriter out = response.getWriter() ) {
            out.println( "<html>" );
            out.println( "<head>" );
            out.println( "<title>Create a new Employee Record</title>" );
            out.println( "</head>" );
            out.println( "<body>" );
            out.println( "<h1>Enter New Employee information</h1>" );
            out.println( "<form action=\"" + request.getContextPath() + "/CreateEmployee\" method=\"post\">" );
            out.println( "First name: <input type=\"text\" name=\"firstname\" /><br />" );
            out.println( "Last name: <input type=\"text\" name=\"lastname\" /><br />" );
            out.println( "Birth date: <input type=\"date\" name=\"birthdate\"  />ex: 1970-10-03<br />" );
            out.println( "Salary: <input type=\"number\" name=\"salary\" />ex: 101345.56<br />" );
            out.println( "<input type=\"submit\" value=\"Submit\" />" );
            out.println( "</form>" );
            out.println( "<p><a href=" + request.getContextPath() + ">Back</a>" );
            out.println( "</body>" );
            out.println( "</html>" );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response )
        throws ServletException, IOException
    {
        response.setContentType( "text/html;charset=UTF-8" );
        PrintWriter out = response.getWriter();
        String firstName = request.getParameter( "firstname" );
        String lastName = request.getParameter( "lastname" );
        Employee emp = null;

        // Try the conversion of the birth and salary strings
        try {
            SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" );
            String birthDateStr = request.getParameter( "birthdate" ).trim();
            Date birthDate = new Date( df.parse( birthDateStr ).getTime() );
            String salaryStr = request.getParameter( "salary" ).trim();
            float salary = Float.parseFloat( salaryStr );
            emp = new Employee( firstName, lastName, birthDate, salary );
        }
        catch( NumberFormatException | ParseException pe ) {
            request.setAttribute( "errorMessage", "Exception parsing: " + pe );
            RequestDispatcher rd = request.getRequestDispatcher( "failure.jsp" );
            rd.forward( request, response );
            return;
        }

        // Add your code here
        try {
            out.println( "<html>" );
            out.println( "<head>" );
            out.println( "<title>Success</title>" );
            out.println( "</head>" );
            out.println( "<body>" );
            out.println( "<h1>Created New Employee</h1><br/>" );
            out.println( "ID: " + emp.getId() + "<br/>" );
            out.println( "First Name: " + emp.getFirstName() + "<br/>" );
            out.println( "Last Name: " + emp.getLastName() + "<br/>" );
            out.println( "Birth Date: " + emp.getBirthDate() + "<br/>" );
            out.println( "Salary: " + emp.getSalary() + "<br/>" );
            out.println( "<p><a href=" + request.getContextPath() + ">Back</a>" );
            out.println( "</body>" );
            out.println( "</html>" );
        }
        finally {
            out.close();
        }
    }
}
