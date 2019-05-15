package com.epolsoft;

import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream7 {

    static void doTask( int input_num ) {
        Stream stream;

        StreamCommon.showTask(7 );

        out.println( "Input: " + input_num );

        stream = Stream.iterate( input_num, x -> x * x );
        StreamCommon.showStream( stream.limit( 5 ) );
    }

    public static void main( String[] args ){

        doTask( 1 );
        doTask( 2 );

    }

}
