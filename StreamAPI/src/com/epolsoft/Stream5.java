package com.epolsoft;

import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream5 {
    final static private String STR = "A string";

    private static void doTask() {
        Stream <String>stream;

        out.println( "String content: " + STR );

        stream = STR.chars().mapToObj( c -> Character.toString( ( char ) c ) );
        StreamCommon.showStream( stream );
    }

    public static void main( String[] args ){

        StreamCommon.showTask(5 );
        doTask();

    }

}
