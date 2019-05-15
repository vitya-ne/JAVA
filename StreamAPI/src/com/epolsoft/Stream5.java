package com.epolsoft;

import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream5 {

    static void doTask() {
        final String STR = "A string";
        Stream <String>stream;

        StreamCommon.showTask(5 );

        out.println( "String content: " + STR );

        stream = STR.chars().mapToObj( c -> Character.toString( ( char ) c ) );
        StreamCommon.showStream(stream);
    }

    public static void main( String[] args ){

        doTask();

    }

}
