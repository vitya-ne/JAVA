package com.epolsoft.servlet;

public class Common {
    public static float getNumber( String num_str ) throws NumberFormatException {
        return Float.parseFloat( num_str );
    }

    public static float Calculate( float n1, float n2 ) {
        return n1 + n2;
    }
}
