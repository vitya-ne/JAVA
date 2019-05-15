package com.epolsoft;

import java.util.stream.Stream;

import static java.lang.System.out;

class StreamCommon {
    static void showTask( int task_num ) {
        out.println( "\nTask: Stream" +
                task_num + "\n"
        );
    }

    static void showStream( Stream<?> stream ) {
        /*
         * Stream<?> instead of Stream
         *  because warning "Unchecked call to 'forEach()' as a member of raw type..
         */
        out.print( "Stream:" );

        stream.forEach( item -> out.print( " " + item ) );
        out.print( "\n" );
    }


}
