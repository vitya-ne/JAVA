package com.epolsoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet( "/result" )
public class ResponseServlet extends HttpServlet {


    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String param1, param2;
        int num1, num2;

        param1 = request.getParameter("number1" );
        param2 = request.getParameter("number2" );
        request.setAttribute("number1", param1 );
        request.setAttribute("number2", param2 );

        try {
            num1 = Common.getNumber( param1 );
            num2 = Common.getNumber( param2 );
        } catch ( NumberFormatException e ) {
            request.setAttribute("error_mess", e.toString() );
            request.getRequestDispatcher("error.jsp" ).forward( request, response );
            return;
        }

        request.setAttribute("result", Common.Calculate( num1, num2 ) );

        request.getRequestDispatcher("result.jsp" ).forward( request, response );
    }

    @Override
    public String getServletInfo() {
        return "The Test Response servlet.";

    }
}
