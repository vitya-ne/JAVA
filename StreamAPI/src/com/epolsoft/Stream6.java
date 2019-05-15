package com.epolsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream6 {
    final private static ArrayList<String> ARRAY_LIST = new ArrayList<>( Arrays.asList( "1", "2", "3" ) );

    private static void doTask() {

        Stream <String>stream;

        out.println( "List content: " + ARRAY_LIST );

        stream = ARRAY_LIST.parallelStream();
        StreamCommon.showStream( stream );
    }

    public static void main( String[] args ){

        StreamCommon.showTask(6 );
        doTask();

    }

}
