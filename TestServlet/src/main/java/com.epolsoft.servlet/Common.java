package com.epolsoft.servlet;

public class Common {
    public static int getNumber( String num_str ) throws NumberFormatException {
        return Integer.parseInt( num_str );
    }

    public static int Calculate( int n1, int n2 ) {
        return n1 + n2;
    }
}
