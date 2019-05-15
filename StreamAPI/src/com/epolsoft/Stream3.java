package com.epolsoft;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream3 {
    final private static String[] ARRAY = new String[] { "a1", "a2", "a3" };

    private static void doTask() {
        Stream stream;

        StreamCommon.showTask( 3 );

        out.println( "Array: " + Arrays.asList( ARRAY ) );

        stream = Arrays.stream( ARRAY );
        StreamCommon.showStream( stream );
    }

    public static void main( String[] args ) {

        doTask();

    }
}
