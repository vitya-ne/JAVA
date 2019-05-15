package com.epolsoft;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream2 {
    private enum Inner{ a1, a2, a3 }

    private static void doTask() {
        Stream stream;

        out.println( "Enum: " + Arrays.asList( Inner.values() ) );

        stream = Arrays.stream( Inner.values() );
        StreamCommon.showStream( stream );

    }

    public static void main( String[] args ) {

        StreamCommon.showTask( 2 );
        doTask();

    }
}
