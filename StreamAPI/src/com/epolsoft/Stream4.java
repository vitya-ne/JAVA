package com.epolsoft;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Stream4 {
    final private static String F_NAME = "./files/1.txt";

    private static void showFileContent() throws IOException {
        FileReader f = new FileReader( F_NAME );
        BufferedReader buf = new BufferedReader( f );
        String str;

        while ( ( str = buf.readLine() ) != null ) {
            out.println( str );
        }
    }

    private static void doTask() {
        Stream<String> stream;

        out.println( "File content: " + F_NAME );

        try {
            showFileContent();

            stream = Files.lines( Paths.get( F_NAME ) );
            StreamCommon.showStream( stream );

        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    public static void main( String[] args ){

        StreamCommon.showTask(4);
        doTask();

    }

}
