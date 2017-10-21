package com.example.servlet;

import com.example.entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "ListEmployees", urlPatterns = { "/ListEmployees" } )
public class ListEmployees
    extends HttpServlet
{
    @PersistenceUnit( unitName = "EmployeePU" )
    private EntityManagerFactory emf;

    protected void processRequest( HttpServletRequest request,
        HttpServletResponse response )
        throws ServletException, IOException
    {
        response.setContentType( "text/html;charset=UTF-8" );
        try( PrintWriter out = response.getWriter() ) {
            out.println( "<html>" );
            out.println( "<head>" );
            out.println( "<title>List of current Employees</title>" );
            out.println( "</head>" );
            out.println( "<body>" );
            out.println( "<table border='1'>" );
            out.println( "<tr><th>Employee ID</th><th>First Name</th><th>Last Name</th><th>Birth Date</th><th>Salary</th></tr>" );

            // Solution code:
            EntityManager em = emf.createEntityManager();
            TypedQuery<Employee> query = em.createQuery( "SELECT e FROM Employee e", Employee.class );
            List<Employee> emps = query.getResultList();
            for ( Employee e : emps ) {
                out.print( "<tr>" );
                out.print( "<td>" + e.getId() + "</td>" );
                out.print( "<td>" + e.getFirstName() + "</td>" );
                out.print( "<td>" + e.getLastName() + "</td>" );
                out.print( "<td>" + new SimpleDateFormat( "yyyy-MM-dd" ).format( e.getBirthDate() ) + "</td>" );
                out.print( "<td>" + NumberFormat.getCurrencyInstance().format( (double) e.getSalary() ) + "</td>" );
                out.println( "</tr>" );
            }

            out.println( "</table>" );
            out.println( "<p><a href=" + request.getContextPath() + ">Back</a>" );
            out.println( "</body>" );
            out.println( "</html>" );
        }
    }

    @Override
    protected void doGet( HttpServletRequest request,
        HttpServletResponse response )
        throws ServletException, IOException
    {
        processRequest( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request,
        HttpServletResponse response )
        throws ServletException, IOException
    {
        processRequest( request, response );
    }
}
