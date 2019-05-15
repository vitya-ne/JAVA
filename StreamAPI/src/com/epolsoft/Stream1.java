package com.epolsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import static java.lang.System.out;

public class Stream1 {

    final private static ArrayList<String> ARRAY_LIST = new ArrayList<>( Arrays.asList( "a1", "a2", "a3" ) );

    private static void doTask() {
        Stream stream;

        out.println( "ArrayList: " + ARRAY_LIST );

        stream = ARRAY_LIST.stream();
        StreamCommon.showStream( stream );

    }

    public static void main( String[] args ) {

        StreamCommon.showTask( 1 );
        doTask();

    }
}
