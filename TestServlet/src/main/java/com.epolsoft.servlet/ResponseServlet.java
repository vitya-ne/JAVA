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

    private static int Calculate( String str1, String str2 ) {
        int num1, num2;

        num1 = Integer.parseInt( str1 );
        num2 = Integer.parseInt( str2 );

        return num1 + num2;
    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        String param1, param2;
        int result_val;


        param1 = request.getParameter("number1" );
        param2 = request.getParameter("number2" );

        result_val = Calculate( param1, param2 );

        response.setContentType( "text/html;charset=UTF-8" );
        response.setBufferSize( 8192 );

        request.setAttribute( "page_name", Common.getPageName() );
        request.setAttribute("number1", param1 );
        request.setAttribute("number2", param2 );
        request.setAttribute("result", result_val );

        request.getRequestDispatcher("result.jsp" ).forward( request, response );

    }

    @Override
    public String getServletInfo() {
        return "The Test Response servlet.";

    }
}
