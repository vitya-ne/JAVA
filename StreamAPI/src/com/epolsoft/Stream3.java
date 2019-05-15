package com.epolsoft;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream3 {
    private static String[] array = new String[] { "a1", "a2", "a3" };

    static void doTask() {
        Stream stream;

        StreamCommon.showTask( 3 );

        out.println( "Array: " + Arrays.asList( array ) );

        stream = Arrays.stream( array );
        StreamCommon.showStream( stream );
    }

    public static void main( String[] args ) {

        doTask();

    }
}
