package com.epolsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream6 {

    static void doTask() {
        ArrayList<String> arrayList = new ArrayList<>( Arrays.asList( "1", "2", "3" ) );
        Stream <String>stream;

        StreamCommon.showTask(6 );

        out.println( "List content: " + arrayList );

        stream = arrayList.parallelStream();
        StreamCommon.showStream( stream );
    }

    public static void main( String[] args ){

        doTask();

    }

}
