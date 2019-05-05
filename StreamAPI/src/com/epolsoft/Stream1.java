package com.epolsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import static java.lang.System.out;

public class Stream1 {

    private static ArrayList<String> arrayList = new ArrayList<>( Arrays.asList( "a1", "a2", "a3" ) );

    static void doTask() {

        Stream stream;

        StreamCommon.showTask( 1 );

        out.println( "ArrayList: " + arrayList );

        stream = arrayList.stream();
        StreamCommon.showStrim( stream );

    }

    public static void main( String[] args ) {

        doTask();

    }
}
