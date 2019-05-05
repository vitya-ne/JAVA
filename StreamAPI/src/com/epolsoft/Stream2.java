package com.epolsoft;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream2 {
    private enum Inner{ a1, a2, a3 }

    static void doTask() {
        Stream stream;

        StreamCommon.showTask( 2 );

        out.println( "Enum: " + Arrays.asList( Inner.values() ) );

        stream = Arrays.stream( Inner.values() );
        StreamCommon.showStrim( stream );

    }

    public static void main( String[] args ) {

        doTask();

    }
}
