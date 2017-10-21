package paq1;

/*
 *
 * Copyright 2001 Sun Microsystems, Inc. All Rights Reserved.
 * 
 * This software is the proprietary information of Sun Microsystems, Inc.  
 * Use is subject to license terms.
 * 
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class RespuestaWrapper extends HttpServletResponseWrapper {

    private CharArrayWriter output;

    public String toString() {
        return output.toString();
    }

    public RespuestaWrapper(HttpServletResponse response) {

        super(response);
        output = new CharArrayWriter();
        System.out.println("Constructor de RespuestaWrapper ");
    }

    public PrintWriter getWriter() {
        System.out.println("Invocado getWriter de RespuestaWrapper");
        return new PrintWriter(output);
    }
}
