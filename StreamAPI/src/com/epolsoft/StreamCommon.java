package com.epolsoft;

import java.util.stream.Stream;

import static java.lang.System.out;

public class StreamCommon {
    public static void showTask( int task_num ) {
        out.println( "\nStream" +
                task_num + "\n"
        );
    }

    public static void showStrim( Stream stream ) {
        out.print( "Stream:" );

        stream.forEach( item -> System.out.print( " " + item ) );
    }


}
